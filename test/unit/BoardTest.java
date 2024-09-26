package unit;


import game.Board;
import game.cards.*;
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
        Card dragonfly = new DragonflyCard();
        board.putCard(bear,null,null);
        board.putCard(fox,bear, Card.CardSide.TOP);
        board.putCard(dragonfly,fox, Card.CardSide.TOP);

        var expectedBoard = new ArrayList<ArrayList<Card>>();

        expectedBoard.add(new ArrayList<>());
        expectedBoard.add(new ArrayList<>());
        expectedBoard.add(new ArrayList<>());

        expectedBoard.get(0).add(dragonfly);
        expectedBoard.get(1).add(fox);
        expectedBoard.get(2).add(bear);

        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(3,board.getCurrentBoardSizeVertical());
        assertEquals(1,board.getCurrentBoardSizeHorizontal());

        assertEquals(0, dragonfly.getCoordinateX());
        assertEquals(1, fox.getCoordinateX());
        assertEquals(2, bear.getCoordinateX());
    }

    @Test
    void testAddSecondCardOnBottom(){
        Card bear = new BearCard();
        Card fox = new FoxCard();
        board.putCard(bear,null,null);
        board.putCard(fox,bear, Card.CardSide.BOTTOM);
        var expectedBoard = new ArrayList<ArrayList<Card>>();
        expectedBoard.add(new ArrayList<>());
        expectedBoard.add(new ArrayList<>());
        expectedBoard.get(0).add(bear);
        expectedBoard.get(1).add(fox);
        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(0,bear.getCoordinateX());
        assertEquals(1,fox.getCoordinateX());
        assertEquals(2,board.getCurrentBoardSizeVertical());
        assertEquals(1,board.getCurrentBoardSizeHorizontal());
    }

    @Test
    void testAddThirdCardOnBottom(){
        Card bear = new BearCard();
        Card fox = new FoxCard();
        Card dragonfly = new DragonflyCard();
        board.putCard(bear,null,null);
        board.putCard(fox,bear, Card.CardSide.BOTTOM);
        board.putCard(dragonfly,fox, Card.CardSide.BOTTOM);

        var expectedBoard = new ArrayList<ArrayList<Card>>();

        expectedBoard.add(new ArrayList<>());
        expectedBoard.add(new ArrayList<>());
        expectedBoard.add(new ArrayList<>());

        expectedBoard.get(0).add(bear);
        expectedBoard.get(1).add(fox);
        expectedBoard.get(2).add(dragonfly);

        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(3,board.getCurrentBoardSizeVertical());
        assertEquals(1,board.getCurrentBoardSizeHorizontal());

        assertEquals(0, bear.getCoordinateX());
        assertEquals(1, fox.getCoordinateX());
        assertEquals(2, dragonfly.getCoordinateX());
    }

    @Test
    void testAddThirdCardOnTopThenBottom(){
        Card bear = new BearCard();
        Card fox = new FoxCard();
        Card dragonfly = new DragonflyCard();
        board.putCard(bear,null,null);
        board.putCard(fox,bear, Card.CardSide.TOP);
        board.putCard(dragonfly,bear, Card.CardSide.BOTTOM);

        var expectedBoard = new ArrayList<ArrayList<Card>>();

        expectedBoard.add(new ArrayList<>());
        expectedBoard.add(new ArrayList<>());
        expectedBoard.add(new ArrayList<>());

        expectedBoard.get(0).add(fox);
        expectedBoard.get(1).add(bear);
        expectedBoard.get(2).add(dragonfly);

        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(3,board.getCurrentBoardSizeVertical());
        assertEquals(1,board.getCurrentBoardSizeHorizontal());

        assertEquals(0, fox.getCoordinateX());
        assertEquals(1, bear.getCoordinateX());
        assertEquals(2, dragonfly.getCoordinateX());
    }

    @Test
    void testAddThirdCardOnBottomThenTop(){
        Card bear = new BearCard();
        Card fox = new FoxCard();
        Card dragonfly = new DragonflyCard();
        board.putCard(bear,null,null);
        board.putCard(fox,bear, Card.CardSide.BOTTOM);
        board.putCard(dragonfly,bear, Card.CardSide.TOP);

        var expectedBoard = new ArrayList<ArrayList<Card>>();

        expectedBoard.add(new ArrayList<>());
        expectedBoard.add(new ArrayList<>());
        expectedBoard.add(new ArrayList<>());

        expectedBoard.get(2).add(fox);
        expectedBoard.get(1).add(bear);
        expectedBoard.get(0).add(dragonfly);

        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(3,board.getCurrentBoardSizeVertical());
        assertEquals(1,board.getCurrentBoardSizeHorizontal());

        assertEquals(2, fox.getCoordinateX());
        assertEquals(1, bear.getCoordinateX());
        assertEquals(0, dragonfly.getCoordinateX());
    }

    @Test
    void putSecondCardOnLeft(){
        Card bear = new BearCard();
        Card fox = new FoxCard();
        board.putCard(bear,null,null);
        board.putCard(fox,bear, Card.CardSide.LEFT);
        var expectedBoard = new ArrayList<ArrayList<Card>>();
        expectedBoard.add(new ArrayList<>());
        expectedBoard.get(0).add(bear);
        expectedBoard.get(0).add(0,fox);
        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(1,bear.getCoordinateY());
        assertEquals(0,fox.getCoordinateY());
        assertEquals(1,board.getCurrentBoardSizeVertical());
        assertEquals(2,board.getCurrentBoardSizeHorizontal());
    }
    @Test
    void putThirdCardOnLeft(){
        Card bear = new BearCard();
        Card fox = new FoxCard();
        Card dragonfly = new DragonflyCard();
        board.putCard(bear,null,null);
        board.putCard(fox,bear, Card.CardSide.LEFT);
        board.putCard(dragonfly,fox, Card.CardSide.LEFT);
        var expectedBoard = new ArrayList<ArrayList<Card>>();
        expectedBoard.add(new ArrayList<>());
        expectedBoard.get(0).add(bear);
        expectedBoard.get(0).add(0,fox);
        expectedBoard.get(0).add(0,dragonfly);
        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(2,bear.getCoordinateY());
        assertEquals(1,fox.getCoordinateY());
        assertEquals(0,dragonfly.getCoordinateY());
        assertEquals(1,board.getCurrentBoardSizeVertical());
        assertEquals(3,board.getCurrentBoardSizeHorizontal());
    }

    @Test
    void putSecondCardOnRight(){
        Card bear = new BearCard();
        Card fox = new FoxCard();
        board.putCard(bear,null,null);
        board.putCard(fox,bear, Card.CardSide.RIGHT);
        var expectedBoard = new ArrayList<ArrayList<Card>>();
        expectedBoard.add(new ArrayList<>());
        expectedBoard.get(0).add(bear);
        expectedBoard.get(0).add(fox);
        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(0,bear.getCoordinateY());
        assertEquals(1,fox.getCoordinateY());
        assertEquals(1,board.getCurrentBoardSizeVertical());
        assertEquals(2,board.getCurrentBoardSizeHorizontal());
    }
    @Test
    void putThirdCardOnRight(){
        Card bear = new BearCard();
        Card fox = new FoxCard();
        Card dragonfly = new DragonflyCard();
        board.putCard(bear,null,null);
        board.putCard(fox,bear, Card.CardSide.RIGHT);
        board.putCard(dragonfly,fox, Card.CardSide.RIGHT);
        var expectedBoard = new ArrayList<ArrayList<Card>>();
        expectedBoard.add(new ArrayList<>());
        expectedBoard.get(0).add(bear);
        expectedBoard.get(0).add(fox);
        expectedBoard.get(0).add(dragonfly);
        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(0,bear.getCoordinateY());
        assertEquals(1,fox.getCoordinateY());
        assertEquals(2,dragonfly.getCoordinateY());
        assertEquals(1,board.getCurrentBoardSizeVertical());
        assertEquals(3,board.getCurrentBoardSizeHorizontal());
    }

    @Test
    void putCardOnLeftThenRight(){
        Card bear = new BearCard();
        Card fox = new FoxCard();
        Card dragonfly = new DragonflyCard();
        board.putCard(bear,null,null);
        board.putCard(fox,bear, Card.CardSide.LEFT);
        board.putCard(dragonfly,bear, Card.CardSide.RIGHT);
        var expectedBoard = new ArrayList<ArrayList<Card>>();
        expectedBoard.add(new ArrayList<>());
        expectedBoard.get(0).add(bear);
        expectedBoard.get(0).add(0,fox);
        expectedBoard.get(0).add(dragonfly);
        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(1,bear.getCoordinateY());
        assertEquals(0,fox.getCoordinateY());
        assertEquals(2,dragonfly.getCoordinateY());
        assertEquals(1,board.getCurrentBoardSizeVertical());
        assertEquals(3,board.getCurrentBoardSizeHorizontal());
    }
    @Test
    void putCardOnRightThenLeft(){
        Card bear = new BearCard();
        Card fox = new FoxCard();
        Card dragonfly = new DragonflyCard();
        board.putCard(bear,null,null);
        board.putCard(fox,bear, Card.CardSide.RIGHT);
        board.putCard(dragonfly,bear, Card.CardSide.LEFT);
        var expectedBoard = new ArrayList<ArrayList<Card>>();
        expectedBoard.add(new ArrayList<>());

        expectedBoard.get(0).add(dragonfly);
        expectedBoard.get(0).add(bear);
        expectedBoard.get(0).add(fox);

        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(1,bear.getCoordinateY());
        assertEquals(2,fox.getCoordinateY());
        assertEquals(0,dragonfly.getCoordinateY());
        assertEquals(1,board.getCurrentBoardSizeVertical());
        assertEquals(3,board.getCurrentBoardSizeHorizontal());
    }

    @Test
    void createCrossFromCards(){
        var wolf = new WolfCard();
        var river = new RiverCard();
        var bee = new BeeCard();
        var elk = new ElkCard();
        var fox = new FoxCard();

        board.putCard(wolf,null,null);
        board.putCard(river,wolf, Card.CardSide.TOP);
        board.putCard(bee,wolf, Card.CardSide.BOTTOM);
        board.putCard(elk,wolf, Card.CardSide.LEFT);
        board.putCard(fox,wolf, Card.CardSide.RIGHT);

        var bottomRow = new ArrayList<Card>();
        bottomRow.add(null);
        bottomRow.add(bee);
        bottomRow.add(null);
        var middleRow = new ArrayList<Card>();
        middleRow.add(elk);
        middleRow.add(wolf);
        middleRow.add(fox);
        var topRow = new ArrayList<Card>();
        topRow.add(null);
        topRow.add(river);
        topRow.add(null);

        var expectedBoard = new ArrayList<ArrayList<Card>>();
        expectedBoard.add(topRow);
        expectedBoard.add(middleRow);
        expectedBoard.add(bottomRow);

        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(3,board.getCurrentBoardSizeVertical());
        assertEquals(3,board.getCurrentBoardSizeHorizontal());
        board.printBoard();

        var meadow = new MeadowCard();
        board.putCard(meadow,elk, Card.CardSide.LEFT);
        expectedBoard.get(0).add(0,null);
        expectedBoard.get(1).add(0,meadow);
        expectedBoard.get(2).add(0,null);

        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(3,board.getCurrentBoardSizeVertical());
        assertEquals(4,board.getCurrentBoardSizeHorizontal());

        var rabbit = new RabbitCard();
        board.putCard(rabbit,fox, Card.CardSide.BOTTOM);
        expectedBoard.get(2).set(3,rabbit);

        var dragonfly = new DragonflyCard();
        board.putCard(dragonfly,fox, Card.CardSide.TOP);
        expectedBoard.get(0).set(3,dragonfly);

        assertEquals(expectedBoard,board.getCardBoard());
        assertEquals(3,board.getCurrentBoardSizeVertical());
        assertEquals(4,board.getCurrentBoardSizeHorizontal());

    }
}
