package unit;

import game.Move;
import game.board.Board;
import game.board.BoardAvailableMoveCalculator;
import game.cards.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BoardAvailableMoveCalculatorTest {
    private Board board;
    private Card wolf = new WolfCard();
    private Card river = new RiverCard();
    private Card bee = new BeeCard();
    private Card elk = new ElkCard();
    private Card fox = new FoxCard();
    private Card meadow = new MeadowCard();
    private Card dragonfly = new DragonflyCard();
    private Card fish= new FishCard();
    private Card rabbit= new RabbitCard();
    private Card eagle= new EagleCard();
    private Card bear= new BearCard();

    private BoardAvailableMoveCalculator calculator;
    @BeforeEach
    void prep(){
        board = mock(Board.class);
        calculator = new BoardAvailableMoveCalculator(board);

    }

    @AfterEach
    void finalizeWith(){
        board.printBoard();
        System.out.println();
    }

    @Test
    void checkAvailableSlotsInBoard2x2(){
        var exampleBoard = new ArrayList<ArrayList<Card>>();
        exampleBoard.add(new ArrayList<>(Arrays.asList(null,null,null,null,null)));
        exampleBoard.add(new ArrayList<>(Arrays.asList(null,null,eagle,fish,null)));
        exampleBoard.add(new ArrayList<>(Arrays.asList(null,wolf,bee,null,null)));
        exampleBoard.add(new ArrayList<>(Arrays.asList(null,null,null,null,null)));

        when(board.getCardBoard()).thenReturn(exampleBoard);
        when(board.getMaxHorizontalSize()).thenReturn(5);
        when(board.getMaxVerticalSize()).thenReturn(5);


        var expectedAvailableMoves = Set.of(
                new Move(0,2),
                new Move(0,3),
                new Move(1,1),
                new Move(1,4),
                new Move(2,0),
                new Move(2,3),
                new Move(3,1),
                new Move(3,2)
                );

        assertEquals(expectedAvailableMoves,calculator.getAvailableMoves());
    }

    @Test
    void checkAvailableSlotsInBoard5x3(){
        var exampleBoard = new ArrayList<ArrayList<Card>>();
        exampleBoard.add(new ArrayList<>(Arrays.asList(null,null,elk,null,null)));
        exampleBoard.add(new ArrayList<>(Arrays.asList(null,null,eagle,fish,null)));
        exampleBoard.add(new ArrayList<>(Arrays.asList(null,wolf,bee,null,null)));
        exampleBoard.add(new ArrayList<>(Arrays.asList(null,null,rabbit,null,null)));
        exampleBoard.add(new ArrayList<>(Arrays.asList(null,null,dragonfly,null,null)));


        when(board.getCardBoard()).thenReturn(exampleBoard);
        when(board.getMaxHorizontalSize()).thenReturn(4);
        when(board.getMaxVerticalSize()).thenReturn(5);

        var expectedAvailableMoves = Set.of(
                new Move(0,1),
                new Move(0,3),
                new Move(1,1),
                new Move(1,4),
                new Move(2,0),
                new Move(2,3),
                new Move(3,1),
                new Move(3,3),
                new Move(4,1),
                new Move(4,3)
        );

        var availableMoves = calculator.getAvailableMoves();
        assertEquals(expectedAvailableMoves.size(),availableMoves.size());
        assertEquals(expectedAvailableMoves,availableMoves);
    }
}
