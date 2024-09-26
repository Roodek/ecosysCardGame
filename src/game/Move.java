package game;

import game.cards.Card;

import java.util.List;

public record Move(
        Card card,
        List<Card.CardSide> availableSides
){}
