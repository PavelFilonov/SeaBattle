package ru.vsu.csf.seaBattle.model;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.csf.seaBattle.game.Cell;
import ru.vsu.csf.seaBattle.game.Field;
import ru.vsu.csf.seaBattle.game.Game;

public class SeaBattleTest {

    @Test
    public void testCellConstructor() {
        Cell cell = new Cell(2, 3, Cell.State.Empty);

        Assert.assertEquals(cell.getState(), Cell.State.Empty);
        Assert.assertEquals(cell.getAccess(), Cell.Access.Alive);

        Assert.assertEquals(cell.getRowIndex(), 2);
        Assert.assertEquals(cell.getColumnIndex(), 3);
    }

    @Test
    public void testCellShot() {
        Cell cell = new Cell(20, 15, Cell.State.Ship);

        Assert.assertEquals(cell.getAccess(), Cell.Access.Alive);

        cell.shot();
        Assert.assertEquals(cell.getAccess(), Cell.Access.Killed);
    }

    @Test
    public void testFieldConstructor() {
        boolean[][] boolField = new boolean[][] {{true, false, false}, {false, false, false}, {false, true, true}};
        Field field = new Field(boolField);

        Assert.assertEquals(field.getState(0, 0), Cell.State.Ship);
        Assert.assertEquals(field.getState(0, 1), Cell.State.Empty);
        Assert.assertEquals(field.getState(0, 2), Cell.State.Empty);
        Assert.assertEquals(field.getState(1, 0), Cell.State.Empty);
        Assert.assertEquals(field.getState(1, 1), Cell.State.Empty);
        Assert.assertEquals(field.getState(1, 2), Cell.State.Empty);
        Assert.assertEquals(field.getState(2, 0), Cell.State.Empty);
        Assert.assertEquals(field.getState(2, 1), Cell.State.Ship);
        Assert.assertEquals(field.getState(2, 2), Cell.State.Ship);
    }

    @Test
    public void testFieldShot() {
        boolean[][] boolField = new boolean[][] {{true, false, false}, {false, false, false}, {false, true, true}};
        Field field = new Field(boolField);

        Assert.assertEquals(field.getAccess(0, 0), Cell.Access.Alive);
        field.shot(0, 0);
        Assert.assertEquals(field.getAccess(0, 0), Cell.Access.Killed);

        Assert.assertEquals(field.getAccess(1, 0), Cell.Access.Alive);
        field.shot(1, 0);
        Assert.assertEquals(field.getAccess(1, 0), Cell.Access.Killed);

        field.shot(1, 0);
        Assert.assertEquals(field.getAccess(1, 0), Cell.Access.Killed);
    }

    @Test
    public void testFieldCheckDefeat() {
        boolean[][] boolField = new boolean[][] {{true, false, false}, {false, false, false}, {false, false, false}};
        Field field = new Field(boolField);

        Assert.assertFalse(field.checkDefeat());

        field.shot(0, 0);
        Assert.assertTrue(field.checkDefeat());
    }

    @Test
    public void testGameShot() {
        boolean[][] boolField1 = new boolean[][] {{true, false, false}, {false, false, false}, {false, false, true}};
        boolean[][] boolField2 = new boolean[][] {{false, true, false}, {false, true, false}, {false, true, false}};
        Game game = new Game(boolField1, boolField2);

        // 1-ый выстрел
        Assert.assertTrue(game.isMovingFirst());
        game.shot(0, 1);
        Cell.Access[] accesses = game.getAccesses(0, 1);
        Assert.assertEquals(accesses[0], Cell.Access.Alive);
        Assert.assertEquals(accesses[1], Cell.Access.Killed);

        // 2-ой выстрел 1-го игрока (т.к. 1-ый выстрел попал)
        Assert.assertTrue(game.isMovingFirst());
        game.shot(1,  2);
        accesses = game.getAccesses(1, 2);
        Assert.assertEquals(accesses[0], Cell.Access.Alive);
        Assert.assertEquals(accesses[1], Cell.Access.Killed);

        // 3-ий выстрел
        Assert.assertFalse(game.isMovingFirst());
        game.shot(2, 0);
        accesses = game.getAccesses(2, 0);
        Assert.assertEquals(accesses[0], Cell.Access.Killed);
        Assert.assertEquals(accesses[1], Cell.Access.Alive);

        // 4-ый выстрел
        Assert.assertTrue(game.isMovingFirst());
        Assert.assertFalse(game.shot(0, 1));
    }

    @Test
    public void testShipConstructor() {
    }

    @Test
    public void testShipContainsCell() {
    }
}
