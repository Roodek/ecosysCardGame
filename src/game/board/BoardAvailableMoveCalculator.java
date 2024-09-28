package game.board;

import game.Move;
import game.cards.Card;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoardAvailableMoveCalculator {

    private Board board;

    public BoardAvailableMoveCalculator(Board board) {
        this.board = board;
    }

    public Set<Move> getAvailableMoves() {
        if(board.getCardBoard().isEmpty())
            return Set.of();
        else{
            var possibleMoveSet = new HashSet<Move>();
            for(int i =0;i<board.getCardBoard().size();i++){
                for(int j = 0;j<board.getCardBoard().get(i).size();j++){
                    possibleMoveSet.addAll(checkNeighbours(i, j));
                }
            }
            return possibleMoveSet;
        }
    }

    private ArrayList<Move> checkNeighbours(int x, int y){
        var availableMoves = new ArrayList<Move>();
        if(board.getCardBoard().get(x).get(y)!=null){
            if(ilsLeftUpperCorner(x, y)){
                addRightSlotIfPossible(x, y, availableMoves);
                addBottomSlotIfPossible(x, y, availableMoves);
            }
            else if(isUpperRightCorner(x, y)){
                addLeftSlotIfPossible(x,y,availableMoves);
                addBottomSlotIfPossible(x,y,availableMoves);
            }
            else if(isBottomLeftCorner(x, y)){
                addTopSlotIfPossible(x,y,availableMoves);
                addRightSlotIfPossible(x,y,availableMoves);
            }
            else if(isBottomRightCorner(x, y)){
                addTopSlotIfPossible(x,y,availableMoves);
                addLeftSlotIfPossible(x,y,availableMoves);
            }
            else if(isLeftWall(x, y)){
                addTopSlotIfPossible(x,y,availableMoves);
                addBottomSlotIfPossible(x,y,availableMoves);
                addRightSlotIfPossible(x,y,availableMoves);
            }
            else if(isRightWall(x,y)){
                addTopSlotIfPossible(x,y,availableMoves);
                addBottomSlotIfPossible(x,y,availableMoves);
                addLeftSlotIfPossible(x,y,availableMoves);
            }
            else if(isUpperWall(x,y)){
                addRightSlotIfPossible(x,y,availableMoves);
                addBottomSlotIfPossible(x,y,availableMoves);
                addLeftSlotIfPossible(x,y,availableMoves);
            }
            else if(isBottomWall(x,y)){
                addRightSlotIfPossible(x,y,availableMoves);
                addTopSlotIfPossible(x,y,availableMoves);
                addLeftSlotIfPossible(x,y,availableMoves);
            }
            else {
                addRightSlotIfPossible(x,y,availableMoves);
                addTopSlotIfPossible(x,y,availableMoves);
                addLeftSlotIfPossible(x,y,availableMoves);
                addBottomSlotIfPossible(x,y,availableMoves);
            }


        }
        return availableMoves;
    }

    private boolean isBottomWall(int x, int y) {
        return x == board.getMaxVerticalSize()-1 && y < board.getMaxHorizontalSize() - 1 && y > 0;
    }
    private boolean isUpperWall(int x, int y) {
        return x == 0 && y < board.getMaxHorizontalSize() - 1 && y > 0;
    }
    private boolean isLeftWall(int x, int y) {
        return x > 0 && x < board.getMaxVerticalSize() - 1 && y == 0;
    }
    private boolean isRightWall(int x, int y) {
        return x > 0 && x < board.getMaxVerticalSize() - 1 && y == board.getMaxHorizontalSize()-1;
    }

    private boolean isBottomRightCorner(int x, int y) {
        return x == board.getMaxVerticalSize() - 1 && y == board.getMaxHorizontalSize() - 1;
    }

    private boolean isBottomLeftCorner(int x, int y) {
        return x == board.getMaxVerticalSize() - 1 && y == 0;
    }

    private boolean isUpperRightCorner(int x, int y) {
        return x == 0 && y == board.getMaxHorizontalSize() - 1;
    }

    private static boolean ilsLeftUpperCorner(int x, int y) {
        return x == 0 && y == 0;
    }

    private void addBottomSlotIfPossible(int x, int y, ArrayList<Move> availableMoves) {
        if(board.getCardBoard().get(x+1).get(y)==null){
            availableMoves.add(new Move(x+1, y ));
        }
    }

    private void addRightSlotIfPossible(int x, int y, ArrayList<Move> availableMoves) {
        if(board.getCardBoard().get(x).get(y+1)==null){
            availableMoves.add(new Move(x, y+1));
        }
    }
    private void addTopSlotIfPossible(int x, int y, ArrayList<Move> availableMoves) {
        if(board.getCardBoard().get(x-1).get(y)==null){
            availableMoves.add(new Move(x-1, y));
        }
    }
    private void addLeftSlotIfPossible(int x, int y, ArrayList<Move> availableMoves) {
        if(board.getCardBoard().get(x).get(y-1)==null){
            availableMoves.add(new Move(x, y-1));
        }
    }

}
