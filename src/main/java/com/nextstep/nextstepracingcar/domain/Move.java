package com.nextstep.nextstepracingcar.domain;

class Move {

    private final static byte MOVE_REFERENCE_VALUE = 4;
    private byte move = 0;

    public void plusMove(byte randomNum) {
        if (checkForwardCondition(randomNum)) {
            this.move++;
        }
    }

    private boolean checkForwardCondition(byte randomNum) {
        if (randomNum >= MOVE_REFERENCE_VALUE) {
            return true;
        }

        return false;
    }

    public byte getMove() {
        return move;
    }
}
