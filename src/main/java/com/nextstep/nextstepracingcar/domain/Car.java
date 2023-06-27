package com.nextstep.nextstepracingcar.domain;

public class Car {

    private final Name name;
    private final Move move;

    public Car(Name name, Move move) {
        this.name = name;
        this.move = move;
    }

    public Name getName() {
        return name;
    }

    public Move getMove() {
        return move;
    }
}