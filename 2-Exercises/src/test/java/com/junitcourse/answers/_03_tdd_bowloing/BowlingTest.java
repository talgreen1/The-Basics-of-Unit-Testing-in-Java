package com.junitcourse.answers._03_tdd_bowloing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingTest {

    private Game g;

    @Before
    public void setup(){
        g = new Game();
    }

    @Test
    public void gutterGame(){
        rollMany(20, 0);
        assertThat(g.getScore()).isEqualTo(0);
    }


    @Test
    public void allOnes(){
        rollMany(20, 1);
        assertThat(g.getScore()).isEqualTo(20);
    }

    @Test
    public void oneSpare(){
        rollSpare();
        g.roll(3);
        rollMany(17,0);

        assertThat(g.getScore()).isEqualTo(16);
    }

    @Test
    public void oneStrike(){
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(17,0);
        assertThat(g.getScore()).isEqualTo(24);


    }

    @Test
    public void perfectGame(){
        rollMany(12,10);
        assertThat(g.getScore()).isEqualTo(300);
    }

    private void rollStrike() {
        g.roll(10);
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }
}
