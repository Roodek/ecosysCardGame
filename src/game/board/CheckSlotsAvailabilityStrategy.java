package game.board;

import game.Slot;
import game.cards.Card;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CheckSlotsAvailabilityStrategy implements ProcessSlotStrategy{

    public CheckSlotsAvailabilityStrategy(Board board) {
        this.board = board;
    }

    private Board board;
    private Set<Slot> availableMoves = new HashSet<>();
    @Override
    public void processSlotAndWithItsNeighbours(Slot targetSlot, ArrayList<Slot> neighbours) {
        if(board.getCardAtSlot(targetSlot)!=null){
            for(var slot:neighbours){
                if (board.getCardAtSlot(slot)==null){
                    availableMoves.add(slot);
                }
            }
        }
    }


}
