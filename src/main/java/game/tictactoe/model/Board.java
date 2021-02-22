package game.tictactoe.model;

public class Board {
    private String[][] size;

    public Board(String[][] size) {
        this.size = size;
    }

    public String[][] getSize() {
        return size;
    }

    public void setSize(String[][] size) {
        this.size = size;
    }
}
