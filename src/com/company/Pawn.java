package com.company;


public class Pawn extends Pieces {

    public Pawn(){

    }


    public Pawn(Team team) {
        super(team);
        this.value=1;
        this.piece=ChessPiece.PAWN;
        this.icon="\u265F";
    }


}


