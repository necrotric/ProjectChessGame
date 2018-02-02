package com.company;


import java.awt.*;


public class Pawn extends Pieces {

    public Pawn(){

    }


    public Pawn(Color color) {
        super(color);
        this.value=1;
        this.piece=Piece.PAWN;

        if(color== Color.WHITE)
        {this.icon="\u2659";}
        else{
        this.icon="\u265F";
        }

    }
}


