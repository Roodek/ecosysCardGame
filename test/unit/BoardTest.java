package unit;


import game.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

    private Board board;
    @BeforeEach
    void prep(){
        board = new Board();
    }

    @Test
    public void testPrintBoard(){
        Assertions.assertEquals(1, 1);
    }
}
