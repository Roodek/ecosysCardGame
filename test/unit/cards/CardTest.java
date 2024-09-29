package unit.cards;

import game.board.Board;
import game.cards.Card;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Collections;

public class CardTest {

    Board board;
    @BeforeEach
    void initBoard(){
        this.board = new Board();

    }

    void setBoard(ArrayList<ArrayList<Card>> board){
        for(var row:board){
            this.board.getCardBoard().add(row);
        }
        this.board.setSizeVertical(board.size());
        this.board.setSizeHorizontal(board.get(0).size());
    }
}
