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
        WHITE
    }


    int value;
    String icon;
    private Color color;
    ChessPiece piece;

    Pieces() {
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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