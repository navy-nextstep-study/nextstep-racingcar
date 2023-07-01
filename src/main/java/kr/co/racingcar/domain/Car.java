package kr.co.racingcar.domain;

import kr.co.racingcar.domain.CarSpeedStrategy;
import kr.co.racingcar.view.InputView;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        validateCarNameNull(carName);
        validateCarNameBlank(carName);
        validateCarNameLength(carName);
        this.carName = carName;
        this.position = 0;
    }

    public Car(String carName,
               int position) {
        validateCarNameNull(carName);
        validateCarNameBlank(carName);
        validateCarNameLength(carName);
        this.carName = carName;
        this.position = position;
    }

    public void move(CarSpeedStrategy speedStrategy) {
        this.position += speedStrategy.speed();
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return this.position;
    }

    private void validateCarNameLength(String input) {
        if (input.length() > InputView.NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름은 %s글자를 넘을 수 없습니다.", InputView.NAME_MAX_LENGTH));
        }
    }

    private void validateCarNameBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 빈문자열이거나 공백입니다.");
        }
    }

    private void validateCarNameNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("자동차 이름이 Null 입니다.");
        }
    }
}
