import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    private BowlingGame g;

    @BeforeEach
    public void init(){
        this.g = new BowlingGame();
    }

    private void rollMany(int n, int pins){
        for(int i=0; i<n; i++){
            this.g.roll(pins);
        }
    }

    @Test
    public void testGutterGame(){
        this.rollMany(20, 0);
        assertEquals(0, this.g.score());
    }

    @Test
    public void testAllOnce(){
        this.rollMany(1, 20);
        assertEquals(20, g.score());
    }

    @Test
    public void testOneSpare(){
        this.rollSpare();
        this.g.roll(3);
        this.rollMany(17, 0);
        assertEquals(16, this.g.score());
    }

    @Test
    public void testOneStrike(){
        this.rollStrike();
        this.g.roll(3);
        this.g.roll(4);
        this.rollMany(16, 0);
        assertEquals(24, this.g.score());
    }

    private void rollSpare(){
        this.g.roll(5);
        this.g.roll(5);//Spare
    }

    private void rollStrike(){
        this.g.roll(10);
    }
}