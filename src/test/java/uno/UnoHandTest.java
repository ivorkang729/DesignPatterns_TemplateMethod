package uno;

import framework.Hand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @Test
    void remove() {
        Hand<UnoCard> hand = new Hand<UnoCard>();
        hand.add(new UnoCard(Color.RED, Number._5));
        hand.add(new UnoCard(Color.RED, Number._6));
        hand.add(new UnoCard(Color.BLUE, Number._5));
        hand.add(new UnoCard(Color.BLUE, Number._6));
        hand.add(new UnoCard(Color.YELLOW, Number._5));
        hand.add(new UnoCard(Color.YELLOW, Number._6));

        var target = new UnoCard(Color.BLUE, Number._5);
        hand.remove(target);
        Assertions.assertFalse(hand.getAll().contains(target));
    }
}