package com.company;

import javax.swing.*;

import java.awt.*;
import java.util.Arrays;

import static com.company.Board.*;

public class GenerateMoves {
    public static int turncounter = 0;
    static Pieces.Color pieceColor = Pieces.Color.WHITE;


    public static void moving(JFrame window) {


        Move move = new Move(0, 0, 4, 0);
        if (move.isValid(board)) {
            board[move.toRank][move.toFile] = board[move.fromRank][move.fromFile];
            board[move.fromRank][move.fromFile] = emptyTile;
            System.out.println("Moving");
            printBoard(window);
            printBoardToTerminal();
        } else {
            System.out.println("Not moving");

        }


        for (int i = 0; i<2;i++){
            if (turncounter % 2 == 0) {
                pieceColor=Pieces.Color.BLACK;
            }else{
                pieceColor=Pieces.Color.WHITE;
            }
        Arrays.stream(board).forEach(p -> {
            Arrays.stream(p).filter(wp -> {
                if (wp.color == pieceColor) {

                    return true;
                } else {
                    return false;
                }
            }).forEach(wp -> {
                System.out.println(wp.print());
            });
        });
            turncounter++;

        }
    }


}
