package game.tictactoe.model;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player activePlayer;
    private String mode;
    private Player winner;

    public Game(Board board, Player player1, Player player2, Player activePlayer, String mode, Player winner) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.activePlayer = activePlayer;
        this.mode = mode;
        this.winner = winner;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
