package com.company;

public class Knight extends Pieces {

    public Knight() {

    }

    public Knight(Team team) {
        super(team);
        this.value = 2;
        this.piece = ChessPiece.KNIGHT;
        this.icon = "\u265E";
    }
}
