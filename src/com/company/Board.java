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
                            blackRook, blackRook, blackBishop, blackQueen, blackKing,
                            blackBishop, blackRook, blackRook},
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
                            whiteRook, whiteRook, whiteBishop, whiteQueen, whiteKing,
                            whiteBishop, whiteRook, whiteRook},
            };
    static boolean start = true;

    public static void printBoard(JFrame window) {
        String COLS = "  ABCDEFGH";
        JPanel gui = new JPanel(new GridLayout(9, 9, 1, 1));
        JButton[][] chessBoardSquares = new JButton[8][8];
        Font font = new Font("Serif", Font.PLAIN, 45);

        Border border = BorderFactory.createLineBorder(BLACK,2);

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


                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    b.setBackground(WHITE);
                } else {
<<<<<<< HEAD
                    b.setBackground(DARK_GRAY);
=======
                    b.setBackground(RED);
>>>>>>> fh
                }
                chessBoardSquares[j][i] = b;

                if (board[i][j] != null) {
                    b.add(new JLabel(board[i][j].icon)).setFont(font);
                    b.setOpaque(true);
                    b.setForeground(RED);
                }
                gui.add(b);
            }
        }
        window.add(gui);

        window.revalidate();
    }


    static void moving(JFrame window) {
 /*       int[] validMovesAi = new int[30000];

        int countingValidIndex = 0;
        int countingValidMoves = 0;
        long loops = 0;
        Random rand = new Random();
        for (int o = 0; o < 100; o++) {
            loops++;
            for (int i = 0; i < board.length; i++) {
                loops++;
                for (int j = 0; j < board.length; j++) {
                    loops++;
                    for (int k = 0; k < board.length; k++) {
                        loops++;
                        for (int l = 0; l < board.length; l++) {
                            loops++;
                            if (i != k || j != l) {
                                if (board[i][j] != null) {
                                    Move move = new Move(i, j, k, l);
                                    if (move.isValid(board)) {
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

                                        //sleep(500);
                                        printBoard(window);
                                        printBoardToTerminal();
                                        System.out.println(String.format("Move valid: [%d, %d -> %d, %d]", i, j, k, l));
                                    } else {
                                        //      System.out.println("move is not valid");
                                    }
                                }
                            }
                        }
                    }
                }


            }


            int number = rand.nextInt(countingValidMoves) * 4;
            int divider = 1;
            for (int asd : validMovesAi) {
                if (divider % 4 == 0) {
                    System.out.print(asd + " ");
                    divider++;
                } else {
                    System.out.print(asd);
                    divider++;
                }
            }


            System.out.println(validMovesAi[number]);
            for (int i = 0; i < countingValidIndex; i++) ;
            for (int i = 0; i < 4; i++) {
                System.out.print(validMovesAi[number + i]);

            }


            //Random flyttar 1 pjäs från valid move
            int x1 = validMovesAi[number];
            int y1 = validMovesAi[number + 1];
            int x2 = validMovesAi[number + 2];
            int y2 = validMovesAi[number + 3];
            Move moveRandom = new Move(x1, y1, x2, y2);


            if (moveRandom.isValid(board)) {
                board[moveRandom.toRank][moveRandom.toFile] = board[moveRandom.fromRank][moveRandom.fromFile];
                board[moveRandom.fromRank][moveRandom.fromFile] = null;
            }

            printBoard(window);
            printBoardToTerminal();

        }*/
    Move move = new Move(0,0,7,0);
   if(move.isValid(board)){
       board[move.toRank][move.toFile] = board[move.fromRank][move.fromFile];
       board[move.fromRank][move.fromFile] = null;
   }





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
