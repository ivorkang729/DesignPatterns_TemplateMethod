package framework;

import java.util.List;

public abstract class Game<C extends Comparable<C>> {
    //四位玩家
    protected List<Player<C>> players;
    //牌堆
    protected Deck<C> deck;
    //現在是第幾輪(turn)?
    protected int turnNumber = -1;

    public Game(List<Player<C>> players, Deck<C> deck){
        this.players = players;
        this.deck = deck;
    }

    public void start(){
        playersNameHimself();
        deckShuffle();
        playerDrawHandCard();
        setupInitialState();
        while(true){
            turnNumber ++;

            //0  0
            //1  1
            //2  2
            //3  3
            //4  0
            var player = players.get(turnNumber % players.size());
            playerTakesTurn(player);

            var winner = findWinner();
            if (winner != null) {
                showWinner(winner);
                break;
            }
        }
    }

    private void playersNameHimself(){
        players.forEach(player -> player.nameHimself());
    }

    private void deckShuffle(){
        deck.shuffle();
    }

    private void playerDrawHandCard(){
        //玩家輪流從牌堆中抽牌，直到所有人都擁有手牌 n張牌 為止
        for (int i = 0; i < initialHandSize(); i++){
            players.forEach(player -> player.drawCard(deck));
        }
    }

    /**手牌的初始張數 */
    protected abstract int initialHandSize();

    /** 遊戲開始前的初始設定 */
    protected abstract void setupInitialState();

    private void playerTakesTurn(Player<C> player){
        showTurnInfo(player);
        if (!checkPlayerStateBeforePlayerPlay(player)){ return; }
        var thePlayedCard = player.play(getOptions(player));
        handleThePlayedCard(thePlayedCard);
    }

    /** 顯示本輪資訊 */
    protected abstract void showTurnInfo(Player<C> player);

    /** 玩家出牌前狀態檢查 */
    protected abstract boolean checkPlayerStateBeforePlayerPlay(Player<C> player);

    /** 遊戲找出玩家能出的牌有哪些 */
    protected abstract List<C> getOptions(Player<C> player);

    /** 處理玩家出牌內容 */
    protected abstract void handleThePlayedCard(C thePlayedCard);

    /** 遊戲的贏家
     *  若贏家還沒出現則 return null
     * */
    protected abstract Player<C> findWinner();

    private void showWinner(Player<C> winner){
        System.out.println("贏家是: "+ winner.getName());
        System.out.println("遊戲結束");
    }

}
