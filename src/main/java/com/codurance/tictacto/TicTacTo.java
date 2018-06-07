package com.codurance.tictacto;

public class TicTacTo {

    private static final String EMPTY = null;

    private int turn = 1;

    private String[][] board;

    public TicTacTo(String[][] board) {
        this.board = board;
    }

    public String[][] nextTurn(String player, int x, int y) {

        if (turn == 1 && player == "O") {
            throw new IllegalArgumentException("X goes first!");
        }

        if (board[x][y] != EMPTY) {
            throw new IllegalArgumentException("That space is already taken!");
        }
        board[x][y] = player;
        turn++;

        return board;
    }

    public String checkForWinner() {
        String[] PLAYERS = {"X", "O"};
        for (String player : PLAYERS) {
            if (isHorizontalWinner(player)
                    || isVerticalWinner(player)
                    || isDiagonalTopLeftToBottomRightWinner(player)
                    || isDiagonalBottomLeftToTopRightWinner(player)) {
                return player;
            }
        }
        return "";
    }

    private boolean isHorizontalWinner(String player) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (!player.equals(board[x][y])) {
                    break;
                } else if (x == board.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isVerticalWinner(String player) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                if (!player.equals(board[x][y])) {
                    break;
                } else if (y == board.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isDiagonalTopLeftToBottomRightWinner(String player) {
        int x = 0;
        int y = 0;
        outer:
        while (x < board.length) {
            while (y < board.length) {
                if (!player.equals(board[x][y])) {
                    break outer;
                } else if (y == board.length - 1) {
                    return true;
                } else {
                    x += 1;
                    y += 1;
                }
            }
        }
        return false;
    }

    private boolean isDiagonalBottomLeftToTopRightWinner(String player) {
        int x = 0;
        int y = board.length - 1;
        outer:
        while (x < board.length) {
            while (y >= 0) {
                if (!player.equals(board[x][y])) {
                    break outer;
                } else if (y == 0) {
                    return true;
                } else {
                    x += 1;
                    y -= 1;
                }
            }
        }
        return false;
    }
}
