package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Test
    public void whenWayIsFree() {
        Logic test = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.G3);
        test.add(bishop);
        boolean out = test.move(Cell.G3, Cell.C7);
        assertThat(out, is(true));

    }

    @Test
    public void whenWayIsNotFree() {
        Logic test = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.G3);
        BishopBlack obstacle = new BishopBlack(Cell.C7);
        test.add(bishop);
        test.add(obstacle);
        boolean out = test.move(Cell.G3, Cell.C7);
        assertThat(out, is(false));

    }

    @Test
    public void whenWayIsNotLegal() {
        Logic test = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.G3);
        test.add(bishop);
        boolean out = test.move(Cell.G3, Cell.G2);
        assertThat(out, is(false));

    }
}
