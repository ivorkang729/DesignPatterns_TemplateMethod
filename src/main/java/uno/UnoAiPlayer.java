package uno;

import framework.Hand;
import framework.Player;

import java.util.*;

public class UnoAiPlayer extends Player<UnoCard> {
    private static List<String> Beatles = new ArrayList<>(Arrays.asList("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr"));

    public UnoAiPlayer(){
        super();
    }

    public UnoAiPlayer(Hand<UnoCard> hand){
        super(hand);
    }

    @Override
    public void nameHimself(){
        Collections.shuffle(Beatles);
        setName(Beatles.remove(0));
    }

    @Override
    protected int makeDecision(List<UnoCard> options) {
        //隨機選擇出牌
        return new Random().nextInt(options.size());
    }
}
