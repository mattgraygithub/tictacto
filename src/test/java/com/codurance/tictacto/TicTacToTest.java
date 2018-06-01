package com.codurance.tictacto;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


import org.junit.Test;

/**
 * Unit test for simple TicTacTo.
 */
public class TicTacToTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowZeroToBePlayedFirst() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("O", 0, 0);
    }

    @Test
    public void shouldAllowXToGoFirst() {
        TicTacTo tictacto = new TicTacTo();
        String[][] board = tictacto.nextTurn("X", 0, 0);
        assertThat(board[0][0], is("X"));
    }

    @Test
    public void shouldAllowZeroToGoNext() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 0, 0);
        String[][] board = tictacto.nextTurn("O", 0, 1);
        assertThat(board[0][1], is("O"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldOnlyAllowMoveIntoEmptySpace() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 0, 2);
        String[][] board = tictacto.nextTurn("O", 0, 2);
    }

    @Test
    public void xWinsHorizontalRowOne() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 0, 0);
        tictacto.nextTurn("O", 1, 0);
        tictacto.nextTurn("X", 0, 1);
        tictacto.nextTurn("O", 1, 1);
        tictacto.nextTurn("X", 0, 2);
        assertThat(tictacto.CheckForWinner(), is("X Wins!"));
    }

    @Test
    public void xWinsHorizontalRowTwo() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 1, 0);
        tictacto.nextTurn("O", 0, 0);
        tictacto.nextTurn("X", 1, 1);
        tictacto.nextTurn("O", 0, 1);
        tictacto.nextTurn("X", 1, 2);
        assertThat(tictacto.CheckForWinner(), is("X Wins!"));
    }

    @Test
    public void xWinsHorizontalRowThree() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 2, 0);
        tictacto.nextTurn("O", 0, 0);
        tictacto.nextTurn("X", 2, 1);
        tictacto.nextTurn("O", 0, 1);
        tictacto.nextTurn("X", 2, 2);
        assertThat(tictacto.CheckForWinner(), is("X Wins!"));
    }

    @Test
    public void oWinsHorizontalRowOne() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 1, 0);
        tictacto.nextTurn("O", 0, 0);
        tictacto.nextTurn("X", 1, 1);
        tictacto.nextTurn("O", 0, 1);
        tictacto.nextTurn("X", 2, 1);
        tictacto.nextTurn("O", 0, 2);
        assertThat(tictacto.CheckForWinner(), is("O Wins!"));
    }

    @Test
    public void oWinsHorizontalRowTwo() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 0, 0);
        tictacto.nextTurn("O", 1, 0);
        tictacto.nextTurn("X", 0, 1);
        tictacto.nextTurn("O", 1, 1);
        tictacto.nextTurn("X", 2, 1);
        tictacto.nextTurn("O", 1, 2);
        assertThat(tictacto.CheckForWinner(), is("O Wins!"));
    }

    @Test
    public void oWinsHorizontalRowThree() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 0, 0);
        tictacto.nextTurn("O", 2, 0);
        tictacto.nextTurn("X", 0, 1);
        tictacto.nextTurn("O", 2, 1);
        tictacto.nextTurn("X", 1, 1);
        tictacto.nextTurn("O", 2, 2);
        assertThat(tictacto.CheckForWinner(), is("O Wins!"));
    }


    @Test
    public void xWinsVerticalColumnOne() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 0, 0);
        tictacto.nextTurn("O", 0, 1);
        tictacto.nextTurn("X", 1, 0);
        tictacto.nextTurn("O", 1, 1);
        tictacto.nextTurn("X", 2, 0);
        assertThat(tictacto.CheckForWinner(), is("X Wins!"));
    }

    @Test
    public void xWinsVerticalColumnTwo() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 0, 1);
        tictacto.nextTurn("O", 0, 0);
        tictacto.nextTurn("X", 1, 1);
        tictacto.nextTurn("O", 1, 0);
        tictacto.nextTurn("X", 2, 1);
        assertThat(tictacto.CheckForWinner(), is("X Wins!"));
    }

    @Test
    public void xWinsVerticalColumnThree() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 0, 2);
        tictacto.nextTurn("O", 0, 0);
        tictacto.nextTurn("X", 1, 2);
        tictacto.nextTurn("O", 1, 0);
        tictacto.nextTurn("X", 2, 2);
        assertThat(tictacto.CheckForWinner(), is("X Wins!"));
    }

    @Test
    public void oWinsVerticalColumnOne() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 1, 1);
        tictacto.nextTurn("O", 0, 0);
        tictacto.nextTurn("X", 2, 1);
        tictacto.nextTurn("O", 1, 0);
        tictacto.nextTurn("X", 2, 2);
        tictacto.nextTurn("O", 2, 0);
        assertThat(tictacto.CheckForWinner(), is("O Wins!"));
    }

    @Test
    public void oWinsVerticalColumnTwo() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 1, 0);
        tictacto.nextTurn("O", 0, 1);
        tictacto.nextTurn("X", 2, 0);
        tictacto.nextTurn("O", 1, 1);
        tictacto.nextTurn("X", 2, 2);
        tictacto.nextTurn("O", 2, 1);
        assertThat(tictacto.CheckForWinner(), is("O Wins!"));
    }

    @Test
    public void oWinsVerticalColumnThree() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 1, 0);
        tictacto.nextTurn("O", 0, 2);
        tictacto.nextTurn("X", 2, 0);
        tictacto.nextTurn("O", 1, 2);
        tictacto.nextTurn("X", 1, 1);
        tictacto.nextTurn("O", 2, 2);
        assertThat(tictacto.CheckForWinner(), is("O Wins!"));
    }

    @Test
    public void xWinsDiagonalTopLeftToBottomRight() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 0, 0);
        tictacto.nextTurn("O", 1, 0);
        tictacto.nextTurn("X", 1, 1);
        tictacto.nextTurn("O", 0, 1);
        tictacto.nextTurn("X", 2, 2);
        assertThat(tictacto.CheckForWinner(), is("X Wins!"));
    }

    @Test
    public void oWinsDiagonalTopLeftToBottomRight() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 1, 0);
        tictacto.nextTurn("O", 0, 0);
        tictacto.nextTurn("X", 0, 1);
        tictacto.nextTurn("O", 1, 1);
        tictacto.nextTurn("X", 2, 1);
        tictacto.nextTurn("O", 2, 2);
        assertThat(tictacto.CheckForWinner(), is("O Wins!"));
    }

    @Test
    public void xWinsDiagonalBottomLeftToTopRight() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 2, 0);
        tictacto.nextTurn("O", 1, 0);
        tictacto.nextTurn("X", 1, 1);
        tictacto.nextTurn("O", 0, 1);
        tictacto.nextTurn("X", 0, 2);
        assertThat(tictacto.CheckForWinner(), is("X Wins!"));
    }

    @Test
    public void oWinsDiagonalBottomLeftToTopRight() {
        TicTacTo tictacto = new TicTacTo();
        tictacto.nextTurn("X", 1, 0);
        tictacto.nextTurn("O", 2, 0);
        tictacto.nextTurn("X", 0, 1);
        tictacto.nextTurn("O", 1, 1);
        tictacto.nextTurn("X", 2, 1);
        tictacto.nextTurn("O", 0, 2);
        assertThat(tictacto.CheckForWinner(), is("O Wins!"));
    }
}
