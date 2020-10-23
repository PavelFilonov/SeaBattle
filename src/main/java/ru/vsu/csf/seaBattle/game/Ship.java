package ru.vsu.csf.seaBattle.game;

public class Ship {

    private Cell[] ship;

    public Ship(Cell[] ship) {
        this.ship = ship;
    }

    public boolean containsCell(int rowIndexCell, int columnIndexCell){
        for (Cell cell : ship) {
            if (cell.getRowIndex() == rowIndexCell && cell.getColumnIndex() == columnIndexCell)
                return true;
        }
        return false;
    }
}
