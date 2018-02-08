package com.company;

import java.awt.*;

public abstract class Pieces {
    enum ChessPiece {
        ROOK,
        BISHOP,
        KING,
        QUEEN,
        PAWN,
        KNIGHT
    }

    enum Color {
        BLACK,
        WHITE,
        ORANGE
    }


    int value;
    String icon;
    Color color;
    ChessPiece piece;

    Pieces() {
        this.color=color;
    }


    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    Pieces(Color color) {
        this.color = color;
        this.value = value;
        this.icon = icon;
        this.piece = piece;

    }


    String print() {

        return icon + color;


    }
}