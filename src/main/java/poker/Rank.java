package poker;

public enum Rank {
    CLUB(1),
    DIAMOND(2),
    HEART(3),
    SPADE(4);

    private int value;
    public int getValue() {
        return value;
    }
    Rank(int value){
        this.value = value;
    }
}
