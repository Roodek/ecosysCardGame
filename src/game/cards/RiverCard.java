package game.cards;

public class RiverCard extends FieldCard implements Card  {
    public RiverCard() {
        super(CardType.RIVER);
    }

    @Override
    public Integer count() {
        buildField();
        return super.count();
    }
}
