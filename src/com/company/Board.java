package com.company;

import com.company.Pieces.Piece;

import javax.swing.*;
import java.awt.*;

import static com.company.Pieces.*;
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

    public static Pieces[][] board =
            board = new Pieces[][]{
                    new Pieces[]{
                            blackRook, blackKnight, blackBishop, blackKing, blackQueen,
                            blackBishop, blackKnight, blackRook},
                    new Pieces[]{
                            blackPawn, blackPawn, blackPawn, blackPawn, blackPawn,
                            blackPawn, blackPawn, blackPawn},
                    new Pieces[8],
                    new Pieces[8],
                    new Pieces[8],
                    new Pieces[8],
                    new Pieces[]{
                            whitePawn, whitePawn, whitePawn, whitePawn, whitePawn,
                            whitePawn, whitePawn, whitePawn},
                    new Pieces[]{
                            whiteRook, whiteKnight, whiteBishop, whiteQueen, whiteKing,
                            whiteBishop, whiteKnight, whiteRook},
            };
    static boolean start = true;

    public static void printBoard(JFrame window) {
        JPanel gui = new JPanel(new GridLayout(8, 8, 1, 1));
        JButton[][] chessBoardSquares = new JButton[8][8];
        Font font = new Font("Serif", Font.PLAIN, 45);


        for (int i = 0; i < chessBoardSquares.length; i++) {
            for (int j = 0; j < chessBoardSquares[i].length; j++) {
                JButton b = new JButton();
                b.setFont(new Font("Serif", Font.BOLD, 50));
                b.setBorder(BorderFactory.createLineBorder(BLACK));
                b.setOpaque(true);

                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    b.setBackground(WHITE);
                } else {
                    b.setBackground(RED);
                }

                chessBoardSquares[j][i] = b;

                if (board[i][j] != null) {
                    b.add(new JLabel(board[i][j].icon)).setFont(font);
                }
                gui.add(b);
            }
            window.add(gui);
        }

        window.revalidate();
    }

    static void moving() {
        Move move = new Move(1, 1, 2, 1);
        movePossible(move);
    }


    public static void movePossible(Move move) {
        if (move.isValid(board)) {
            board[move.toRank][move.toFile] = board[move.fromRank][move.fromFile];
            board[move.fromRank][move.fromFile] = null;
            System.out.println("Move is valid");
        } else {
            System.out.println("move is not valid");
        }
        printBoardToTerminal();
    }

    public static void printBoardToTerminal() {

        for (int i = 0; i < board.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].print() + "  ");
                } else {
                    System.out.print(" x  ");
                }

            }
            System.out.println(i);
        }
    }
}
