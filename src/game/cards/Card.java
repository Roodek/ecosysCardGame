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
    enum CardSide{
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }
    int getCoordinateX();
    int getCoordinateY();
    void setCoordinateX(int x);
    void setCoordinateY(int y);
    void setCoordinates(int x, int y);
    Card getUpperNeighbour();
    Card getBottomNeighbour();
    Card getLeftNeighbour();
    void setRightNeighbour(Card card);
    void setLeftNeighbour(Card card);
    void setUpperNeighbour(Card card);
    void setBottomNeighbour(Card card);
    Card getRightNeighbour();
    Integer count();
    CardType getType();
}
