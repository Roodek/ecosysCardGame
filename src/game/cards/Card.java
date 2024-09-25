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
    int getCoordinates();
    Card getUpperNeighbour();
    Card getBottomNeighbour();
    Card getLeftNeighbour();
    Card getRightNeighbour();
    Integer count();
    CardType getType();
}
