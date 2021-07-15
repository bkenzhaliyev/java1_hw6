package hw8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//import java.awt.event.MouseListener;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;
    private int fieldSize;
    private int winLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (isInit && !Logic.isGameFinished) {
                    Logic.humanTurn(cellY, cellX);
                }
                repaint();

                // прорисовка объектов
                if (Logic.isGameFinished) {
//                    WinLine();
                    MyMessage.Msg(Logic.gameEnd);
                    return;
                }

            }
        });
    }

    void startNewGame(int fieldSize, int winLength) {
        this.fieldSize = fieldSize;
        this.winLength = winLength;

        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        g.setColor(Color.BLACK);
        ((Graphics2D) g).setStroke(new BasicStroke(2f));

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, i, j);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, i, j);
                }
            }
        }

        if (Logic.isGameFinished) {
            drawWinLine(g, 0, 0);
        }


    }

    private void drawX(Graphics g, int y, int x) {
        g.setColor(Color.BLUE);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));

        g.drawLine(x * cellWidth, y * cellHeight,
                (x + 1) * cellWidth, (y + 1) * cellHeight);

        g.drawLine((x + 1) * (cellWidth), y * cellHeight,
                x * cellWidth, (y + 1) * cellHeight);

    }

    private void drawO(Graphics g, int y, int x) {
        g.setColor(Color.BLACK);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));

        g.drawOval(x * cellWidth, y * cellHeight,
                cellWidth, cellHeight);
    }

    private void drawWinLine(Graphics g, int y, int x) {
        g.setColor(Color.RED);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.checkLine(i, j, 0, 1, Logic.DOT_O, Logic.DOTS_TO_WIN)) {
                    g.drawLine(0, cellWidth * (i + 1) - cellWidth / 2, panelWidth, cellWidth * (i + 1) - cellWidth / 2);
                }

                if (Logic.checkLine(i, j, 0, 1, Logic.DOT_X, Logic.DOTS_TO_WIN)) {
                    g.drawLine(0, cellWidth * (i + 1) - cellWidth / 2, panelWidth, cellWidth * (i + 1) - cellWidth / 2);
                }


                if (Logic.checkLine(i, j, 1, 0, Logic.DOT_O, Logic.DOTS_TO_WIN)) {
                    g.drawLine(cellHeight  * (j + 1) - cellHeight  / 2, 0, cellHeight  * (j + 1) - cellHeight  / 2, panelHeight);
//                    g.drawLine(0, cellHeight  * (i + 1) - cellHeight  / 2, panelWidth, cellHeight  * (i + 1) - cellHeight  / 2);
                }

                if (Logic.checkLine(i, j, 1, 0, Logic.DOT_X, Logic.DOTS_TO_WIN)) {
                    g.drawLine(cellHeight  * (j + 1) - cellHeight  / 2, 0, cellHeight  * (j + 1) - cellHeight  / 2, panelHeight);
                }

                if (Logic.checkLine(i, j, 1, 1, Logic.DOT_O, Logic.DOTS_TO_WIN)) {
                    g.drawLine(0, 0, panelWidth, panelWidth);
                }

                if (Logic.checkLine(i, j, 1, 1, Logic.DOT_X, Logic.DOTS_TO_WIN)) {
                    g.drawLine(0, 0, panelWidth, panelWidth);
                }

                if (Logic.checkLine(i, j, -1, 1, Logic.DOT_O, Logic.DOTS_TO_WIN)) {
                    g.drawLine(panelWidth, 0, 0, panelWidth);
                }

                if (Logic.checkLine(i, j, -1, 1, Logic.DOT_X, Logic.DOTS_TO_WIN)) {
                    g.drawLine(panelWidth, 0, 0, panelWidth);
                }

            }
        }
//        g.drawLine(cellWidth / 2, 0, cellWidth / 2, panelHeight);
//        g.drawLine(0, cellHeight / 2, panelWidth, cellHeight / 2);
//        g.drawLine(0, 0, panelWidth, panelHeight );
//        g.drawLine(panelWidth, 0, 0, panelHeight);
    }
}