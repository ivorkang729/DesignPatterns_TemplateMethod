package poker;

import framework.Deck;
import framework.Game;
import framework.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerGame extends Game<PokerCard> {

    //紀錄4位玩家本回合出了什麼牌
    private List<PokerCard> shownCards = new ArrayList<>(Collections.nCopies(4, null));

    //現在是第幾回合?
    private int roundNumber = 0;

    public PokerGame(List<Player<PokerCard>> players, Deck<PokerCard> deck){
        super(players, deck);
    }

    /**手牌的初始張數 */
    @Override
    protected int initialHandSize(){
        return 13;
    }

    /** 遊戲開始前的初始設定 */
    @Override
    protected void setupInitialState(){
        //無此規則
    }

    /** 顯示本輪資訊 */
    @Override
    protected void showTurnInfo(Player<PokerCard> player){
        //顯示第幾回合
        int index = turnNumber % players.size();
        if (index == 0){
            roundNumber ++;
            System.out.println("\r\n第" + roundNumber + "回合");
        }

        //顯示姓名
        System.out.println("輪到玩家: " + player.getName());
    }

    /** 玩家出牌前狀態檢查 */
    @Override
    protected boolean checkPlayerStateBeforePlayerPlay(Player<PokerCard> player){
        //無此規則
        return true;
    }

    /** 遊戲找出玩家能出的牌有哪些 */
    @Override
    protected List<PokerCard> getOptions(Player<PokerCard> player){
        //找能出的牌  整副手牌都可以出
        return player.getHand().getAll();
    }

    @Override
    protected void handleThePlayedCard(PokerCard thePlayedCard){
        //第幾輪  Player's Index
        //  0  0
        //  1  1
        //  2  2
        //  3  3
        //  4  0

        //Game有上帝視角，記下玩家出了什麼牌
        int index = turnNumber % players.size();
        shownCards.set(index, thePlayedCard);

        //4位玩家都已於本回合出牌，本回合結束?
        //若 turnNumber % 4 == 3, 表示四位玩家都已於本回合出牌
        if (index == (players.size() - 1)){
            //顯示所有玩家的出牌內容
            for (int i = 0; i < players.size(); i++){
                System.out.println(players.get(i) + "的出牌內容: " + shownCards.get(i));
            }

            //將所有玩家的出牌內容比大小決勝負，將最勝者的分數加一
            var winnerOfThisRound = findWinnerOfThisRound();
            ((PokerPlayer)winnerOfThisRound).addPoint();
            System.out.println("本回合勝者: " + winnerOfThisRound.getName());
        }
    }

    /** 找出本回合的勝者 */
    private Player<PokerCard> findWinnerOfThisRound(){
        int winner = 0;
        PokerCard maxCard = shownCards.get(winner);
        for (int i = 1; i < players.size(); i++){
            if (shownCards.get(i).compareTo(maxCard) > 0){
                winner = i;
                maxCard = shownCards.get(i);
            }
        }
        return players.get(winner);
    }

    /** 遊戲的贏家
     *  若贏家還沒出現則 return null
     * */
    @Override
    protected Player<PokerCard> findWinner(){
        //System.out.println(turnNumber);
        if (turnNumber < 51){ //遊戲尚未結束，還沒有贏家
            return null;
        }

        int index_winner = 0;
        int maxPoint = ((PokerPlayer)players.get(0)).getPoint();
        for (int i = 1; i < players.size(); i++){
            if (((PokerPlayer)players.get(i)).getPoint() > maxPoint){
                index_winner = i;
                maxPoint = ((PokerPlayer)players.get(index_winner)).getPoint();
            }
        }
        return players.get(index_winner);
    }

}
