package com.nextstep.nextstepracingcar.domain;

public class Car {

    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public Position getPostion() {
        return position;
    }
}
