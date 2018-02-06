package com.company;

public class King extends Pieces {
    public King(Color color) {
        super(color);
        this.value=9999;
        this.piece=ChessPiece.KING;

        if(color== Color.WHITE)
        {this.icon="\u2654";
        }
        else{
            this.icon="\u265A";
        }

    }
}
