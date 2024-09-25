package game.cards;

public abstract class BasicCard implements Card{

    int coordX;
    int coordY;
    CardType type;
    Card upperNeighbour;
    Card bottomNeighbour;
    Card leftNeighbour;
    Card rightNeighbour;
    BasicCard(CardType type){
        this.type = type;
    }
    @Override
    public int getCoordinateX() {
        return this.coordX;
    }

    @Override
    public int getCoordinateY() {
        return this.coordY;
    }

    @Override
    public void setCoordinateX(int x) {
        this.coordX = x;
    }

    @Override
    public void setCoordinateY(int y) {
        this.coordY = y;
    }

    @Override
    public void setCoordinates(int x, int y) {
        this.coordX = x;
        this.coordY = y;
    }

    @Override
    public Card getUpperNeighbour() {
        return this.upperNeighbour;
    }

    @Override
    public Card getBottomNeighbour() {
        return this.bottomNeighbour;
    }

    @Override
    public Card getLeftNeighbour() {
        return this.leftNeighbour;
    }

    @Override
    public Card getRightNeighbour() {
        return this.rightNeighbour;
    }

    @Override
    public void setUpperNeighbour(Card upperNeighbour) {
        this.upperNeighbour = upperNeighbour;
    }

    @Override
    public void setBottomNeighbour(Card bottomNeighbour) {
        this.bottomNeighbour = bottomNeighbour;
    }

    @Override
    public void setLeftNeighbour(Card leftNeighbour) {
        this.leftNeighbour = leftNeighbour;
    }

    @Override
    public void setRightNeighbour(Card rightNeighbour) {
        this.rightNeighbour = rightNeighbour;
    }

    @Override
    public CardType getType() {
        return this.type;
    }

    @Override
    public Integer count() {
        return 0;
    }
}
