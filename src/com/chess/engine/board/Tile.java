package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected  final int tileCoordinate;    //protected-so that it can be accessed only by it's subclasses. final-cannot be changed
    private static final Map<Integer,EmptyTile> EMPTY_TILES_CACHE=createAllPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer, EmptyTile> emptyTileMap=new HashMap<>();
        for(int i=0;i<BoardUtils.NUM_TILES;i++){
            emptyTileMap.put(i,new EmptyTile(i));
        }
        return ImmutableMap.copyOf(emptyTileMap);   //ImmutableMap doesn't exist in JDK. It is part of a Guava library which is a third-party library provided by Google. We need it for immutability. Download and import.
        //return Collections.unmodifiableMap(emptyTileMap); Or this
    }

    public static Tile createTile(final int tileCoordinate, final Piece piece){
        return piece!=null?new OccupiedTile(tileCoordinate,piece): EMPTY_TILES_CACHE.get(tileCoordinate);
    }

    public int getTileCoordinate(){
        return this.tileCoordinate;
    }

    private Tile(final int tileCoordinate){
        this.tileCoordinate=tileCoordinate;
    }

    public abstract boolean isTileOccupied();
    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile{

        private EmptyTile(final int tileCoordinate){
            super(tileCoordinate);
        }

        @Override
        public boolean isTileOccupied(){
            return false;
        }

        @Override
        public Piece getPiece(){
            return null;
        }

        @Override
        public String toString(){
            return "-";
        }
    }

    public static final class OccupiedTile extends Tile{

        private final Piece pieceOnTile;    //private-so that there's no way to reference it outside the class.
        private OccupiedTile(int tileCoordinate,final Piece pieceOnTile){
            super(tileCoordinate);
            this.pieceOnTile=pieceOnTile;
        }

        @Override
        public boolean isTileOccupied(){
            return true;
        }

        @Override
        public Piece getPiece(){
            return pieceOnTile;
        }

        @Override
        public String toString(){
            return getPiece().getPieceAlliance().isBlack()?getPiece().toString().toLowerCase():getPiece().toString();
        }
    }
}
