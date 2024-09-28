package game.board;

import game.Neighbors;
import game.Slot;


public class AssignNeighboursToCardsStrategy implements ProcessSlotStrategy{

    private Board board;

    public AssignNeighboursToCardsStrategy(Board board) {
        this.board = board;
    }

    @Override
    public void processSlotAndWithItsNeighbours(Slot targetSlot, Neighbors neighbours) {
        board.getCardAtSlot(targetSlot).setUpperNeighbour(board.getCardAtSlot(neighbours.getTopNeighbour()));
        board.getCardAtSlot(targetSlot).setBottomNeighbour(board.getCardAtSlot(neighbours.getBottomNeighbour()));
        board.getCardAtSlot(targetSlot).setLeftNeighbour(board.getCardAtSlot(neighbours.getLeftNeighbour()));
        board.getCardAtSlot(targetSlot).setRightNeighbour(board.getCardAtSlot(neighbours.getRightNeighbour()));
    }
}
