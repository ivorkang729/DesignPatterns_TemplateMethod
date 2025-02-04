package poker;

import framework.Hand;
import framework.Player;

public abstract class PokerPlayer extends Player<PokerCard> {

    private int point;
    public int getPoint() {
        return point;
    }

    public PokerPlayer(){
        super();
    }

    public PokerPlayer(Hand<PokerCard> hand){
        super(hand);
    }

    public void addPoint(){
        point ++;
    }

}
