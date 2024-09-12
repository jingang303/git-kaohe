package com.kaohe.demo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class App extends JFrame implements KeyListener {
    //得分
    private int score = 0;

    //记录界面的数组
    private int[][] map = new int[4][4];




    @Override
    public void keyTyped(KeyEvent e) {

    }

    //键盘按下监听
    @Override
    public void keyPressed(KeyEvent e) {
        //获取按下键的KeyCode值
        int keyCode = e.getKeyCode();

        //对所按的键进行判断
        //左,上，右，下
        if (keyCode == 37) {
            System.out.println("左");
            leftMove();
        } else if (keyCode == 38) {
            System.out.println("上");
            upMove();
        } else if (keyCode == 39) {
            System.out.println("右");
            rightMove();
        } else if (keyCode == 40) {
            System.out.println("下");
            downMove();
        }
    }

    //左移
    private void leftMove() {
        for (int row = 0; row < map.length; row++) {
            for (int col = map[row].length - 1; col > 0; col--) {
                if (map[row][col] == map[row][col - 1]) {
                    map[row][col] = 0;
                    map[row][col - 1] *=2;
                    score += map[row][col - 1];
                }
            }
        }
    }

    //上移
    private void upMove() {
        int colLength= map[0].length;
        for (int col = 0; col < colLength; col++) {
            for (int row = map.length-1; row > 0; row--) {
                if(map[row][col] == map[row - 1][col]) {
                    map[row][col] = 0;
                    map[row - 1][col] *=2;
                    score += map[row - 1][col];
                }
            }
        }
    }

    //右移
    private void rightMove() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col <map[row].length-1; col++) {
                if (map[row][col] == map[row][col + 1]) {
                    map[row][col] = 0;
                    map[row][col + 1] *=2;
                    score += map[row][col + 1];
                }
            }
        }
    }

    //下移
    private void downMove() {
        int colLength= map[0].length;
        for (int col = map[0].length-1; col > 0; col--) {
            for (int row = 0; row < map.length-1; row++) {
                if(map[row][col] == map[row + 1][col]) {
                    map[row][col] = 0;
                    map[row + 1][col] *=2;
                    score += map[row + 1][col];
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
