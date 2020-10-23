package ru.vsu.csf.seaBattle.game;

import ru.vsu.csf.seaBattle.Drawable;
import ru.vsu.csf.seaBattle.game.Cell;
import ru.vsu.csf.seaBattle.game.Field;

import java.awt.*;

public class Game implements Drawable {
    private Field player1;
    private Field player2;
    private static final int NUMBER_SHIPS = 10;
    private Ship[] ships = new Ship[NUMBER_SHIPS];
    private boolean movingFirst;

    public Game(boolean[][] field1, boolean[][] field2) {
        player1 = new Field(field1);
        player2 = new Field(field2);
        movingFirst = true;
    }

    public boolean shot(int rowIndex, int columnIndex) {
        if (movingFirst) {
            return shotPlayer(rowIndex, columnIndex, player2);
        }
        else {
            return shotPlayer(rowIndex, columnIndex, player1);
        }
    }

    private boolean shotPlayer(int rowIndex, int columnIndex, Field player) {
        if (player.shot(rowIndex, columnIndex)) {
            if (player.getState(rowIndex, columnIndex) == Cell.State.Ship)
                return player.checkDefeat();
            else
                movingFirst = !movingFirst;
        }
        return false;
    }

    public Cell.State[] getStates(int rowIndex, int columnIndex) {
        return new Cell.State[] {player1.getState(rowIndex, columnIndex), player2.getState(rowIndex, columnIndex)};
    }

    public Cell.Access[] getAccesses(int rowIndex, int columnIndex) {
        return new Cell.Access[] {player1.getAccess(rowIndex, columnIndex), player2.getAccess(rowIndex, columnIndex)};
    }

    public void draw(Graphics2D g, int size_cell) {
    }

    public boolean isMovingFirst() {
        return movingFirst;
    }
}
