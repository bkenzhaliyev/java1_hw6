package hw8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private BattleMap battleMap;
    private Setting setting;

    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Крестики нолики");

        setBounds(500, 50, 500, 500);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton btnStart = new JButton("Начать игру");
        JButton btnExit = new JButton("Выйти из игры");
        panel.add(btnStart);
        panel.add(btnExit);
        add(panel, BorderLayout.SOUTH);

        battleMap = new BattleMap(this);
        add(battleMap, BorderLayout.CENTER);
        setting = new Setting(this);

        btnStart.addActionListener(e -> setting.setVisible(true));
        btnExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

   void startNewGame(int fieldSize, int winLength) {
        battleMap.startNewGame(fieldSize, winLength);
    }

}
