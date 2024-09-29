package unit;


import game.board.Board;
import game.cards.*;
import game.exceptions.InvalidMoveException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    void putCardAtCoordinates() throws InvalidMoveException {
        var wolf = new WolfCard();
        var river = new RiverCard();
        var bee = new BeeCard();
        var elk = new ElkCard();
        var fox = new FoxCard();
        var expectedBoard = new ArrayList<ArrayList<Card>>();
        for(int i =0;i<3;i++){
            expectedBoard.add(new ArrayList<>());
            for(int j =0;j<3;j++){
                expectedBoard.get(i).add(null);
            }
        }
        expectedBoard.get(1).set(1,wolf);
        board.putFirstCard(wolf);
        assertEquals(1,board.getSizeHorizontal());
        assertEquals(1,board.getSizeVertical());

        assertEquals(expectedBoard,board.getCardBoard());
        board.putCard(river,0,1);
        assertEquals(1,board.getSizeHorizontal());
        assertEquals(2,board.getSizeVertical());

        expectedBoard.set(0, new ArrayList<>(Arrays.asList(null,river,null)));
        expectedBoard.add(0, new ArrayList<>(Arrays.asList(null,null,null)));
        assertEquals(expectedBoard,board.getCardBoard());

        board.putCard(bee,1,2);
        assertEquals(2,board.getSizeHorizontal());
        assertEquals(2,board.getSizeVertical());
        expectedBoard.forEach(row->row.add(null));
        expectedBoard.get(1).set(2,bee);

        assertEquals(expectedBoard,board.getCardBoard());

        board.putCard(elk,2,0);
        assertEquals(3,board.getSizeHorizontal());
        assertEquals(2,board.getSizeVertical());
        expectedBoard.get(2).set(0,elk);
        expectedBoard.forEach(row->row.add(0,null));

        assertEquals(expectedBoard,board.getCardBoard());

        board.putCard(fox,3,2);
        assertEquals(3,board.getSizeHorizontal());
        assertEquals(3,board.getSizeVertical());
        expectedBoard.get(3).set(2,fox);
        expectedBoard.add(new ArrayList<>(Arrays.asList(null,null,null,null,null)));

        assertEquals(expectedBoard,board.getCardBoard());
    }

    @Test
    void checkIfBoardLimitedProperlyTo4x5() throws InvalidMoveException {
        var wolf = new WolfCard();
        var river = new RiverCard();
        var bee = new BeeCard();
        var elk = new ElkCard();
        var fox = new FoxCard();

        var meadow = new MeadowCard();
        var dragonfly = new DragonflyCard();
        var fish= new FishCard();


        board.putFirstCard(wolf);
        board.putCard(river,1,0);
        board.putCard(bee,1,0);
        board.putCard(elk,1,0);
        board.putCard(fox,1,0);

        var expectedBoard =new ArrayList<ArrayList<Card>>();
        expectedBoard.add(new ArrayList<>(Arrays.asList(null,null,null,null,null)));
        expectedBoard.add(new ArrayList<>(Arrays.asList(fox,elk,bee,river,wolf)));
        expectedBoard.add(new ArrayList<>(Arrays.asList(null,null,null,null,null)));

        assertEquals(1, board.getSizeVertical());
        assertEquals(5, board.getSizeHorizontal());

        assertEquals(expectedBoard,board.getCardBoard());
        board.putCard(meadow,0,4);
        board.putCard(dragonfly,0,4);
        board.putCard(fish,0,4);

        var expectedBoard2 = new ArrayList<ArrayList<Card>>();
        expectedBoard2.add(new ArrayList<>(Arrays.asList(null,null,null,null,fish)));
        expectedBoard2.add(new ArrayList<>(Arrays.asList(null,null,null,null,dragonfly)));
        expectedBoard2.add(new ArrayList<>(Arrays.asList(null,null,null,null,meadow)));
        expectedBoard2.add(new ArrayList<>(Arrays.asList(fox,elk,bee,river,wolf)));


        assertEquals(expectedBoard2,board.getCardBoard());
    }

    @Test
    void checkIfBoardLimitedProperlyTo5x4() throws InvalidMoveException {
        var wolf = new WolfCard();
        var river = new RiverCard();
        var bee = new BeeCard();
        var elk = new ElkCard();
        var fox = new FoxCard();

        var meadow = new MeadowCard();
        var dragonfly = new DragonflyCard();
        var fish= new FishCard();

        board.putFirstCard(wolf);
        board.putCard(river,0,1);
        board.putCard(bee,0,1);
        board.putCard(elk,0,1);
        board.putCard(fox,0,1);

        var expectedBoard =new ArrayList<ArrayList<Card>>();
        expectedBoard.add(new ArrayList<>(Arrays.asList(null,fox,null)));
        expectedBoard.add(new ArrayList<>(Arrays.asList(null,elk,null)));
        expectedBoard.add(new ArrayList<>(Arrays.asList(null,bee,null)));
        expectedBoard.add(new ArrayList<>(Arrays.asList(null,river,null)));
        expectedBoard.add(new ArrayList<>(Arrays.asList(null,wolf,null)));

        assertEquals(5, board.getSizeVertical());
        assertEquals(1, board.getSizeHorizontal());


        assertEquals(expectedBoard,board.getCardBoard());
        board.putCard(meadow,0,0);
        board.putCard(dragonfly,0,0);
        board.putCard(fish,0,0);

        var expectedBoard2 = new ArrayList<ArrayList<Card>>();
        expectedBoard2.add(new ArrayList<>(Arrays.asList(fish,dragonfly,meadow,fox)));
        expectedBoard2.add(new ArrayList<>(Arrays.asList(null,null,null,elk)));
        expectedBoard2.add(new ArrayList<>(Arrays.asList(null,null,null,bee)));
        expectedBoard2.add(new ArrayList<>(Arrays.asList(null,null,null,river)));
        expectedBoard2.add(new ArrayList<>(Arrays.asList(null,null,null,wolf)));

        assertEquals(expectedBoard2,board.getCardBoard());
    }
}
