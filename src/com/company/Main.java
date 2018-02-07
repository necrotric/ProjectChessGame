package com.company;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame("Chess");
        window.setSize(600, 600);
        window.setVisible(true);
        window.setDefaultCloseOperation(3);

        Board.printBoard(window);
        sleep(1000);
        Board.moving(window);

    }


    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
