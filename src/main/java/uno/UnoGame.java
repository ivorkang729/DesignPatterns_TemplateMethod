package uno;

import framework.Deck;
import framework.Game;
import framework.Player;

import java.util.ArrayList;
import java.util.List;

public class UnoGame extends Game<UnoCard> {
    //頂牌
    private UnoCard top;
    //檯面上其它使用過的牌
    private List<UnoCard> usedCards = new ArrayList<>();

    public UnoGame(List<Player<UnoCard>> players, Deck<UnoCard> deck){
        super(players, deck);
    }

    /**手牌的初始張數 */
    @Override
    protected int initialHandSize(){
        return 5;
    }

    /** 遊戲開始前的初始設定 */
    @Override
    protected void setupInitialState(){
        //從牌堆中翻出第一張牌到檯面上
        top = deck.drawCard();
    }

    /** 顯示本輪資訊 */
    @Override
    protected void showTurnInfo(Player<UnoCard> player){
        //顯示姓名
        System.out.println("\r\n輪到玩家: " + player.getName());
        //顯示頂牌
        System.out.println("Top Card: " + top);
        //顯示手牌
        System.out.println(player.getHand());
    }

    /** 玩家出牌前狀態檢查 */
    @Override
    protected boolean checkPlayerStateBeforePlayerPlay(Player<UnoCard> player){
        var options = getOptions(player);
        if (options.isEmpty()){
            player.drawCard(deck);
            if (deck.isEmpty()){
                deck.add(usedCards);
                deck.shuffle();
                usedCards = new ArrayList<>();
            }
            return false;
        }
        return true;
    }

    @Override
    protected List<UnoCard> getOptions(Player<UnoCard> player){
        //找能出的牌  花色/數字相同
        return player.getHand().getAll().stream().filter(card -> {
            return card.getColor() == top.getColor() || card.getNumber() == top.getNumber();
        }).toList();
    }

    @Override
    protected void handleThePlayedCard(UnoCard thePlayedCard){
        usedCards.add(top);
        top = thePlayedCard;
    }

    @Override
    protected Player<UnoCard> findWinner(){
        return players.stream().filter(player -> player.getHand().isEmpty()).findFirst().orElse(null);
    }

}
