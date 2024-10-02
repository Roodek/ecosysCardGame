package unit;

import game.cards.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardFinalCountTest extends CardTest {

    @Test
    void testExampleBoardFinalCount(){
        Card bear1 = new BearCard();
        Card bear2 = new BearCard();
        Card wolf1 = new WolfCard();
        Card wolf2 = new WolfCard();
        Card wolf3 = new WolfCard();
        Card bee1 = new BeeCard();
        Card bee2 = new BeeCard();
        Card bee3 = new BeeCard();
        Card fox1 = new FoxCard();
        Card fox2 = new FoxCard();
        Card fox3 = new FoxCard();
        Card fish2 = new FishCard();
        Card fish3 = new FishCard();
        Card elk1 = new ElkCard();
        Card elk2 = new ElkCard();
        Card elk3 = new ElkCard();

        Card rabbit1 = new RabbitCard();
        Card rabbit3 = new RabbitCard();
        Card rabbit4 = new RabbitCard();
        Card eagle1 = new EagleCard();
        Card eagle2 = new EagleCard();

        Card dragonfly1 = new DragonflyCard();
        Card dragonfly2 = new DragonflyCard();
        Card dragonfly3 = new DragonflyCard();

        FieldCard river1 = new RiverCard();
        FieldCard river2 = new RiverCard();
        FieldCard river3 = new RiverCard();
        FieldCard river4 = new RiverCard();
        FieldCard meadow1 = new MeadowCard();
        FieldCard meadow2 = new MeadowCard();
        FieldCard meadow3 = new MeadowCard();


//        var exampleBoard = new ArrayList<ArrayList<Card>>();
//        exampleBoard.add(new ArrayList<>(Arrays.asList(eagle1,fox2,rabbit1 ,fox3)));
//        exampleBoard.add(new ArrayList<>(Arrays.asList(dragonfly1  ,fish2,river4,wolf1)));
//        exampleBoard.add(new ArrayList<>(Arrays.asList(fox1  ,wolf1 ,river6 ,meadow2)));
//        exampleBoard.add(new ArrayList<>(Arrays.asList(bear1  ,meadow5 ,fish4 ,meadow1)));
//        exampleBoard.add(new ArrayList<>(Arrays.asList(rabbit3  ,eagle2 ,rabbit4  ,fish3)));

//        setBoard(exampleBoard);
//        board.assignNeighbours();
//
//        assertEquals(63,board.finalPointCount());

    }

//    @Test
//    void testAnotherExampleBoardFinalCount(){
//        Card bear1 = new BearCard();
//        Card bear2 = new BearCard();
//        Card wolf1 = new WolfCard();
//        Card wolf2 = new WolfCard();
//        Card wolf3 = new WolfCard();
//        Card bee1 = new BeeCard();
//        Card bee2 = new BeeCard();
//        Card bee3 = new BeeCard();
//        Card fox1 = new FoxCard();
//        Card fox2 = new FoxCard();
//        Card fox3 = new FoxCard();
//        Card fish2 = new FishCard();
//        Card fish3 = new FishCard();
//        Card elk1 = new ElkCard();
//        Card elk2 = new ElkCard();
//        Card elk3 = new ElkCard();
//
//        Card rabbit1 = new RabbitCard();
//        Card rabbit3 = new RabbitCard();
//        Card rabbit4 = new RabbitCard();
//        Card eagle1 = new EagleCard();
//        Card eagle2 = new EagleCard();
//
//        Card dragonfly1 = new DragonflyCard();
//        Card dragonfly2 = new DragonflyCard();
//        Card dragonfly3 = new DragonflyCard();
//
//        FieldCard river1 = new RiverCard();
//        FieldCard river2 = new RiverCard();
//        FieldCard river3 = new RiverCard();
//        FieldCard river4 = new RiverCard();
//        FieldCard meadow1 = new MeadowCard();
//        FieldCard meadow2 = new MeadowCard();
//        FieldCard meadow3 = new MeadowCard();
//
//
//        var exampleBoard = new ArrayList<ArrayList<Card>>();
//        exampleBoard.add(new ArrayList<>(Arrays.asList(eagle1,fox2,rabbit1 ,fox3)));
//        exampleBoard.add(new ArrayList<>(Arrays.asList(dragonfly1  ,fish2,river4,wolf1)));
//        exampleBoard.add(new ArrayList<>(Arrays.asList(fox1  ,wolf1 ,river6 ,meadow2)));
//        exampleBoard.add(new ArrayList<>(Arrays.asList(bear1  ,meadow5 ,fish4 ,meadow1)));
//        exampleBoard.add(new ArrayList<>(Arrays.asList(rabbit3  ,eagle2 ,rabbit4  ,fish3)));
//
//        setBoard(exampleBoard);
//        board.assignNeighbours();
//
//        assertEquals(63,board.finalPointCount());
//
//    }
}
