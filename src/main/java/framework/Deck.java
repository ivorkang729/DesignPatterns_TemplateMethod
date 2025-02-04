package framework;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck<C extends Comparable<C>> {
    private Stack<C> stack = new Stack<>();

    public void add(List<C> cards){
        stack.addAll(cards);
    }

    public void shuffle(){
        Collections.shuffle(stack);
    }

    public C drawCard(){
        return stack.pop();
    }

    public boolean isEmpty(){
       return stack.isEmpty();
    }

}
