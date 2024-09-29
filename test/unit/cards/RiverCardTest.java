package unit.cards;

import game.cards.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RiverCardTest extends CardTest{

    Card bear1 = new BearCard();
    Card bear2 = new BearCard();
    Card bear3 = new BearCard();
    Card bear4 = new BearCard();

    Card fox1 = new FoxCard();
    Card fish1 = new FishCard();
    Card fish2 = new FishCard();
    Card bee1 = new BeeCard();
    Card bee2 = new BeeCard();
    Card rabbit1 = new RabbitCard();
    Card rabbit2 = new RabbitCard();
    Card rabbit3 = new RabbitCard();
    Card rabbit4 = new RabbitCard();

    Card river1 = new RiverCard();
    Card river2 = new RiverCard();
    Card river3 = new RiverCard();
    Card river4 = new RiverCard();
    Card river5 = new RiverCard();
    Card river6 = new RiverCard();
    Card river7 = new RiverCard();
    @Test
    void checkBuildingRiver(){
        var expectedBoard =new ArrayList<ArrayList<Card>>();
        //TODO: fill whole board with cards instead of nulls
        expectedBoard.add(new ArrayList<>(Arrays.asList(river1,river2,fish1 ,river3)));
        expectedBoard.add(new ArrayList<>(Arrays.asList(bee1  ,river4,river5,river6)));
        expectedBoard.add(new ArrayList<>(Arrays.asList(fox1  ,bear2 ,fish2 ,bee2)));
        expectedBoard.add(new ArrayList<>(Arrays.asList(bear4  ,bear1 ,bear3 ,river7)));
        expectedBoard.add(new ArrayList<>(Arrays.asList(rabbit1  ,rabbit2  ,rabbit3  ,rabbit4)));

        setBoard(expectedBoard);
        board.assignNeighbours();//although we should assign neighbours manually, tests should be unitary and limited to test given class logic :P

        //assertEquals(6,river1.)

    }
}
