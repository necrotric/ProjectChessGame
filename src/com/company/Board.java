package com.company;

import com.company.Pieces.ChessPiece;

import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.stream.StreamFilter;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import static java.awt.Color.*;

import com.company.Pieces.Color;


public class Board {
    //KANSKE SÅHÄR ISTÄLLET??? testa
    static Pieces blackPawn = new Pawn(Color.BLACK);
    static Pieces whitePawn = new Pawn(Color.WHITE);
    static Pieces whiteRook = new Rook(Color.WHITE);
    static Pieces blackRook = new Rook(Color.BLACK);
    static Pieces whiteKnight = new Knight(Color.WHITE);
    static Pieces blackKnight = new Knight(Color.BLACK);
    static Pieces whiteBishop = new Bishop(Color.WHITE);
    static Pieces blackBishop = new Bishop(Color.BLACK);
    static Pieces whiteQueen = new Queen(Color.WHITE);
    static Pieces blackQueen = new Queen(Color.BLACK);
    static Pieces whiteKing = new King(Color.WHITE);
    static Pieces blackKing = new King(Color.BLACK);
    static Pieces emptyTile = new EmptyTile();


    public static Pieces[][] board =
            new Pieces[][]{
                    new Pieces[]{
                            blackRook, blackKnight, blackBishop, blackQueen, blackKing, blackBishop, blackKnight, blackRook},
                    new Pieces[]{
                            blackPawn, blackPawn, blackPawn, blackPawn, blackPawn, blackPawn, blackPawn, blackPawn},
                    new Pieces[]{emptyTile, emptyTile, emptyTile, emptyTile, emptyTile, emptyTile, emptyTile, emptyTile},
                    new Pieces[]{emptyTile, emptyTile, emptyTile, emptyTile, emptyTile, emptyTile, emptyTile, emptyTile},
                    new Pieces[]{emptyTile, emptyTile, emptyTile, emptyTile, emptyTile, emptyTile, emptyTile, emptyTile},
                    new Pieces[]{emptyTile, emptyTile, emptyTile, emptyTile, emptyTile, emptyTile, emptyTile, emptyTile},
                    new Pieces[]{
                            whitePawn, whitePawn, whitePawn, whitePawn, whitePawn, whitePawn, whitePawn, whitePawn},
                    new Pieces[]{
                            whiteRook, whiteKnight, whiteBishop, whiteQueen, whiteKing, whiteBishop, whiteKnight, whiteRook},
            };

    static boolean start = true;

    public static void printBoard(JFrame window) {
        String COLS = "  ABCDEFGH";
        JPanel gui = new JPanel(new GridLayout(9, 9, 1, 1));
        JButton[][] chessBoardSquares = new JButton[8][8];
        Font font = new Font("Serif", Font.PLAIN, 45);

        Border border = BorderFactory.createLineBorder(BLACK, 2);

        for (int ii = 1; ii < 10; ii++) {
            gui.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                            SwingConstants.CENTER));
        }

        for (int i = 0; i < chessBoardSquares.length; i++) {
            for (int j = 0; j < chessBoardSquares[i].length; j++) {
                if (j == 0) {
                    gui.add(new JLabel("" + (i + 1),
                            SwingConstants.CENTER));
                }
                JButton b = new JButton();
                b.setFont(new Font("Serif", Font.BOLD, 50));
                b.setBorder(border);
                b.setOpaque(true);
                b.setEnabled(false);

                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    b.setBackground(WHITE);
                } else {
                    b.setBackground(RED);
                }
                chessBoardSquares[j][i] = b;
                b.add(new JLabel(board[i][j].icon)).setFont(font);
                b.setOpaque(true);
                b.setForeground(RED);
                gui.add(b);
            }
        }
        window.add(gui);

        window.revalidate();
    }


    public static void printBoardToTerminal() {
        for (int i = 0; i < board.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].print() + " ");
            }
            System.out.println(i);
        }
    }



}

