package com.company;

public abstract class Pieces {
    enum ChessPiece {
        ROOK,
        BISHOP,
        KING,
        QUEEN,
        PAWN,
        KNIGHT
    }

    enum Team {
        BLACK,
        WHITE,
        ORANGE
    }


    int value;
    String icon;
    Team team;
    ChessPiece piece;

    Pieces() {
        this.team = team;
    }


    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    Pieces(Team team) {
        this.team = team;
        this.value = value;
        this.icon = icon;
        this.piece = piece;

    }


    String print() {
        return icon + team;
    }

}