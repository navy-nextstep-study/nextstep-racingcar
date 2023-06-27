package com.nextstep.nextstepracingcar.domain;

public class Move {

    private final static byte MOVE_REFERENCE_VALUE = 4;
    private int position = 0;

    public void plusMove(int randomNum) {
        if (checkForwardCondition(randomNum)) {
            this.position++;
        }
    }

    private boolean checkForwardCondition(int randomNum) {
        if (randomNum >= MOVE_REFERENCE_VALUE) {
            return true;
        }

        return false;
    }

    public int getPosition() {
        return position;
    }
}
