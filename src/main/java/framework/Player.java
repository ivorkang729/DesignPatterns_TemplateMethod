package framework;

import java.util.List;

public abstract class Player<C extends Comparable<C>>{
    private String name;
    public String getName(){
        return name;
    }
    protected void setName(String name){
        this.name = name;
    }

    private Hand<C> hand;
    public Hand<C> getHand(){
        return hand;
    }

    public Player(){
        this.hand = new Hand<C>();
    }

    public Player(Hand<C> hand){
        this.hand = hand;
    }

    public abstract void nameHimself();

    public void drawCard(Deck<C> deck){
        if(deck.isEmpty()){
            throw new IllegalArgumentException("Deck cannot be empty.");
        }
        System.out.println("Player " + getName() + " draws a card.");
        getHand().add(deck.drawCard());
    }

    public C play(List<C> options) {
        //樣板方法
        if (options.isEmpty()){
            throw new IllegalArgumentException("Options cannot be an empty list.");
        }
        var decision = options.get(makeDecision(options));
        getHand().remove(decision);
        return decision;
    }

    protected abstract int makeDecision(List<C> options);

}
