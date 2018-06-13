package com.codurance.tictacto;

import java.util.Objects;

class TicTacTo {

    private static final String EMPTY = null;

    private static final String O = "O";

    private static final String X = "X";

    private static final String[] PLAYERS = {X, O};

    private int turn = 1;

    private String[][] board;

    TicTacTo(String[][] board) {
        this.board = board;
    }

    String[][] nextTurn(String player, int x, int y) {
        if (turn == 1 && player.equals(O)) {
            throw new IllegalArgumentException("X goes first!");
        }

        if (!Objects.equals(board[x][y], EMPTY)) {
            throw new IllegalArgumentException("That space is already taken!");
        }
        board[x][y] = player;
        turn++;

        return board;
    }

    String isWinner() {
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
        for (String[] aBoard : board) {
            for (int y = 0; y < board.length; y++) {
                if (!player.equals(aBoard[y])) {
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
