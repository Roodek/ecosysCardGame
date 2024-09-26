package game;

import game.cards.Card;

import java.util.ArrayList;

public class Board {

    public static final int CARD_NAME_LENGTH =11;
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
                if(card!=null) {
                    var padding = CARD_NAME_LENGTH - (card.getType().toString().length()+2);
                    System.out.printf("%s%d%d%s", card.getType().toString(), card.getCoordinateX(), card.getCoordinateY(), " ".repeat(Math.max(0, padding)));
                }else {
                    System.out.printf("%s"," ".repeat(Math.max(0, CARD_NAME_LENGTH)));
                }
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
                case BOTTOM -> putCardOnBottomOfAnother(card, alreadyLaidCard);
                case LEFT -> putCardOnLeftOfAnother(card, alreadyLaidCard);
                case RIGHT -> putCardOnRightOfAnother(card, alreadyLaidCard);
            }
        }

    }

    private void putCardOnRightOfAnother(Card card, Card alreadyLaidCard) {
        if(alreadyLaidCard.getCoordinateY()==currentBoardSizeHorizontal-1){
            addNewColumnWithNewCardOnTheRight(card, alreadyLaidCard);
            currentBoardSizeHorizontal++;
        }else{
            card.setCoordinates(alreadyLaidCard.getCoordinateX(), alreadyLaidCard.getCoordinateY()+1);
            cardBoard.get(alreadyLaidCard.getCoordinateX()).set(alreadyLaidCard.getCoordinateY()+1, card);
        }
    }

    private void addNewColumnWithNewCardOnTheRight(Card card, Card alreadyLaidCard) {
        card.setCoordinates(alreadyLaidCard.getCoordinateX(),currentBoardSizeHorizontal);
        for (int i=0;i<cardBoard.size();i++){
            if(i == alreadyLaidCard.getCoordinateX())
                cardBoard.get(i).add(card);
            else
                cardBoard.get(i).add(null);
        }
    }

    private void putCardOnLeftOfAnother(Card card, Card alreadyLaidCard) {
        if(alreadyLaidCard.getCoordinateY()==0) {
            addNewColumnWithNewCardOnTheLeft(card, alreadyLaidCard);
            currentBoardSizeHorizontal++;
        }else{
            card.setCoordinates(alreadyLaidCard.getCoordinateX(), alreadyLaidCard.getCoordinateY()-1);
            cardBoard.get(alreadyLaidCard.getCoordinateX()).set(alreadyLaidCard.getCoordinateY()-1, card);
        }
    }

    private void addNewColumnWithNewCardOnTheLeft(Card card, Card alreadyLaidCard) {
        card.setCoordinates(alreadyLaidCard.getCoordinateX(),0);
        for(int i =0;i<cardBoard.size();i++){
            shiftIndicesOfCardsToTheRight(i);
            addNewFirstColumnWithNewCard(card, alreadyLaidCard, i);
        }
    }

    private void addNewFirstColumnWithNewCard(Card card, Card alreadyLaidCard, int i) {
        if(i == alreadyLaidCard.getCoordinateX())
            cardBoard.get(i).add(0, card);
        else
            cardBoard.get(i).add(0,null);
    }

    private void shiftIndicesOfCardsToTheRight(int i) {
        for(int j = 0; j<cardBoard.get(i).size(); j++){
            if(cardBoard.get(i).get(j)!=null)
                cardBoard.get(i).get(j).setCoordinateY(cardBoard.get(i).get(j).getCoordinateY()+1);
        }
    }

    private void putCardOnBottomOfAnother(Card card, Card alreadyLaidCard) {
        if(alreadyLaidCard.getCoordinateX()==currentBoardSizeVertical-1)
            addNewRowWithNewCardOnBottom(card, alreadyLaidCard);
        else {
            card.setCoordinates(alreadyLaidCard.getCoordinateX() + 1, alreadyLaidCard.getCoordinateY());
            cardBoard.get(alreadyLaidCard.getCoordinateX() + 1).set(alreadyLaidCard.getCoordinateY(), card);
        }
    }

    private void addNewRowWithNewCardOnBottom(Card card, Card alreadyLaidCard) {
        card.setCoordinates(currentBoardSizeVertical, alreadyLaidCard.getCoordinateY());
        cardBoard.add(new ArrayList<>(currentBoardSizeHorizontal));
        cardBoard.get(currentBoardSizeVertical).add(alreadyLaidCard.getCoordinateY(), card);
        currentBoardSizeVertical++;
    }

    private void putCardOnTopOfAnother(Card card, Card alreadyLaidCard) {
        if(alreadyLaidCard.getCoordinateX()==0) {
            addNewRowWithNewCardOnTop(card, alreadyLaidCard);
            shiftIndicesOfThisCardAndCardsBelow(alreadyLaidCard);
        }else {
            card.setCoordinates(alreadyLaidCard.getCoordinateX() - 1, alreadyLaidCard.getCoordinateY());
            cardBoard.get(alreadyLaidCard.getCoordinateX() - 1).set(alreadyLaidCard.getCoordinateY(), card);
        }

    }

    private void addNewRowWithNewCardOnTop(Card card, Card alreadyLaidCard) {
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

}
