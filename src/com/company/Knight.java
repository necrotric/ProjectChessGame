package com.company;

public class Knight extends Pieces {

    public Knight(){

    }

    public Knight(Color color) {
        super(color);
        this.value=2;
        this.piece=ChessPiece.KNIGHT;

        if(color== Color.WHITE)
        {this.icon="\u2658";}
        else{
            this.icon="\u265E";
        }

    }
}
