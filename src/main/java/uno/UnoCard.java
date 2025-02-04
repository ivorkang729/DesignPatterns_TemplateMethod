package uno;

import java.util.Objects;

public class UnoCard implements Comparable<UnoCard>{
    private Color color;
    public Color getColor() {
        return color;
    }

    private Number number;
    public Number getNumber() {
        return number;
    }

    public UnoCard(Color color, Number number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public int compareTo(UnoCard o) {
        if (color.getSequence() == o.color.getSequence()){
            return number.getSequence() - o.number.getSequence();
        }
        return color.getSequence() - o.color.getSequence();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnoCard unoCard = (UnoCard) o;
        return color == unoCard.color && number == unoCard.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, number);
    }

    @Override
    public String toString(){
        return color.name() + number.name();
    }


}
