package com.company;

import com.company.Pieces.ChessPiece;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

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
                            blackRook, blackBishop, blackQueen, blackKing, blackBishop,
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
                            whiteRook, whiteKing, whiteBishop, whiteQueen, whiteKing,
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

//                if (board[i][j].getColor()==Color.WHITE);

                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    b.setBackground(WHITE);
                } else {
                    b.setBackground(BLACK);
                }
                chessBoardSquares[j][i] = b;

                if (board[i][j] != null) {
                    b.add(new JLabel(board[i][j].icon)).setFont(font);
                }
                gui.add(b);
            }
        }
        window.add(gui);
        window.revalidate();
    }


    static void moving(JFrame window) {
        int[] validMovesAi = new int[300];
        int countingValidIndex = 0;
        int countingValidMoves=0;
        Random rand= new Random();
        for (int i = 1; i <7; i++) {

            for (int j = 1; j <= 7; j++) {
                for (int k = 1; k <= 7; k++) {
                    for (int l = 1; l <= 7; l++) {
                        if (i != k) {

                           if(board[i][j] != null && board[i][j].getColor() == Color.WHITE) {
                                Move move = new Move(i, j, k, l);
                                if (move.isValid(board)) {
                                    board[move.toRank][move.toFile] = board[move.fromRank][move.fromFile];
                                    board[move.fromRank][move.fromFile] = null;
                                    System.out.println(i + "," + j + "," + k + "," + l);
                                    validMovesAi[countingValidIndex] = i;
                                    countingValidIndex++;
                                    validMovesAi[countingValidIndex] = j;
                                    countingValidIndex++;
                                    validMovesAi[countingValidIndex] = k;
                                    countingValidIndex++;
                                    validMovesAi[countingValidIndex] = l;
                                    countingValidIndex++;
                                    countingValidMoves++;

                                    sleep(500);
                                    printBoard(window);
                                    printBoardToTerminal();
                                } else {
                                    System.out.println("move is not valid");
                                }

                            }
                        }
                   }

                    }
                }

            }



        int number = rand.nextInt(countingValidMoves) * 4;
        for (int asd : validMovesAi) {
            System.out.print(asd);
        }
        System.out.println(validMovesAi[number]);
        for(int i=0;i<4;i++){
            System.out.print(validMovesAi[number+i]);
            int x1=validMovesAi[number+0];
            int y1=validMovesAi[number+1];
            int x2=validMovesAi[number+2];
            int y2=validMovesAi[number+3];

        }
        //Random flyttar 1 pjäs från valid move
        int x1=validMovesAi[number];
        int y1=validMovesAi[number+1];
        int x2=validMovesAi[number+2];
        int y2=validMovesAi[number+3];
        Move moveRandom= new Move(x1,y1,x2,y2);
    }


    public static void printBoardToTerminal() {

        for (int i = 0; i < board.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].print() + "  ");
                } else {
                    System.out.print("  ORANGE");
                }

            }
            System.out.println(i);
        }
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
