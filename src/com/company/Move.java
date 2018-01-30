package com.company;

import javax.swing.border.Border;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import static com.company.ChessMusings.*;

public class Move {
    static int fromRank;
    static int fromFile;
    static int toRank;
    static int toFile;

    public Move(int fromRank, int fromFile, int toRank, int toFile) {
        this.fromRank = fromRank;
        this.fromFile = fromFile;
        this.toRank = toRank;
        this.toFile = toFile;
    }

    public boolean isValid(Piece[][] board) {
        Piece piece = board[fromRank][fromFile];

        if (piece == null) {
            return false;
        }

        return pieceMovementRule.get(piece).test(this);
    }

    static Map<Piece, Predicate<Move>> pieceMovementRule = new HashMap<>();

    static {
        pieceMovementRule.put(Piece.ROOK, (move) -> Move.isVertical() || Move.isHorizontal());
        pieceMovementRule.put(Piece.PAWN, (move) -> Move.isPawn());
        pieceMovementRule.put(Piece.BISHOP, (move -> Move.isDiagonal()));
        pieceMovementRule.put(Piece.KNIGHT, (move) -> Move.isKnight());

    }


    private static boolean isHorizontal() {
        return fromRank == toRank;
    }

    private static boolean isVertical() {
        return fromFile == toFile;
    }

    private static boolean isPawn() {
        return fromRank + 2 == toRank || fromRank - 2 == toRank || fromRank + 1 == toRank || fromRank - 1 == toRank;
    }

    private static boolean isDiagonal() {
        return (fromRank - toRank) / (fromFile - toFile) == 1 || (fromRank - toRank) / (fromFile - toFile) == -1;
    }

    private static boolean isKnight() {
        return (fromRank - toRank) / (fromFile - toFile) == 2 || (fromRank - toRank) / (fromFile - toFile) == -2
                || (fromFile - toFile) / (fromRank - toRank) == 2 || (fromFile - toFile) / (fromRank - toRank) == -2;
    }


}
