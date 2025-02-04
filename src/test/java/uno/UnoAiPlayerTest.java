package uno;

import framework.Deck;
import framework.Hand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UnoAiPlayerTest {
    private List<UnoCard> cards;
    private Hand<UnoCard> hand;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        cards = createUnoCards();

        hand = new Hand<UnoCard>();
        hand.add(cards.get(3));
        hand.add(cards.get(6));
        hand.add(cards.get(14));
        hand.add(cards.get(18));
        hand.add(cards.get(25));
        hand.add(cards.get(26));
        hand.add(cards.get(36));
        hand.add(cards.get(39));
    }

    private static List<UnoCard> createUnoCards(){
        ArrayList<UnoCard> cards = new ArrayList<UnoCard>();
        for (Color color : Color.values()){
            for (Number number : Number.values()){
                cards.add(new UnoCard(color, number));
            }
        }
        return cards;
    }

    @org.junit.jupiter.api.Test
    void nameHimself() {
        for (int i = 0; i < 4; i++){
            var player = new UnoAiPlayer(hand);
            player.nameHimself();
            System.out.println(player.getName());
        }
    }

    @org.junit.jupiter.api.Test
    void play() {
        var player = new UnoAiPlayer(hand);
        var expect = new UnoCard(Color.RED, Number._5);
        var actual = player.play(Arrays.asList(new UnoCard(Color.RED, Number._5)));
        Assertions.assertEquals(expect, actual);
    }

    @Test
    void drawCard() {
        var deck = new Deck<UnoCard>();
        deck.add(Arrays.asList(new UnoCard(Color.GREEN, Number._1)));

        hand = new Hand<UnoCard>();
        hand.add(new UnoCard(Color.RED, Number._5));
        var player = new UnoAiPlayer(hand);

        player.drawCard(deck);
        Assertions.assertTrue(player.getHand().getAll().contains(new UnoCard(Color.GREEN, Number._1)));
    }
}