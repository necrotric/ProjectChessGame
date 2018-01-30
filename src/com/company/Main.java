package com.company;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame("Chess");
        window.setSize(500, 500);

        Board.printBoard(window);
        sleep(2000);
        Board.moving();
        sleep(2000);
        Board.printBoard(window);


    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
