package com.drpicox.bowlingKata;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {
    private Game g;

    @Before
    public void setUp() throws Exception{
        g = new Game();
    }

    private void rollMany(int n, int pins) {
        for (int i=0; i<n; i++){
            g.roll(pins);
        }
    }

    @Test
    public void gutterGame() throws Exception{
       rollMany(20, 0);
       assertThat(g.score(), is(0));
    }

    @Test
    public void testAllOnes() throws Exception{
        rollMany(20, 1);
        assertThat(g.score(), is(20));
    }
    @Test
    public void testOneSpare() throws Exception{
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16,0);
        assertThat(g.score(), is(24));
    }

    private void rollStrike(){
        g.roll(10);
    }
    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }
}
