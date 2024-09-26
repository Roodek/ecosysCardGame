package game;

import java.util.List;

public class BoardAvailableMoveCalculator {

    private Board board;

    public BoardAvailableMoveCalculator(Board board) {
        this.board = board;
    }

    public List<Move> getAvailableMoves() {
        if(board.getCurrentBoardSizeVertical()==0)
            return List.of();
        else{
            //TODO
        }
        return List.of();
    }

}
