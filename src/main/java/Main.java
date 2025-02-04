import framework.Deck;
import framework.Player;
import poker.PokerCard;
import poker.PokerGame;
import poker.PokerHumanPlayer;
import poker.Rank;
import uno.Color;
import uno.UnoCard;
import uno.UnoGame;
import uno.UnoHumanPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        createUnoGame().start();
//        createPokerGame().start();
    }

    private static UnoGame createUnoGame(){
        var player1 = new UnoHumanPlayer();
        var player2 = new UnoHumanPlayer();
        var player3 = new UnoHumanPlayer();
        var player4 = new UnoHumanPlayer();
        List<Player<UnoCard>> players = Arrays.asList(player1, player2, player3, player4);

        var deck = new Deck<UnoCard>();
        deck.add(createUnoCards());

        return new UnoGame(players, deck);
    }

    private static List<UnoCard> createUnoCards(){
        ArrayList<UnoCard> cards = new ArrayList<>();
        for (Color color : Color.values()){
            for (uno.Number number : uno.Number.values()){
                cards.add(new UnoCard(color, number));
            }
        }
        return cards;
    }

    private static PokerGame createPokerGame(){
        var player1 = new PokerHumanPlayer();
        var player2 = new PokerHumanPlayer();
        var player3 = new PokerHumanPlayer();
        var player4 = new PokerHumanPlayer();
        List<Player<PokerCard>> players = Arrays.asList(player1, player2, player3, player4);

        var deck = new Deck<PokerCard>();
        deck.add(createPokerCards());

        return new PokerGame(players, deck);
    }

    private static List<PokerCard> createPokerCards(){
        ArrayList<PokerCard> cards = new ArrayList<>();
        for (Rank rank : Rank.values()){
            for (poker.Number number : poker.Number.values()){
                cards.add(new PokerCard(rank, number));
            }
        }
        return cards;
    }

}
