package com.nextstep.nextstepracingcar.domain;

class Car {

    Name name;
    Move move;

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