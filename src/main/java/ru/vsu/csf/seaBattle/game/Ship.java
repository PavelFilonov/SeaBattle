package ru.vsu.csf.seaBattle.game;

import java.util.List;

public class Ship {

    private List<Cell> ship;

    public Ship(List<Cell> ship) {
        this.ship = ship;
    }

    public boolean containsCell(int rowIndexCell, int columnIndexCell) {
        for (Cell cell : ship) {
            if (cell.getRowIndex() == rowIndexCell && cell.getColumnIndex() == columnIndexCell)
                return true;
        }
        return false;
    }
}
