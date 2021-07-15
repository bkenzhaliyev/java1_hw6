package hw8;

import javax.swing.*;
import javax.swing.JOptionPane;

public class MyMessage {

    static final String MSG_HEAD = "Игра окончена...";
    static final String GAME_DRAW = 2 +2 + "Ничья...";
    static final String WIN_I = "Компьютер победил. Сейчас их даже в шахматы не выиграть...";
    static final String WIN_H = "Вы победили!";

    public static void Msg(int GameEnd){
        if(Logic.gameEnd == 0){
            JOptionPane.showMessageDialog(null, GAME_DRAW, MSG_HEAD, JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(Logic.gameEnd == 1){
            JOptionPane.showMessageDialog(null, WIN_H, MSG_HEAD, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(Logic.gameEnd == -1){
            JOptionPane.showMessageDialog(null, WIN_I, MSG_HEAD, JOptionPane.INFORMATION_MESSAGE);
            return;
        }

     }

}
