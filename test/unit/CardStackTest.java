package unit;

import game.CardStack;
import game.cards.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardStackTest {

    //meadows x20
    //rivers x20
    //elks x12
    //bears x12
    //fox x12
    //wolf x12
    //fish x10
    //dragonflies x8
    //bees x8
    //eagles x8
    //rabbits x8
    @Test
    void testInitBoard(){
        var cards = CardStack.initCardStack();
        assertEquals(20,cards.stream().filter(card -> card.getType() == Card.CardType.MEADOW).toList().size());
        assertEquals(20,cards.stream().filter(card -> card.getType() == Card.CardType.RIVER).toList().size());
        assertEquals(12,cards.stream().filter(card -> card.getType() == Card.CardType.ELK).toList().size());
        assertEquals(12,cards.stream().filter(card -> card.getType() == Card.CardType.WOLF).toList().size());
        assertEquals(12,cards.stream().filter(card -> card.getType() == Card.CardType.BEAR).toList().size());
        assertEquals(12,cards.stream().filter(card -> card.getType() == Card.CardType.FOX).toList().size());
        assertEquals(10,cards.stream().filter(card -> card.getType() == Card.CardType.FISH).toList().size());
        assertEquals(8,cards.stream().filter(card -> card.getType() == Card.CardType.DRAGONFLY).toList().size());
        assertEquals(8,cards.stream().filter(card -> card.getType() == Card.CardType.BEE).toList().size());
        assertEquals(8,cards.stream().filter(card -> card.getType() == Card.CardType.EAGLE).toList().size());
        assertEquals(8,cards.stream().filter(card -> card.getType() == Card.CardType.RABBIT).toList().size());
        System.out.println(cards);
    }

    @Test
    void testDealCard(){
        var cards = CardStack.initCardStack();
        var card = CardStack.dealCard(cards);
        assertNotNull(card);
        assertEquals(129,cards.size());
    }
}
