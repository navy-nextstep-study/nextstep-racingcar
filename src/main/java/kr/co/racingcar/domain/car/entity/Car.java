package kr.co.racingcar.domain.car.entity;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;

    private String carName;

    public Car(String carName) {
        validateCarNameNull(carName);
        validateCarNameBlank(carName);
        validateCarNameLength(carName);
        this.carName = carName;
    }

    public void validateCarNameLength(String input) {
        if (input.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름은 %s글자를 넘을 수 없습니다.", NAME_MAX_LENGTH));
        }
    }

    public void validateCarNameBlank(String input) {
        if(input.isBlank()){
            throw new IllegalArgumentException("자동차 이름이 빈문자열이거나 공백입니다.");
        }
    }

    public void validateCarNameNull(String input) {
        if(input == null){
            throw new IllegalArgumentException("자동차 이름이 Null 입니다.");
        }
    }
}
