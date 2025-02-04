package framework;

import uno.UnoCard;
import utils.GameUtility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand<C extends Comparable<C>> {
    protected List<C> cards = new ArrayList<>();

    public List<C> getAll(){
        return new ArrayList<C>(cards);
    }

    public void add(C card){
        cards.add(card);
        Collections.sort(cards);
    }

    public void remove(C card){
        for (int index = 0; index < cards.size(); index++){
            if (cards.get(index).equals(card)){
                cards.remove(index);
                break;
            }
        }
    }

    public boolean isEmpty(){
        return cards.isEmpty();
    }

    @Override
    public String toString(){
        return GameUtility.formate(cards);
    }
}
