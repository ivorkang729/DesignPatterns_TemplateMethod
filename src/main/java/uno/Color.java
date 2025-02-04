package uno;

public enum Color {
    BLUE(1),
    RED(2),
    YELLOW(3),
    GREEN(4);

    private int sequence;
    public int getSequence() {
        return sequence;
    }
    Color(int sequence){
        this.sequence = sequence;
    }
}
