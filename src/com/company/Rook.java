package com.company;

public class Rook extends Pieces{
    public Rook(){

    }


    public Rook(Color color) {
        super(color);
        this.value=5;
        this.piece=ChessPiece.ROOK;

        if(color== Color.WHITE)
        {this.icon="\u2656";}
        else{
            this.icon="\u265C ";
        }

    }
}
