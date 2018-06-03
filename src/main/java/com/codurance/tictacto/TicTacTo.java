package com.codurance.tictacto;

public class TicTacTo {
    private int turn = 1;
    private String[][] board;
    private static final String X = "X";
    private static final String O = "O";

    public TicTacTo(String[][] board) {
        this.board = board;
    }

    public String[][] nextTurn(String player, int x, int y) {

        if (turn == 1 && player == "O") {
            throw new IllegalArgumentException("X goes first!");
        }

        if (board[x][y] != null) {
            throw new IllegalArgumentException("That space is already taken!");
        }
        board[x][y] = player;
        turn++;

        return board;
    }

    public String checkForWinner() {
        String winner = "";
        //Check Horizontal
        for (int x = 0; x < 3; x++) {
            if (board[x][0] == "X" && board[x][1] == "X" && board[x][2] == "X") {
                winner = X;
                break;
            } else if (board[x][0] == "O" && board[x][1] == "O" && board[x][2] == "O") {
                winner = O;
                break;
            } else {
                //Check Vertical
                for (int y = 0; y < 3; y++) {
                    if (board[0][y] == "X" && board[1][y] == "X" && board[2][y] == "X") {
                        winner = X;
                        break;
                    } else if (board[0][y] == "O" && board[1][y] == "O" && board[2][y] == "O") {
                        winner = O;
                        break;
                    } else {
                        winner = null;
                    }
                }
            }
        }
        //Check Diagonal
        if (board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") {
            winner = X;
        } else if (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O") {
            winner = O;
        } else if (board[2][0] == "X" && board[1][1] == "X" && board[0][2] == "X") {
            winner = X;
        } else if (board[2][0] == "O" && board[1][1] == "O" && board[0][2] == "O") {
            winner = O;
        }
        return winner;
    }
}




