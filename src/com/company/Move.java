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

        System.out.println(fromPiece.getColor() + board[toRank][toFile].getColor().toString());

        return fromPiece != emptyTile &&
                pieceMovementRule.get(fromPiece).test(this) &&
                fromPiece.getColor() != toPiece.getColor();
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
        pieceMovementRule.put(whitePawn, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.iswhitePawn();

            }
        });

        pieceMovementRule.put(blackRook, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.isVertical() || Move.isHorizontal();
            }
        });

        pieceMovementRule.put(whiteRook, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.isVertical() || Move.isHorizontal();
            }
        });

        pieceMovementRule.put(blackBishop, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.isDiagonal();
            }
        });
        pieceMovementRule.put(whiteBishop, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.isDiagonal();
            }
        });
        pieceMovementRule.put(blackKing, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.isKing();
            }
        });
        pieceMovementRule.put(whiteKing, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.isKing();
            }
        });
        pieceMovementRule.put(whiteQueen, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.isVertical() || Move.isHorizontal() || Move.isDiagonal();
            }
        });
        pieceMovementRule.put(blackQueen, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.isVertical() || Move.isHorizontal() || Move.isDiagonal();
            }
        });
        pieceMovementRule.put(blackKnight, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.isBlackKnight();
            }
        });
        pieceMovementRule.put(whiteKnight, new Predicate<Move>() {
            @Override
            public boolean test(Move move) {
                return Move.isBlackKnight();
            }
        });


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

    private static boolean isDiagonal() {
        return Math.abs(fromRank - toRank) - Math.abs(fromFile - toFile) == 0;
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

    private static boolean isWhiteKing() {
        return fromRank - 1 == toRank || fromFile + 1 == toFile || fromFile - 1 == toFile;
    }

    private static boolean isBlackKnight() {
        return fromRank - toRank == 1 || fromRank - toRank == -1;
    }

}
