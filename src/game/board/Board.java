package game.board;

import game.cards.Card;

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    public static final int CARD_NAME_LENGTH = 11;
    private int sizeVertical = 0;
    private int sizeHorizontal = 0;

    public int getMaxVerticalSize() {
        return maxVerticalSize;
    }

    public int getMaxHorizontalSize() {
        return maxHorizontalSize;
    }

    private int maxVerticalSize = 5;
    private int maxHorizontalSize = 5;
    private ArrayList<ArrayList<Card>> cardBoard = new ArrayList<>();

    public int getSizeVertical() {
        return sizeVertical;
    }

    public int getSizeHorizontal() {
        return sizeHorizontal;
    }

    public void printBoard() {
        for (var row : cardBoard) {
            for (var card : row) {
                if (card != null) {
                    var padding = CARD_NAME_LENGTH - (card.getType().toString().length() + 2);
                    System.out.printf("%s%d%d%s", card.getType().toString(), card.getCoordinateX(), card.getCoordinateY(), " ".repeat(Math.max(0, padding)));
                } else {
                    System.out.printf("[        ]%s", " ".repeat(Math.max(0, CARD_NAME_LENGTH - 10)));
                }
            }
            System.out.println();
        }

    }

    public ArrayList<ArrayList<Card>> getCardBoard() {
        return cardBoard;
    }

    public void putFirstCard(Card card) {
        putCard(card, 0, 0);
    }

    public void putCard(Card card, int coordX, int coordY) {
        if (cardBoard.isEmpty()) {
            initBoard();
            cardBoard.get(1).set(1, card);
            sizeVertical++;
            sizeHorizontal++;
        } else {
            cardBoard.get(coordX).set(coordY, card);
            if (coordX == 0 && sizeVertical < 5) {
                addNewFirstRow();
                sizeVertical++;
                checkIfMaxVerticalAndCutBoardTo5x4();
            } else if (coordX == sizeVertical + 1 && sizeVertical < 5) {
                addNewLastRow();
                sizeVertical++;
                checkIfMaxVerticalAndCutBoardTo5x4();
            } else if (coordY == 0 && sizeHorizontal < 5) {
                addNewFirstColumn();
                sizeHorizontal++;
                checkIfMaxHorizontalAndCutBoardTo4x5();
            } else if (coordY == sizeHorizontal + 1 && sizeHorizontal < 5) {
                addNewLastColumn();
                sizeHorizontal++;
                checkIfMaxHorizontalAndCutBoardTo4x5();
            }
        }
    }

    private void checkIfMaxVerticalAndCutBoardTo5x4() {
        if(sizeVertical==maxVerticalSize) {
            cardBoard = new ArrayList<>(cardBoard.subList(1, maxVerticalSize+1));
            maxHorizontalSize = 4;
        }
    }
    private void checkIfMaxHorizontalAndCutBoardTo4x5() {
        if(sizeHorizontal== maxHorizontalSize) {
            for (int i=0;i<cardBoard.size();i++){
                cardBoard.set(i,new ArrayList<>(cardBoard.get(i).subList(1, maxHorizontalSize + 1)));
            }
           // cardBoard.forEach(row -> row.subList(1, maxHorizontallSize + 1));
            maxVerticalSize = 4;
        }
    }

    private void addNewLastColumn() {
        cardBoard.forEach(row -> row.add(null));
    }

    private void addNewFirstColumn() {
        cardBoard.forEach(row -> row.add(0, null));
    }

    private void addNewLastRow() {
        cardBoard.add(new ArrayList<>(Collections.nCopies(cardBoard.get(0).size(), null)));
    }

    private void addNewFirstRow() {
        cardBoard.add(0, new ArrayList<>(Collections.nCopies(cardBoard.get(0).size(), null)));
    }

    private void initBoard() {
        for (int i = 0; i < 3; i++) {
            cardBoard.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                cardBoard.get(i).add(null);
            }
        }
    }


}
