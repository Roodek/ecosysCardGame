package game.board;

import game.Move;
import game.cards.Card;

import java.util.ArrayList;
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

            //TODO
        }
        return Set.of();
    }

    private ArrayList<Move> checkNeighbours(int x, int y){
        var availableMoves = new ArrayList<Move>();
        if(board.getCardBoard().get(x).get(y)!=null){
            if(x==0 && y==0){
                addRightSlotIfPossible(x, y, availableMoves);
                addBottomSlotIfPossible(x, y, availableMoves);
            }
            if(x==0 && y== board.getSizeVertical()-1){
                addLeftSlotIfPossible(x,y,availableMoves);
                addBottomSlotIfPossible(x,y,availableMoves);
            }

        }
        return availableMoves;
    }

    private void addBottomSlotIfPossible(int x, int y, ArrayList<Move> availableMoves) {
        if(board.getCardBoard().get(x).get(y +1)!=null){
            availableMoves.add(new Move(x, y +1));
        }
    }

    private void addRightSlotIfPossible(int x, int y, ArrayList<Move> availableMoves) {
        if(board.getCardBoard().get(x +1).get(y)!=null){
            availableMoves.add(new Move(x +1, y));
        }
    }
    private void addTopSlotIfPossible(int x, int y, ArrayList<Move> availableMoves) {
        if(board.getCardBoard().get(x-1).get(y)!=null){
            availableMoves.add(new Move(x-1, y));
        }
    }
    private void addLeftSlotIfPossible(int x, int y, ArrayList<Move> availableMoves) {
        if(board.getCardBoard().get(x).get(y-1)!=null){
            availableMoves.add(new Move(x, y-1));
        }
    }

}
