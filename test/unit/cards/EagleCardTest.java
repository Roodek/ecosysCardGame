package unit.cards;

import game.cards.*;
import org.junit.jupiter.api.Test;
import unit.CardTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EagleCardTest extends CardTest {

    @Test
    void testEagleCardCount(){
        Card bear4 = new BearCard();

        Card fox1 = new FoxCard();
        Card fish1 = new FishCard();
        Card fish2 = new FishCard();
        Card fish3 = new FishCard();
        Card fish4 = new FishCard();
        Card rabbit1 = new RabbitCard();
        Card rabbit2 = new RabbitCard();
        Card rabbit3 = new RabbitCard();
        Card rabbit4 = new RabbitCard();
        Card eagle1 = new EagleCard();
        Card eagle2 = new EagleCard();

        FieldCard river2 = new RiverCard();

        FieldCard river4 = new RiverCard();
        FieldCard river5 = new RiverCard();
        FieldCard river6 = new RiverCard();
        FieldCard meadow1 = new MeadowCard();
        FieldCard meadow2 = new MeadowCard();
        FieldCard meadow3 = new MeadowCard();
        FieldCard meadow5 = new MeadowCard();
        FieldCard meadow6 = new MeadowCard();

        var exampleBoard = new ArrayList<ArrayList<Card>>();
        exampleBoard.add(new ArrayList<>(Arrays.asList(eagle1,river2,fish2 ,meadow3)));
        exampleBoard.add(new ArrayList<>(Arrays.asList(meadow6  ,rabbit1,river4,river5)));
        exampleBoard.add(new ArrayList<>(Arrays.asList(fish1  ,rabbit2 ,river6 ,meadow2)));
        exampleBoard.add(new ArrayList<>(Arrays.asList(bear4  ,meadow5 ,fish4 ,meadow1)));
        exampleBoard.add(new ArrayList<>(Arrays.asList(rabbit3  ,eagle2 ,rabbit4  ,fish3)));

        setBoard(exampleBoard);
        assignNeighbours(board);

        assertEquals(6,eagle1.count());
        assertEquals(10,eagle2.count());
    }
}
