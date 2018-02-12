package com.company;

public class Queen extends Pieces {

    public Queen(Team team) {
        super(team);
        this.value = 10;
        this.piece = ChessPiece.QUEEN;
        this.icon = "\u265B";
    }
}
