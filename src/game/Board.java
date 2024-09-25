package game;

import game.cards.Card;

import java.util.ArrayList;

public class Board {

    private static final int BOARD_LIMIT_5 = 5;
    private static final int BOARD_LIMIT_4 = 4;
    private int currentBoardSizeVertical = 0;
    private int currentBoardSizeHorizontal = 0;
    private ArrayList<ArrayList<Card>> cardBoard = new ArrayList<>();
    public int getCurrentBoardSizeVertical() {
        return currentBoardSizeVertical;
    }

    public int getCurrentBoardSizeHorizontal() {
        return currentBoardSizeHorizontal;
    }
    public void printBoard(){
        for (var row:cardBoard){
            for(var card:row){
                System.out.print(card.getType().toString()+card.getCoordinateX()+card.getCoordinateY());
            }
            System.out.println();
        }

    }

    public ArrayList<ArrayList<Card>> getCardBoard(){
        return cardBoard;
    }
    public void putCard(Card card, Card alreadyLaidCard, Card.CardSide side) {
        if(cardBoard.isEmpty()){
            card.setCoordinates(0,0);
            var newRow = new ArrayList<Card>();
            newRow.add(card);
            cardBoard.add(newRow);
            currentBoardSizeHorizontal++;
            currentBoardSizeVertical++;
        }else {
            switch (side){
                case TOP -> putCardOnTopOfAnother(card, alreadyLaidCard);
                case BOTTOM -> {

                }
                case LEFT -> {}
                case RIGHT -> {}
            }
        }

    }

    private void putCardOnTopOfAnother(Card card, Card alreadyLaidCard) {
        if(alreadyLaidCard.getCoordinateX()==0){
            addNewRowWithNewCard(card, alreadyLaidCard);
            shiftIndicesOfThisCardAndCardsBelow(alreadyLaidCard);
        }else{
            cardBoard.get(alreadyLaidCard.getCoordinateX()-1).add(alreadyLaidCard.getCoordinateY(), card);
        }

    }

    private void addNewRowWithNewCard(Card card, Card alreadyLaidCard) {
        card.setCoordinates(0, alreadyLaidCard.getCoordinateY());
        cardBoard.add(0,new ArrayList<>(currentBoardSizeHorizontal));
        cardBoard.get(0).add(alreadyLaidCard.getCoordinateY(), card);
        currentBoardSizeVertical++;
    }

    private void shiftIndicesOfThisCardAndCardsBelow(Card alreadyLaidCard) {
        for(int i = alreadyLaidCard.getCoordinateX(); i<cardBoard.size()-1; i++){
            var shiftedCard = cardBoard.get(i+1).get(alreadyLaidCard.getCoordinateY());
            if(shiftedCard!=null)
                shiftedCard.setCoordinateX(shiftedCard.getCoordinateX()+1);
        }
    }

//    private Integer countFinalPoints(){
//        return cards.stream().map(Card::count).reduce(0, Integer::sum);
//    }


}
