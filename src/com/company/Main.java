package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {


        JFrame window = new JFrame("Chess");
        JPanel gui = new JPanel(new GridLayout(8, 8, 1, 1));
        window.setSize(500, 500);

        JButton[][] chessBoardSquares = new JButton[8][8];

        ChessMusings.Piece[][] board =
                board = new ChessMusings.Piece[][]{
                        new ChessMusings.Piece[]{
                                ChessMusings.Piece.ROOK, ChessMusings.Piece.KNIGHT, ChessMusings.Piece.BISHOP, ChessMusings.Piece.QUEEN, ChessMusings.Piece.KING,
                                ChessMusings.Piece.BISHOP, ChessMusings.Piece.KNIGHT, ChessMusings.Piece.ROOK},
                        new ChessMusings.Piece[]{
                                ChessMusings.Piece.PAWN, ChessMusings.Piece.PAWN, ChessMusings.Piece.PAWN, ChessMusings.Piece.PAWN, ChessMusings.Piece.PAWN,
                                ChessMusings.Piece.PAWN, ChessMusings.Piece.PAWN, ChessMusings.Piece.PAWN},
                        new ChessMusings.Piece[8],
                        new ChessMusings.Piece[8],
                        new ChessMusings.Piece[8],
                        new ChessMusings.Piece[8],
                        new ChessMusings.Piece[]{
                                ChessMusings.Piece.PAWN, ChessMusings.Piece.PAWN, ChessMusings.Piece.PAWN, ChessMusings.Piece.PAWN, ChessMusings.Piece.PAWN,
                                ChessMusings.Piece.PAWN, ChessMusings.Piece.PAWN, ChessMusings.Piece.PAWN},
                        new ChessMusings.Piece[]{
                                ChessMusings.Piece.ROOK, ChessMusings.Piece.KNIGHT, ChessMusings.Piece.BISHOP, ChessMusings.Piece.QUEEN, ChessMusings.Piece.KING,
                                ChessMusings.Piece.BISHOP, ChessMusings.Piece.KNIGHT, ChessMusings.Piece.ROOK},
                };


        for (int i = 0; i < chessBoardSquares.length; i++) {
            for (int j = 0; j <chessBoardSquares[i].length; j++) {
                JButton b = new JButton();
                b.setFont(new Font("Serif", Font.BOLD, 50));
                b.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                if ((i % 2 == 1 && j % 2 == 1)|| (i % 2 == 0 && j % 2 == 0)) {
                    System.out.println("BLACK");
                    b.setBackground(Color.WHITE);
                } else {
                    System.out.println("WHITE");
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[j][i]=b;

                if(board[i][j]!=null){
                    b.add(new JLabel(board[i][j].name()));
                }
                gui.add(b);
            }
            window.add(gui);
            System.out.println();

        }
        window.show();


//        for (int i =0; i<(8*8); i++){
//            final JLabel label = new JLabel("\u265D");
//            for (int j = 0; j <8*8 ; j++) {
//
//
//
//                if (i%2==0){
//                    label.setOpaque(true);
//                    label.setBackground(Color.BLACK);
//                }
//                label.setFont(new Font("Serif", Font.PLAIN, 50));
//                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//
//
//
//
//            }
//            gui.add(label);
//        }


        // Loop through all rows


        for (
                int i = 0;
                i < board.length; i++)

        {

            // Loop through all elements of current row
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(i);
        }

        Move move = new Move(7, 0, 4, 1);
        if (move.isValid(board))

        {
            board[move.toRank][move.toFile] = board[move.fromRank][move.fromFile];
            board[move.fromRank][move.fromFile] = null;
            System.out.println("Move is valid");
        } else

        {
            System.out.println("move is not valid");
        }

        for (
                int i = 0;
                i < board.length; i++)

        {

            // Loop through all elements of current row
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(i);
        }

    }
}
