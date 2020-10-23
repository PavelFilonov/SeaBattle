package ru.vsu.csf.seaBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainJFrame extends JFrame {

    private int fieldSize;
    private int widthField;
    private int heightField;
    private int sizeFieldsPlayers;
    private int cellSize;
    private Field fieldFirstPlayer;
    private Field fieldSecondPlayer;
    private static final int LEFT_BUTTON_MOUSE = 1;
    private static final int RIGHT_BUTTON_MOUSE = 3;

    public MainJFrame() {
        super("Морской бой");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        widthField = this.getWidth();
        heightField = this.getHeight();
        fieldSize = widthField * heightField;
//        fieldFirstPlayer = new Field();
//        fieldFirstPlayer.setPreferredSize(new Dimension());
//        fieldSecondPlayer = new Field();
//        fieldSecondPlayer.setPreferredSize(new Dimension());

        fieldFirstPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }
        });

        fieldSecondPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }
        });
    }

    class Field extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
        }
    }

}