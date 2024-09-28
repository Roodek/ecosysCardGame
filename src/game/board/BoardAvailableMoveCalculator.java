package game.board;

import game.Slot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BoardAvailableMoveCalculator {

    private Board board;

    public BoardAvailableMoveCalculator(Board board) {
        this.board = board;
    }

    public Set<Slot> getAvailableMoves() {
        if(board.getCardBoard().isEmpty())
            return Set.of();
        else{
            var possibleMoveSet = new HashSet<Slot>();
            for(int i =0;i<board.getCardBoard().size();i++){
                for(int j = 0;j<board.getCardBoard().get(i).size();j++){
                    possibleMoveSet.addAll(checkNeighbours(i, j));
                }
            }
            return possibleMoveSet;
        }
    }

    private ArrayList<Slot> checkNeighbours(int x, int y){
        var availableMoves = new ArrayList<Slot>();
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
        return x == board.getCardBoard().size()-1 && y < board.getCardBoard().get(x).size() - 1 && y > 0;
    }
    private boolean isUpperWall(int x, int y) {
        return x == 0 && y < board.getCardBoard().get(x).size() - 1 && y > 0;
    }
    private boolean isLeftWall(int x, int y) {
        return x > 0 && x < board.getCardBoard().size() - 1 && y == 0;
    }
    private boolean isRightWall(int x, int y) {
        return x > 0 && x < board.getCardBoard().size() - 1 && y == board.getCardBoard().get(x).size()-1;
    }

    private boolean isBottomRightCorner(int x, int y) {
        return x == board.getCardBoard().size() - 1 && y == board.getCardBoard().get(x).size() - 1;
    }

    private boolean isBottomLeftCorner(int x, int y) {
        return x == board.getCardBoard().size() - 1 && y == 0;
    }

    private boolean isUpperRightCorner(int x, int y) {
        return x == 0 && y == board.getCardBoard().get(x).size() - 1;
    }

    private static boolean ilsLeftUpperCorner(int x, int y) {
        return x == 0 && y == 0;
    }

    private void addBottomSlotIfPossible(int x, int y, ArrayList<Slot> availableSlots) {
        if(board.getCardBoard().get(x+1).get(y)==null){
            availableSlots.add(new Slot(x+1, y ));
        }
    }

    private void addRightSlotIfPossible(int x, int y, ArrayList<Slot> availableSlots) {
        if(board.getCardBoard().get(x).get(y+1)==null){
            availableSlots.add(new Slot(x, y+1));
        }
    }
    private void addTopSlotIfPossible(int x, int y, ArrayList<Slot> availableSlots) {
        if(board.getCardBoard().get(x-1).get(y)==null){
            availableSlots.add(new Slot(x-1, y));
        }
    }
    private void addLeftSlotIfPossible(int x, int y, ArrayList<Slot> availableSlots) {
        if(board.getCardBoard().get(x).get(y-1)==null){
            availableSlots.add(new Slot(x, y-1));
        }
    }

}
