package com.company;

public class Bishop extends Pieces {

    public Bishop(){}

    public Bishop(Color color) {

        super(color);
        this.value=3;
        this.piece=Piece.KNIGHT;

        if(color== Color.WHITE)
        {this.icon="\u2657";}
        else{
            this.icon="\u265D ";
        }
    }
}
