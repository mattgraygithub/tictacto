package com.codurance.tictacto;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class TicTacToTest {

    private static final String EMPTY = null;

    private static final String O = "O";

    private static final String X = "X";

    private String[][] emptyBoard = new String[][]{
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY}
    };

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowZeroToBePlayedFirst() {
        TicTacTo tictacto = new TicTacTo(emptyBoard);
        tictacto.nextTurn(O, 0, 0);
    }

    @Test
    public void shouldAllowXToGoFirst() {
        TicTacTo tictacto = new TicTacTo(emptyBoard);
        String[][] board = tictacto.nextTurn(X, 0, 0);
        assertThat(board[0][0], is(X));
    }

    @Test
    public void shouldAllowZeroToGoNext() {
        TicTacTo tictacto = new TicTacTo(emptyBoard);
        tictacto.nextTurn(X, 0, 0);
        String[][] board = tictacto.nextTurn(O, 0, 1);
        assertThat(board[0][1], is(O));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldOnlyAllowMoveIntoEmptySpace() {
        TicTacTo tictacto = new TicTacTo(emptyBoard);
        tictacto.nextTurn(X, 0, 2);
        String[][] board = tictacto.nextTurn(O, 0, 2);
    }

    @Test
    public void xWinsHorizontalRowOne() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {X, X, X},
                {EMPTY, O, O,},
                {EMPTY, EMPTY, EMPTY}
        });
        assertThat(tictacto.checkForWinner(), is(X));
    }

    @Test
    public void xWinsHorizontalRowTwo() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {O, O, EMPTY},
                {X, X, X},
                {EMPTY, EMPTY, EMPTY}
        });
        assertThat(tictacto.checkForWinner(), is(X));
    }

    @Test
    public void xWinsHorizontalRowThree() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {EMPTY, EMPTY, EMPTY},
                {O, O, EMPTY},
                {X, X, X}
        });
        assertThat(tictacto.checkForWinner(), is(X));
    }

    @Test
    public void oWinsHorizontalRowOne() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {O, O, O},
                {X, X, EMPTY},
                {X, X, EMPTY}
        });
        assertThat(tictacto.checkForWinner(), is(O));
    }

    @Test
    public void oWinsHorizontalRowTwo() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {X, X, EMPTY},
                {O, O, O},
                {X, X, EMPTY}
        });
        assertThat(tictacto.checkForWinner(), is(O));
    }

    @Test
    public void oWinsHorizontalRowThree() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {X, X, EMPTY},
                {X, X, EMPTY},
                {O, O, O}
        });
        assertThat(tictacto.checkForWinner(), is(O));
    }


    @Test
    public void xWinsVerticalColumnOne() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {X, EMPTY, EMPTY},
                {X, EMPTY, EMPTY},
                {X, O, O}
        });
        assertThat(tictacto.checkForWinner(), is(X));
    }

    @Test
    public void xWinsVerticalColumnTwo() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {EMPTY, X, EMPTY},
                {O, X, EMPTY},
                {O, X, EMPTY}
        });
        assertThat(tictacto.checkForWinner(), is(X));
    }

    @Test
    public void xWinsVerticalColumnThree() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {EMPTY, EMPTY, X},
                {O, EMPTY, X},
                {O, EMPTY, X}
        });
        assertThat(tictacto.checkForWinner(), is(X));
    }

    @Test
    public void oWinsVerticalColumnOne() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {O, X, EMPTY},
                {O, X, X},
                {O, EMPTY, X}
        });
        assertThat(tictacto.checkForWinner(), is(O));
    }

    @Test
    public void oWinsVerticalColumnTwo() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {EMPTY, O, EMPTY},
                {X, O, X},
                {X, O, X}
        });
        assertThat(tictacto.checkForWinner(), is(O));
    }

    @Test
    public void oWinsVerticalColumnThree() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {X, X, O},
                {EMPTY, X, O},
                {X, EMPTY, O}
        });
        assertThat(tictacto.checkForWinner(), is(O));
    }

    @Test
    public void xWinsDiagonalTopLeftToBottomRight() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {X, EMPTY, O},
                {EMPTY, X, O},
                {EMPTY, EMPTY, X}
        });
        assertThat(tictacto.checkForWinner(), is(X));
    }


    @Test
    public void xWinsDiagonalBottomLeftToTopRight() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {O, O, X},
                {EMPTY, X, EMPTY},
                {X, EMPTY, EMPTY}
        });
        assertThat(tictacto.checkForWinner(), is(X));
    }

    @Test
    public void oWinsDiagonalTopLeftToBottomRight() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {O, X, X},
                {X, O, X},
                {EMPTY, EMPTY, O}
        });
        assertThat(tictacto.checkForWinner(), is(O));
    }

    @Test
    public void oWinsDiagonalBottomLeftToTopRight() {
        TicTacTo tictacto = new TicTacTo(new String[][]{
                {X, X, O},
                {EMPTY, O, X},
                {O, EMPTY, X}
        });
        assertThat(tictacto.checkForWinner(), is(O));
    }
}
