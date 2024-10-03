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
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void putAllCardsAndSeeIfNeighboursAssignedProperly() throws InvalidMoveException {
        var wolf1 = new WolfCard();
        var wolf2 = new WolfCard();
        var wolf3 = new WolfCard();
        var river1 = new RiverCard();
        var river2 = new RiverCard();
        var river3 = new RiverCard();
        var river4 = new RiverCard();
        var bee1 = new BeeCard();
        var elk1 = new ElkCard();
        var fox1 = new FoxCard();
        var fox2 = new FoxCard();
        var fish1 = new FishCard();
        var meadow1 = new MeadowCard();
        var meadow2 = new MeadowCard();
        var meadow3 = new MeadowCard();
        var meadow4 = new MeadowCard();
        var bear1 = new BearCard();
        var dragonfly1 = new DragonflyCard();
        var rabbit1 = new RabbitCard();
        var eagle1 = new EagleCard();

        board.putFirstCard(wolf1);
        board.putCard(elk1,1,0);
        board.putCard(fox1,1,0);
        board.putCard(river1,1,4);
        board.putCard(fox2,1,5);//board gets cut down to 5x3
        assertThrows(InvalidMoveException.class, ()->board.putCard(fox2,1,0));
        assertThrows(IndexOutOfBoundsException.class, ()->board.putCard(fox2,1,5));
        board.putCard(meadow1,2,0);
        board.putCard(meadow2,2,1);
        board.putCard(river2,2,2);
        board.putCard(river3,2,3);
        board.putCard(river4,2,4);
        board.putCard(meadow3,3,0);
        board.putCard(bee1,3,1);
        board.putCard(bear1,3,2);
        board.putCard(fish1,3,3);
        board.putCard(dragonfly1,3,4);
        board.putCard(meadow4,4,0);//board gets cut down to 5x4
        board.putCard(wolf2,3,1);
        board.putCard(wolf3,3,2);
        board.putCard(rabbit1,3,3);
        board.putCard(eagle1,3,4);

        var expectedBoard =new ArrayList<ArrayList<Card>>();
        expectedBoard.add(new ArrayList<>(Arrays.asList(fox1,elk1,wolf1,river1,fox2)));
        expectedBoard.add(new ArrayList<>(Arrays.asList(meadow1,meadow2,river2,river3,river4)));
        expectedBoard.add(new ArrayList<>(Arrays.asList(meadow3,bee1,bear1,fish1,dragonfly1)));
        expectedBoard.add(new ArrayList<>(Arrays.asList(meadow4,wolf2,wolf3,rabbit1,eagle1)));

        assertEquals(expectedBoard,board.getCardBoard());


    }
}
