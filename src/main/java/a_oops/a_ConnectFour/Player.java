package a_oops.a_ConnectFour;

public class Player {
    private final String name;
    private final GridPosition piece;

    public Player(String name, GridPosition piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return this.name;
    }

    public GridPosition getPieceColor() {
        return this.piece;
    }
}
