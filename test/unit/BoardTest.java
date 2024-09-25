package unit;


import game.Board;
import game.cards.BearCard;
import game.cards.Card;
import game.cards.FoxCard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    private Board board;
    @BeforeEach
    void prep(){
        board = new Board();
    }

    @AfterEach
    void finalizeWith(){
        board.printBoard();
        System.out.println();
    }

    @Test
    void testAddFirstCard(){
        Card bear = new BearCard();
        board.putCard(bear,null,null);
        var expectedBoard = new ArrayList<ArrayList<Card>>();
        expectedBoard.add(new ArrayList<>());
        expectedBoard.get(0).add(bear);
        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(1,board.getCurrentBoardSizeVertical());
        assertEquals(1,board.getCurrentBoardSizeHorizontal());
    }

    @Test
    void testAddSecondCardOnTop(){
        Card bear = new BearCard();
        Card fox = new FoxCard();
        board.putCard(bear,null,null);
        board.putCard(fox,bear, Card.CardSide.TOP);
        var expectedBoard = new ArrayList<ArrayList<Card>>();
        expectedBoard.add(new ArrayList<>());
        expectedBoard.add(new ArrayList<>());
        expectedBoard.get(0).add(fox);
        expectedBoard.get(1).add(bear);
        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(2,board.getCurrentBoardSizeVertical());
        assertEquals(1,board.getCurrentBoardSizeHorizontal());
    }

    @Test
    void testAddThirdCardOnTop(){
        Card bear = new BearCard();
        Card fox = new FoxCard();
        Card bear2 = new BearCard();
        board.putCard(bear,null,null);
        board.putCard(fox,bear, Card.CardSide.TOP);
        board.putCard(bear2,fox, Card.CardSide.TOP);

        var expectedBoard = new ArrayList<ArrayList<Card>>();

        expectedBoard.add(new ArrayList<>());
        expectedBoard.add(new ArrayList<>());
        expectedBoard.add(new ArrayList<>());

        expectedBoard.get(0).add(bear2);
        expectedBoard.get(1).add(fox);
        expectedBoard.get(2).add(bear);

        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(3,board.getCurrentBoardSizeVertical());
        assertEquals(1,board.getCurrentBoardSizeHorizontal());

        assertEquals(0, bear2.getCoordinateX());
        assertEquals(1, fox.getCoordinateX());
        assertEquals(2, bear.getCoordinateX());
    }
}
