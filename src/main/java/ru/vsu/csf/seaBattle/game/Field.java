package ru.vsu.csf.seaBattle.game;

import ru.vsu.csf.seaBattle.Drawable;

import java.awt.*;

public class Field implements Drawable {

    private Cell[][] field;

    public Field(boolean[][] boolField) {
        createField(boolField);
    }

    private void createField(boolean[][] boolField) {
        field = new Cell[boolField.length][boolField[0].length];
        for (int rowIndex = 0; rowIndex < boolField.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < boolField[0].length; columnIndex++) {
                if (boolField[rowIndex][columnIndex])
                    field[rowIndex][columnIndex] = new Cell(rowIndex, columnIndex, Cell.State.Ship);
                else
                    field[rowIndex][columnIndex] = new Cell(rowIndex, columnIndex, Cell.State.Empty);
            }
        }
    }

    public boolean shot(int rowIndex, int columnIndex) {
        return field[rowIndex][columnIndex].shot();
    }

    public Cell.State getState(int rowIndex, int columnIndex) {
        return field[rowIndex][columnIndex].getState();
    }

    public Cell.Access getAccess(int rowIndex, int columnIndex) {
        return field[rowIndex][columnIndex].getAccess();
    }

    public boolean checkDefeat() {
        for (Cell[] cells : field) {
            for (int columnIndex = 0; columnIndex < field[0].length; columnIndex++) {
                if (cells[columnIndex].getAccess() == Cell.Access.Alive && cells[columnIndex].getState() == Cell.State.Ship)
                    return false;
            }
        }
        return true;
    }

    public void draw(Graphics2D g, int size_cell) {
        for (Cell[] cells : field) {
            for (int columnIndex = 0; columnIndex < field[0].length; columnIndex++) {
                cells[columnIndex].draw(g, size_cell);
            }
        }
    }
}
