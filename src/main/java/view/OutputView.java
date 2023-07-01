package view;

import domain.Car;
import domain.Cars;

import java.util.StringJoiner;

public class OutputView {
    public void displayPromptCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printPlayCountRequestMsg() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void displayStartMsg() {
        System.out.println("실행 결과");
    }

    public void displayPerPlayResult(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        String repeatChar = "-";
        for (Car car : cars.getCars()) {
            stringBuilder.append(car.getCarName());
            stringBuilder.append(" : ");
            stringBuilder.append(repeatChar.repeat(car.getCarPosition()));
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public void displayResult(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Car winner : cars.getCars()) {
            stringJoiner.add(winner.getCarName());
        }
        stringBuilder.append(stringJoiner);
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }
}
