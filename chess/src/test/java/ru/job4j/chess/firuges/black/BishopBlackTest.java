package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack bishop = new BishopBlack(Cell.B2);
        assertThat(bishop.position().getX(), is(1));
        assertThat(bishop.position().getY(), is(6));
    }

    @Test
    public void testCopy() {
        BishopBlack bishop = new BishopBlack(Cell.C2);
        assertThat(bishop.copy(Cell.C2).position().getX(), is(2));
        assertThat(bishop.copy(Cell.C2).position().getY(), is(6));
    }

    @Test
    public void testWay() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        String[] expected = {"D2", "E3", "F4", "G5"};
        assertThat(bishop.way(Cell.G5), is(expected));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenNotIsDiagonal() {
        BishopBlack position = new BishopBlack(Cell.C8);
        position.way(Cell.C7);
    }
}