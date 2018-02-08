package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import static com.company.Board.*;


public class Move extends Pieces {
    static int fromRank;
    static int fromFile;
    static int toRank;
    static int toFile;

    public Move() {
    }

    public Move(int fromRank, int fromFile, int toRank, int toFile) {
        this.fromRank = fromRank;
        this.fromFile = fromFile;
        this.toRank = toRank;
        this.toFile = toFile;
    }

    public boolean isValid(Pieces[][] board) {
        Pieces fromPiece = board[fromRank][fromFile];
        Pieces toPiece = board[toRank][toFile];

        System.out.println(fromPiece.getColor() + " -> " + toPiece.getColor());

        return fromPiece != emptyTile &&
                pieceMovementRule.get(fromPiece).test(this) && isEnemy()
                && clearPath();
    }


    public boolean clearPath() {
        Pieces fromPiece = board[fromRank][fromFile];
        Pieces toPiece = board[toRank][toFile];
        if (board[fromRank][fromFile].piece == ChessPiece.KNIGHT) {
            return true;
        }
        System.out.println("står en jävel i vägen");
        return false;
    }

    public boolean isEnemy() {
        Pieces fromPiece = board[fromRank][fromFile];
        Pieces toPiece = board[toRank][toFile];

        return fromPiece.getColor() != toPiece.getColor();
    }

    static Map<Pieces, Predicate<Move>> pieceMovementRule = new HashMap<>();


    static {
        //ÄNDRADE HASHMAPPEN ATT TA IN OBJECT IST FÖR ENUM
        pieceMovementRule.put(blackPawn, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.isblackPawn();
            }
        });

        pieceMovementRule.put(whitePawn, move -> Move.iswhitePawn());
        pieceMovementRule.put(blackRook, move -> Move.isVertical() || Move.isHorizontal());
        pieceMovementRule.put(whiteRook, move -> Move.isVertical() || Move.isHorizontal());
        pieceMovementRule.put(blackBishop, move -> Move.isDiagonal());
        pieceMovementRule.put(whiteBishop, move -> Move.isDiagonal());
        pieceMovementRule.put(blackKing, move -> Move.isKing());
        pieceMovementRule.put(whiteKing, move -> Move.isKing());
        pieceMovementRule.put(whiteQueen, move -> Move.isVertical() || Move.isHorizontal() || Move.isDiagonal());
        pieceMovementRule.put(blackQueen, move -> Move.isVertical() || Move.isHorizontal() || Move.isDiagonal());
        pieceMovementRule.put(blackKnight, move -> Move.isKnight());
        pieceMovementRule.put(whiteKnight, move -> Move.isKnight());
    }


    private static boolean isDiagonal() {
        return Math.abs(fromRank - toRank) - Math.abs(fromFile - toFile) == 0;
    }

    private static boolean isHorizontal() {
        return fromRank == toRank;
    }

    private static boolean isVertical() {
        return fromFile == toFile;
    }

    private static boolean isblackPawn() {
        if (fromRank == 1) {
            return fromRank + 1 == toRank && fromFile == toFile || fromRank + 2 == toRank && fromFile == toFile;
        } else {
            return fromRank + 1 == toRank && fromFile == toFile;
        }
    }

    private static boolean iswhitePawn() {
        if (fromRank == 1) {
            return fromRank - 1 == toRank && fromFile == toFile || fromRank - 2 == toRank && fromFile == toFile;
        } else {
            return fromRank - 1 == toRank && fromFile == toFile;
        }
    }

    private static boolean isKnight() {
        return 5 == (toRank - fromRank) * (toRank - fromRank) + (toFile - fromFile) * (toFile - fromFile);
    }

    private static boolean isKing() {
        if (fromRank + 1 == toRank && fromFile == toFile) {
            return true;
        } else if (fromFile + 1 == toFile && toRank == fromRank) {
            return true;
        } else if (fromFile - 1 == toFile && fromRank == toRank) {
            return true;
        } else if (fromRank - 1 == toRank && fromFile == toFile) {
            return true;
        } else {
            return false;
        }
    }
}
