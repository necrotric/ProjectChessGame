package com.company;

public class Queen extends Pieces {
    public Queen(Color color) {
        super(color);
        this.value=10;
        this.piece=Piece.QUEEN;

        if(color== Color.WHITE)
        {this.icon= "\u2655";}
        else{
            this.icon="\u265B";
        }

    }
}
