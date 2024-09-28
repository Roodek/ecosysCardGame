package game.board;

import game.NeighborSlots;
import game.Slot;

public interface ProcessSlotStrategy {
    void processSlotAndWithItsNeighbours(Slot targetSlot, NeighborSlots neighbours);
}
