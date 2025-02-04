package uno;

import framework.Hand;
import framework.Player;
import utils.GameUtility;

import java.util.List;
import java.util.Scanner;

public class UnoHumanPlayer extends Player<UnoCard> {

    public UnoHumanPlayer(){
        super();
    }

    public UnoHumanPlayer(Hand<UnoCard> hand){
        super(hand);
    }

    @Override
    public void nameHimself(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        setName(scanner.nextLine());
    }

    @Override
    protected int makeDecision(List<UnoCard> options) {
        //顯示可出的牌
        System.out.print("Your Options: ");
        System.out.println(GameUtility.formate(options));
        //出牌決策
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your decision: ");
            int decision = Integer.parseInt(scanner.nextLine());
            if (decision < options.size()) {
                return decision;
            }
        }
    }

}
