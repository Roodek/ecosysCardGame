package game.board;

import game.Slot;
import game.cards.Card;

import java.util.ArrayList;

public interface ProcessSlotStrategy {
    void processSlotAndWithItsNeighbours(Slot targetSlot, ArrayList<Slot> neighbours);
}
