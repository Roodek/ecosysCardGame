package game.board;

import game.Neighbors;
import game.Slot;
import game.cards.Card;

import java.util.ArrayList;

public interface ProcessSlotStrategy {
    void processSlotAndWithItsNeighbours(Slot targetSlot, Neighbors neighbours);
}
