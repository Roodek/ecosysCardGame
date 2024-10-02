package game;

import game.board.Board;
import game.cards.Card;
import game.cards.ElkCard;
import game.cards.FieldCard;

import java.util.*;

public class Player {

    private Board board;

    private Integer numberOfGaps = 0;
    private Integer sumOfPoints = 0;

    private Integer ecosystemGapPoints = 0;
    private List<Player> players;

    private Map<Card.CardType, Integer> generalPointCount = new HashMap<>();

    public Player(List<Player> players){
        this.players = players;
        this.board = new Board();
        Arrays.stream(Card.CardType.values()).forEach(cardType -> generalPointCount.put(cardType, 0));
    }

    private void countPointsForGivenCardTypeInGeneralPointCount(Card card) {
        var cardPoints = card.count();
        generalPointCount.put(card.getType(), generalPointCount.get(card.getType()) + cardPoints);
    }
    public void countAllCardPointsAndPutThemToGeneralPointCount(){
        for(var card:this.board.getCardBoard().stream()
                .flatMap(Collection::stream).toList()){
            switch (card.getType()){
                case RIVER:
                    this.board.setMaxRiverLength(Math.max(this.board.getMaxRiverLength(),((FieldCard)card).getFieldSize()));
                    break;
                case WOLF:
                    this.board.setWolfCount(this.board.getWolfCount()+1);
                    break;
                case ELK:
                    break;
                default:
                    countPointsForGivenCardTypeInGeneralPointCount(card);
            }
        }
        countElkPoints();
        compareWolvesAndAssignPoints();
        compareRiversAndAssignPoints();
    }

    private void countElkPoints() {
        var rowsWithAtLeast1Elk = (int) this.board.getCardBoard().stream()
                .filter(row -> row.stream()
                        .anyMatch(card -> card.getType() == Card.CardType.ELK)
                ).count();
        var columnsWithAtLeast1Elk = 0;
        for (var y = 0; y < this.board.getSizeVertical(); y++) {
            if(getColumn(y).stream().anyMatch(card->card.getType()== Card.CardType.ELK)){
                columnsWithAtLeast1Elk++;
            }
        }
        generalPointCount.put(Card.CardType.ELK,(rowsWithAtLeast1Elk+columnsWithAtLeast1Elk) * ElkCard.POINTS_PER_VALID) ;
    }

    private List<Card> getColumn(int coordY) {
        return this.board.getCardBoard().stream().map(row -> row.get(coordY)).toList();
    }

    private void compareRiversAndAssignPoints() {
        //TODO
        var count = 0;

        generalPointCount.put(Card.CardType.RIVER,count);
    }

    private void compareWolvesAndAssignPoints() {
        //TODO
        var count = 0;
        generalPointCount.put(Card.CardType.WOLF,count);
    }

    public void endGame() {
        countAllCardPointsAndPutThemToGeneralPointCount();
        countEcosystemGapsPoints();
        sumAllPoints();
    }

    private void countEcosystemGapsPoints() {
        this.numberOfGaps = (int) generalPointCount.values().stream().filter(pointsPerType-> pointsPerType==0).count();
        switch (this.numberOfGaps) {
            case 0, 1, 2 -> this.ecosystemGapPoints = 12;
            case 3 -> this.ecosystemGapPoints = 7;
            case 4 -> this.ecosystemGapPoints = 3;
            case 5 -> this.ecosystemGapPoints = 0;
            default -> this.ecosystemGapPoints = -5;
        };
    }

    private void sumAllPoints(){
        this.sumOfPoints = this.generalPointCount.values().stream().reduce(0, Integer::sum) +this.ecosystemGapPoints;
    }
}
