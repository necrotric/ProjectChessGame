package com.company;

import com.company.Pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Board {
    public static Piece[][] board =
            board = new Piece[][]{
                    new Piece[]{
                            Piece.ROOK, Piece.KNIGHT, Piece.BISHOP, Piece.QUEEN, Piece.KING,
                            Piece.BISHOP, Piece.KNIGHT, Piece.ROOK},
                    new Piece[]{
                            Piece.PAWN, Piece.PAWN, Piece.PAWN, Piece.PAWN, Piece.PAWN,
                            Piece.PAWN, Piece.PAWN, Piece.PAWN},
                    new Piece[8],
                    new Piece[8],
                    new Piece[8],
                    new Piece[8],
                    new Piece[]{
                            Piece.PAWN, Piece.PAWN, Piece.PAWN, Piece.PAWN, Piece.PAWN,
                            Piece.PAWN, Piece.PAWN, Piece.PAWN},
                    new Piece[]{
                            Piece.ROOK, Piece.KNIGHT, Piece.BISHOP, Piece.QUEEN, Piece.KING,
                            Piece.BISHOP, Piece.KNIGHT, Piece.ROOK},
            };
    static boolean start=true;

    public static void printBoard(JFrame window) {
        JPanel gui = new JPanel(new GridLayout(8, 8, 1, 1));
        JButton[][] chessBoardSquares = new JButton[8][8];

        for (int i = 0; i < chessBoardSquares.length; i++) {
            for (int j = 0; j < chessBoardSquares[i].length; j++) {
                JButton b = new JButton();
                b.setFont(new Font("Serif", Font.BOLD, 50));
                b.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[j][i] = b;

                if (board[i][j] != null) {
                    b.add(new JLabel(board[i][j].name()));
                }
                gui.add(b);
            }
            window.add(gui);
        }
        window.setVisible(true);
    }

    static void moving() {
        printBoardToTerminal();
        Move move = new Move(1, 1, 3, 1);

        if (move.isValid(board)) {
            board[move.toRank][move.toFile] = board[move.fromRank][move.fromFile];
            board[move.fromRank][move.fromFile] = null;
            System.out.println("Move is valid");
        } else

        {
            System.out.println("move is not valid");
        }
        printBoardToTerminal();
    }

    public static void printBoardToTerminal(){

        for (int i = 0; i < board.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println(i);
        }
    }
}
