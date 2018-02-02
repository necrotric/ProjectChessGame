package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import static com.company.Board.blackPawn;


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
        Pieces piece = board[fromRank][fromFile];

        if (piece == null) {
            System.out.println("move is not valid");
            return false;
        } else {
            System.out.println("Move is valid");

            return pieceMovementRule.get(piece).test(this);
        }
    }

    static Map<Pieces, Predicate<Move>> pieceMovementRule = new HashMap<>();


    static {
        //ÄNDRADE HASHMAPPEN ATT TA IN OBJECT IST FÖR ENUM
        pieceMovementRule.put(blackPawn, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.isPawn();
            }
        });


/*        pieceMovementRule.put(Piece.ROOK, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.isVertical() || Move.isHorizontal();
            }
        });
        pieceMovementRule.put(Piece.BISHOP, (move -> Move.isDiagonal()));
        pieceMovementRule.put(Piece.KNIGHT, (move) -> Move.isKnight());*/
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
