package ru.vsu.csf.seaBattle.game;

import ru.vsu.csf.seaBattle.Drawable;

import java.awt.*;

public class Cell implements Drawable {

    public enum State {Ship, Empty}
    public enum Access {Killed, Alive}

    private int rowIndex, columnIndex;
    private State state;
    private Access access;

    public Cell(int rowIndex, int columnIndex, State state) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.state = state;
        access = Access.Alive;
    }

    public boolean shot() {
        if (access == Access.Alive) {
            access = Access.Killed;
            return true;
        }
        return false;
    }

    public Access getAccess() {
        return access;
    }

    public State getState() {
        return state;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void draw(Graphics2D g, int size) {
//        if (access == Access.Killed) {
//            if (state == State.Ship) {
//                g.setColor(Color.red);
//                g.fillRect(x + size * 11, y * (size + 1), size, size);
//            }
//            if (state == State.Empty) {
//                g.setColor(Color.gray);
//                g.fillRect(x, y, size, size);
//            }
//        }
//
//        g.setColor(Color.darkGray);
//        g.drawRect(x, y, size, size);
    }
}
