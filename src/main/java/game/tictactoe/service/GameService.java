package game.tictactoe.service;

import game.tictactoe.model.Board;
import game.tictactoe.model.Game;
import game.tictactoe.model.Player;

public class GameService {

    public Game createGame(String playerName1, String playerName2, Integer boardSize, String mode) {
        Player player1 = new Player(playerName1, "X");
        Player player2 = new Player();
        player2.setType("O");
        if (playerName2.equals("")) {
            player2.setName("CPU");
        } else {
            player2.setName(playerName2);
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
        Board board = game.getBoard();
        int rowStart, rowEnd, colStart, colEnd;
        rowStart = getStartPoint(row);
        rowEnd = getEndPoint(row, board.getSize().length-1);
        colStart = getStartPoint(col);
        colEnd = getEndPoint(col, board.getSize().length-1);

        int d1RowStart, d1ColStart, d1RowEnd, d2RowStart, d2ColStart, d2RowEnd;
        if ((row-2 < 0) || (col-2 < 0)) {
            if ((row-1 < 0) || (col-1 < 0)) {
                d1RowStart = row;
                d1ColStart = col;
            } else {
                d1RowStart = row-1;
                d1ColStart = col-1;
            }
        } else {
            d1RowStart = row-2;
            d1ColStart = col-2;
        }
        if ((row+2 > board.getSize().length-1) || (col+2 > board.getSize().length-1)) {
            if ((row+1 > board.getSize().length-1) || (col+1 > board.getSize().length-1)) {
                d1RowEnd = row;
            } else {
                d1RowEnd = row+1;
            }
        } else {
            d1RowEnd = row+2;
        }
        if ((row-2 < 0) || (col+2  > board.getSize().length-1)) {
            if ((row-1 < 0) || (col+1  > board.getSize().length-1)) {
                d2RowStart = row;
                d2ColStart = col;
            } else {
                d2RowStart = row-1;
                d2ColStart = col+1;
            }
        } else {
            d2RowStart = row-2;
            d2ColStart = col+2;
        }
        if ((row+2 > board.getSize().length-1) || (col-2 < 0)) {
            if ((row+1 > board.getSize().length-1) || (col-1 < 0)) {
                d2RowEnd = row;
            } else {
                d2RowEnd = row+1;
            }
        } else {
            d2RowEnd = row+2;
        }

        if (checkHorizontal(rowStart, rowEnd, col, board) || checkVertical(colStart, colEnd, row, board) || checkDiagonal(d1RowStart, d1ColStart, d1RowStart, d1RowEnd, board) || checkDiagonal2(d2RowStart, d2ColStart, d2RowStart, d2RowEnd, board)) {
            return game.getActivePlayer();
        } else {
            return null;
        }
    }

    public Boolean checkHorizontal(Integer rowStart, Integer rowEnd, Integer col, Board board) {
        for (int i=rowStart; i<rowEnd-1; i++) {
            if (board.getSize()[i][col] != null && board.getSize()[i + 1][col] != null && board.getSize()[i + 2][col] != null) {
                if(board.getSize()[i][col].equals(board.getSize()[i+1][col]) && board.getSize()[i+1][col].equals(board.getSize()[i+2][col])) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkVertical(Integer colStart, Integer colEnd, Integer row, Board board) {
        for (int i=colStart; i<colEnd-1; i++) {
            if (board.getSize()[row][i] != null && board.getSize()[row][i + 1] != null && board.getSize()[row][i + 2] != null) {
                if(board.getSize()[row][i].equals(board.getSize()[row][i+1]) && board.getSize()[row][i+1].equals(board.getSize()[row][i+2])) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkDiagonal(Integer posX, Integer posY, Integer start, Integer end, Board board) {
        for (int i=start; i<end-1; i++) {
            if (board.getSize()[posX][posY] != null && board.getSize()[posX + 1][posY + 1] != null && board.getSize()[posX + 2][posY + 2] != null) {
                if(board.getSize()[posX][posY].equals(board.getSize()[posX + 1][posY+1]) && board.getSize()[posX + 1][posY+1].equals(board.getSize()[posX + 2][posY+2])) {
                    return true;
                }
            }
            posX++;
            posY++;
        }
        return false;
    }

    public Boolean checkDiagonal2(Integer posX, Integer posY, Integer start, Integer end, Board board) {
        for (int i=start; i<end-1; i++) {
            if (board.getSize()[posX][posY] != null && board.getSize()[posX + 1][posY - 1] != null && board.getSize()[posX + 2][posY - 2] != null) {
                if(board.getSize()[posX][posY].equals(board.getSize()[posX + 1][posY-1]) && board.getSize()[posX + 1][posY-1].equals(board.getSize()[posX + 2][posY-2])) {
                    return true;
                }
            }
            posX++;
            posY--;
        }
        return false;
    }

    public Integer getStartPoint(Integer currentPoint) {
        if (currentPoint-2 < 0) {
            if (currentPoint-1 == 0) {
                return currentPoint-1;
            } else {
                return currentPoint;
            }
        } else {
            return currentPoint-2;
        }
    }

    public Integer getEndPoint(Integer currentPoint, Integer max) {
        if (currentPoint+2 > max) {
            if (currentPoint+1 == max) {
                return currentPoint+1;
            } else {
                return currentPoint;
            }
        } else {
            return currentPoint+2;
        }
    }
}
