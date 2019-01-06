package com.junitcourse.answers._03_tdd_bowloing;

public class Game {
    private int score = 0;
    private int [] rolls = new int[21];
    private int currentRole = 0;

    public void roll(int pins) {
        rolls[currentRole++] = pins;
    }

    public int getScore() {
        int firstInFrame=0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rolls[firstInFrame])){
                score += 10 + nextTwoBallsForStrike(firstInFrame);
                firstInFrame++;
            }
            else if (isSpare(firstInFrame)){
                score += 10 + addNextBallForSpare(firstInFrame, 2);
                firstInFrame+=2;
            }
            else{
                score += twoBallsInFrame(firstInFrame);
                firstInFrame+=2;
            }


        }
        return score;
    }

    private int twoBallsInFrame(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame+1];
    }

    private int addNextBallForSpare(int roll, int i) {
        return rolls[roll + i];
    }

    private boolean isSpare(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame+1] == 10;
    }

    private int nextTwoBallsForStrike(int firstInFrame) {
        return rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }
}
