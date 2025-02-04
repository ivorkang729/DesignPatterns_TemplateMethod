package poker;

import framework.Hand;

import java.util.*;

public class PokerAiPlayer extends PokerPlayer {
    private static List<String> TWICE = new ArrayList<>(Arrays.asList("나연", "정연", "모모", "사나"));

    public PokerAiPlayer(){
        super();
    }

    public PokerAiPlayer(Hand<PokerCard> hand){
        super(hand);
    }

    @Override
    public void nameHimself(){
        Collections.shuffle(TWICE);
        setName(TWICE.remove(0));
    }

    @Override
    protected int makeDecision(List<PokerCard> options) {
        //隨機選擇出牌
        return new Random().nextInt(options.size());
    }
}
