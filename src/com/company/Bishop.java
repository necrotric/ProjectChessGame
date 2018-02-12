package com.company;

public class Bishop extends Pieces {

    public Bishop() {
    }

    public Bishop(Team team) {

        super(team);
        this.value = 3;
        this.piece = ChessPiece.BISHOP;
        this.icon = "\u265D";

    }
}
