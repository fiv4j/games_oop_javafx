package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void whenPositionIsG3() {
        Figure testBishop = new BishopBlack(Cell.G3);
        Cell out = testBishop.position();
        Cell expected = Cell.G3;
        assertThat(out, is(expected));
    }

    @Test
    public void whenCopyToA1() {
        Figure bishopBefore = new BishopBlack(Cell.G3);
        Figure bishopAfter = bishopBefore.copy(Cell.A1);
        Cell out = bishopAfter.position();
        Cell expected = Cell.A1;
        assertThat(out, is(expected));
    }

    @Test
    public void whenWayFromC1ToG5() {
        Cell source = Cell.C1;
        Cell dest = Cell.G5;
        Figure bishopTest = new BishopBlack(source);
        Cell[] out = bishopTest.way(source, dest);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(out, is(expected));
    }

    @Test
    public void whenWayFromG8ToB3() {
        Cell source = Cell.G8;
        Cell dest = Cell.B3;
        Figure bishopTest = new BishopBlack(source);
        Cell[] out = bishopTest.way(source, dest);
        Cell[] expected = {Cell.F7, Cell.E6, Cell.D5, Cell.C4, Cell.B3};
        assertThat(out, is(expected));
    }

    @Test(expected = IllegalStateException.class)
    public void whenWayFromB2ToD5ThrowException() {
        Cell source = Cell.B2;
        Cell dest = Cell.D5;
        Figure bishopTest = new BishopBlack(source);
        bishopTest.way(source, dest);
    }

    @Test
    public void checkDiagonalFromC1ToG5True() {
        BishopBlack bishopTest = new BishopBlack(Cell.A1);
        boolean out = bishopTest.isDiagonal(Cell.C1, Cell.G5);
        assertThat(out, is(true));

    }

    @Test
    public void checkDiagonalFromB2ToD5False() {
        BishopBlack bishopTest = new BishopBlack(Cell.A1);
        boolean out = bishopTest.isDiagonal(Cell.B2, Cell.D5);
        assertThat(out, is(false));

    }
}
