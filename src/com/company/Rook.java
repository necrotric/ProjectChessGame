package com.company;

public class Rook extends Pieces{
    public Rook(){

    }


    public Rook(Team team) {
        super(team);
        this.value=5;
        this.piece=ChessPiece.ROOK;
        this.icon="\u265C";
    }
}
