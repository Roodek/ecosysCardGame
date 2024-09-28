package game.cards;

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
    Integer count();
    CardType getType();
}
