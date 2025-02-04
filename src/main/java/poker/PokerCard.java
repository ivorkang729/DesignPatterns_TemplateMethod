package poker;

import java.util.Objects;

public class PokerCard implements Comparable<PokerCard>{
    private Rank rank;
    public Rank getRank() {
        return rank;
    }

    private poker.Number number;
    public poker.Number getNumber() {
        return number;
    }

    public PokerCard(Rank rank, Number number) {
        this.rank = rank;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokerCard pokerCard = (PokerCard) o;
        return rank == pokerCard.rank && number == pokerCard.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, number);
    }

    @Override
    public String toString(){
        return rank.name() + number.name();
    }

    @Override
    public int compareTo(PokerCard o) {
        //先比較階級、若階級相同則比較花色
        if (rank.getValue() == o.rank.getValue()){
            return number.getValue() - o.number.getValue();
        }
        return rank.getValue() - o.rank.getValue();
    }

}
