package com.company;

public class King extends Pieces {
    public King(Team team) {
        super(team);
        this.value = 9999;
        this.piece = ChessPiece.KING;
        this.icon = "\u265A";
    }
}
