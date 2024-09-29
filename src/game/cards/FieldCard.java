package game.cards;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public abstract class FieldCard extends BasicCard implements Card {


    private Set<FieldCard> sameFieldCards;
    private String groupID = UUID.randomUUID().toString();

    private Integer fieldSize=1;

    public Integer getFieldSize() {
        return fieldSize;
    }
    FieldCard(CardType type) {
        super(type);
    }

    public Set<FieldCard> getSameFieldCards() {
        return sameFieldCards;
    }

    public void setSameFieldCards(Set<FieldCard> sameFieldCards) {
        this.sameFieldCards = sameFieldCards;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    protected void buildField(){
        sameFieldCards.add(this);
        List<FieldCard> neighbourFieldCards = getNeighbours().stream()
                .filter(card -> card.getType()==this.getType())
                .map(card->(FieldCard)card)
                .filter(fieldCard -> !Objects.equals(fieldCard.getGroupID(), this.getGroupID()))
                .toList();

        neighbourFieldCards.forEach(FieldCard::buildField);

    }
}
