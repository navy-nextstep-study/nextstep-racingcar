package kr.co.racingcar.domain.car;

public class Car {
    public void validateCarNameLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 넘을 수 없습니다.");
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
