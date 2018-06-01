package com.codurance.tictacto;

/**
 * Tic Tac To!
 */

public class TicTacTo {
    int turn = 1;
    String[][] board = new String[3][3];

    public String[][] nextTurn(String player, int x, int y) {

        if (turn == 1 && player == "O") {
            throw new IllegalArgumentException();
        }

        if (board[x][y] != null) {
            throw new IllegalArgumentException();
        }
        board[x][y] = player;
        turn++;

        return board;
    }

    public String CheckForWinner() {
        String winner = "";
        for (int x = 0; x < 3; x++) {
            if (board[x][0]=="X" && board[x][1]=="X" && board[x][2]=="X"){
                winner = "X Wins!";
                break;
            } else if (board[x][0]=="O" && board[x][1]=="O" && board[x][2]=="O"){
                winner = "O Wins!";
                break;
            } else {
                for (int y = 0; y < 3; y++) {
                    if (board[0][y]=="X" && board[1][y]=="X" && board[2][y]=="X"){
                        winner = "X Wins!";
                        break;
                    } else if (board[0][y] == "O" && board[1][y] == "O" && board[2][y] == "O") {
                        winner = "O Wins!";
                        break;
                    } else {
                        winner = null;
                    }
                }
            }
        }
        if (board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") {
            winner = "X Wins!";
        } else if (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O") {
            winner = "O Wins!";
        } else if (board[2][0] == "X" && board[1][1] == "X" && board[0][2] == "X") {
            winner = "X Wins!";
        }else if (board[2][0] == "O" && board[1][1] == "O" && board[0][2] == "O") {
            winner = "O Wins!";
        }
        return winner;
    }
}




