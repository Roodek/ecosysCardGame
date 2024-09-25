package game;

import game.cards.Card;

import java.util.ArrayList;

public class Board {

    private static final int BOARD_LIMIT_5 = 5;
    private static final int BOARD_LIMIT_4 = 4;
    private int currentBoardSizeVertical = 0;
    private int currentBoardSizeHorizontal = 0;
    private ArrayList<Card> cards;
    private ArrayList<ArrayList<Card>> cardBoard;


    public void putCard(Card card, int coordX, int coordY){
        verifyAvailableCoords(coordX,coordY);
        cards.add(card);
    }

    private void verifyAvailableCoords(int coordX, int coordY) {
        if(cards.isEmpty())
            return;
    }


    private void printBoard(){
        for(Card card:cards){
            System.out.print(card.getType());
        }
    }

    private Integer countFinalPoints(){
        return cards.stream().map(Card::count).reduce(0, Integer::sum);
    }


}
