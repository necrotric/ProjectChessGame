package com.company;

import java.awt.*;

public abstract class Pieces {
    enum Piece {
        ROOK,
        BISHOP,
        KING,
        QUEEN,
        PAWN,
        KNIGHT
    }

    enum Color{
        BLACK,
        WHITE
    }


    int value;
    String icon;
    private Color color;
    Piece piece;
    Pieces(){
    }

    Pieces(Color color){
        this.color=color;
        this.value=value;
        this.icon=icon;
        this.piece=piece;

    }

String print (){
        return icon+color;
}
}