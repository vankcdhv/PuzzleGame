/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gui.GUI;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author vank4
 */
public class Controller {

    GUI form;
    ThreadTime time;
    boolean isPlaying;
    JButton curBtn, nextBtn;
    String[][] listBtn;
    int size, stepCount;

    public Controller(GUI form) {
        this.form = form;
        isPlaying = false;
    }

    private void setCount() {
        String lb = form.getLbStepCount().getText().split(":")[0] + ": ";
        form.getLbStepCount().setText(lb + stepCount);
    }

    public void pressNewGame() {
        if (isPlaying) {
            time.pause();
            int x = (JOptionPane.showConfirmDialog(form, "Are you sure that play a new game", "Alert", JOptionPane.YES_NO_OPTION));
            if (x == JOptionPane.NO_OPTION) {
                time.timeResume();
                return;
            } else {
                time.suspend();
            }
        }

        size = form.getCbSize().getSelectedIndex() + 3;
        int sizePnGame = 50 * size + (size - 1) * 10;
        int sizeForm = sizePnGame + 200;

        listBtn = new String[size][size];
        isPlaying = true;
        stepCount = 0;

        JPanel pnGame = form.getPnPlay();
        pnGame.removeAll();
        pnGame.setLayout(new GridLayout(size, size, 10, 10));
        pnGame.setPreferredSize(new Dimension(sizePnGame, sizePnGame));
        form.setSize(new Dimension(sizePnGame, sizeForm));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                listBtn[i][j] = i * size + j + 1 + "";
            }
        }
        listBtn[size - 1][size - 1] = "";
        listBtn = suffel(size * size * size, listBtn);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton btn = new JButton();
                btn.setText(listBtn[i][j]);
                btn.setName("btn" + (i * size + j + 1));
                addButtonListener(btn);
                pnGame.add(btn);
                if (listBtn[i][j].equals("")) {
                    curBtn = btn;
                }
            }
        }
        time = new ThreadTime(form);
        time.start();
        setCount();
    }

    private boolean checkMove(int x, int y) {
        if (x < 0 || x == size) {
            return false;
        }
        if (y < 0 || y == size) {
            return false;
        }
        return true;
    }

    private String[][] suffel(int n, String[][] list) {
        Random rd = new Random();
        int x = size - 1;
        int y = size - 1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 1; i <= n; i++) {
            int u = rd.nextInt(4);
            while (!checkMove(x + dx[u], y + dy[u])) {
                u = rd.nextInt(4);
            }
            String tmp = list[x][y];
            list[x][y] = list[x + dx[u]][y + dy[u]];
            list[x + dx[u]][y + dy[u]] = tmp;
            x = x + dx[u];
            y = y + dy[u];
        }
        return list;
    }

    private int getPosX(int n) {
        int x = n / size;
        if (n % size != 0) {
            x++;
        }
        return x;
    }

    private int getPosY(int n) {
        int x = n % size;
        if (n % size == 0) {
            x = size;
        }
        return x;
    }

    private boolean checkNext(int n1, int n2) {
        int x1 = getPosX(n1);
        int y1 = getPosY(n1);
        int x2 = getPosX(n2);
        int y2 = getPosY(n2);
        //System.out.println(n1 + " - " + x1 + " - " + y1 + " - " + " --> " + n2 + " - " + x2 + " - " + y2);
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            //System.out.println("-- " + dx[i] + " - " + dy[i]);
            if ((x2 == (x1 + dx[i])) && (y2 == (y1 + dy[i]))) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWin() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int pos = i * size + j;
                JButton btn = (JButton) form.getPnPlay().getComponent(pos);
                if (btn.getText().equals("")) {
                    if (!btn.getName().equals("btn" + size * size)) {
                        return false;
                    }
                } else {
                    if (!btn.getName().split("n")[1].equals(btn.getText())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean swapButton(String btn1, String btn2) {
        int n1, n2;
        n1 = Integer.parseInt(btn1.split("n")[1]);
        n2 = Integer.parseInt(btn2.split("n")[1]);
        if (!checkNext(n1, n2)) {
            return false;
        }
        JButton b1 = (JButton) form.getPnPlay().getComponent(n1 - 1);
        JButton b2 = (JButton) form.getPnPlay().getComponent(n2 - 1);
        //System.out.println(b1.getText() + " --> " + b2.getText());
        String tmp = b1.getText();
        b1.setText(b2.getText());
        b2.setText(tmp);
        return true;
    }

    private void gameWin() {
        time.stop();
        JOptionPane.showMessageDialog(form, "You win");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int pos = i * size + j;
                JButton btn = (JButton) form.getPnPlay().getComponent(pos);
                btn.setEnabled(false);
            }
        }
    }

    private void addButtonListener(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextBtn = btn;
                //System.out.println(curBtn.getName() + " = " + curBtn.getText() + " --> " + nextBtn.getName() + " = " + nextBtn.getText());
                if (swapButton(curBtn.getName(), nextBtn.getName())) {
                    curBtn = nextBtn;
                    stepCount++;
                    setCount();
                    if (checkWin()) {
                        gameWin();
                    }
                }
            }
        }
        );
    }
}
