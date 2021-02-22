package game.tictactoe.service;

import game.tictactoe.model.Board;
import game.tictactoe.model.Game;
import game.tictactoe.model.Player;

public class GameService {

    public Game createGame(String playerName1, String playerName2, Integer boardSize) {
        Player player1 = new Player(playerName1, "X");
        Player player2 = new Player();
        player2.setType("O");
        String mode;
        if (playerName2.equals(null)) {
            player2.setName("CPU");
            mode = "SINGLE";
        } else {
            player2.setName(playerName2);
            mode = "MULTI";
        }
        Board board = new Board(new String[boardSize][boardSize]);
        return new Game(board, player1, player2, player1, mode, null);
    }

    public Game setMark(Integer row, Integer col, Game game) {
        game.getBoard().getSize()[row][col] = game.getActivePlayer().getType();
        return game;
    }

    public Player changePlayer(Game game) {
        if (game.getActivePlayer().equals(game.getPlayer1())) {
            return game.getPlayer2();
        } else {
            return game.getPlayer1();
        }

    }
    public Player checkWinner(Integer row, Integer col, Game game) {
        if (checkHorizontal(row, col, game) || checkVertical(row, col, game)) {
            return game.getActivePlayer();
        } else {
            return null;
        }
    }

    public Boolean checkHorizontal(Integer row, Integer col, Game game) {
        int x;
        int y;
        Board board = game.getBoard();
        if ((row-2) < 0){
            x = 0;
        } else {
            x = row-2;
        }
        if ((row+2) < board.getSize().length) {
            y = 3;
        } else {
            y = board.getSize().length - row;
        }
        for (int i=x; i<x+y; i++) {
            if (board.getSize()[i][col] != null && board.getSize()[i + 1][col] != null && board.getSize()[i + 2][col] != null) {
                if(board.getSize()[i][col].equals(board.getSize()[i+1][col]) && board.getSize()[i+1][col].equals(board.getSize()[i+2][col])) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkVertical(Integer row, Integer col, Game game) {
        int x;
        int y;
        Board board = game.getBoard();
        if ((row-2) < 0){
            x = 0;
        } else {
            x = row-2;
        }
        if ((row+2) < board.getSize().length) {
            y = 3;
        } else {
            y = board.getSize().length - row;
        }
        for (int i=x; i<x+y; i++) {
            if (board.getSize()[row][i] != null && board.getSize()[row][i + 1] != null && board.getSize()[row][i + 2] != null) {
                if(board.getSize()[row][i].equals(board.getSize()[row][i+1]) && board.getSize()[row][i+1].equals(board.getSize()[row][i+2])) {
                    return true;
                }
            }
        }
        return false;
    }
}
