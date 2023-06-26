package kr.co.racingcar.domain.car;

public class Car {
    public void validateCarNameLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 넘을 수 없습니다.");
        }
    }
}
