package game.cards;

import game.Slot;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public interface Card {
    enum CardType{
        BEE,
        BEAR,
        DRAGONFLY,
        EAGLE,
        ELK,
        FISH,
        FOX,
        MEADOW,
        RABBIT,
        RIVER,
        WOLF
    }

    Card getUpperNeighbour();
    Card getBottomNeighbour();
    Card getLeftNeighbour();
    Card getRightNeighbour();
    void setRightNeighbour(Card card);
    void setLeftNeighbour(Card card);
    void setUpperNeighbour(Card card);
    void setBottomNeighbour(Card card);

    List<Card> getNeighbours();


    Integer count();
    CardType getType();
}
