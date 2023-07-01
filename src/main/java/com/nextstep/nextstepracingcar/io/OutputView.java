package com.nextstep.nextstepracingcar.io;


import com.nextstep.nextstepracingcar.domain.Car;
import com.nextstep.nextstepracingcar.domain.Cars;
import java.util.List;

public final class OutputView {

    private OutputView() {
    }

    public static void gameGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분합니다).");
    }

    public static void tryNumberGuide() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void gameResultGuide(List<Car> cars) {
        System.out.println("\n실행 결과");

        for (Car car : cars) {
            System.out.println(car.getName().getName() + " : " + "-".repeat(car.getMove().getPosition()));
        }
    }

    public static void gameWinnerGuide(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars.getCars()) {
            stringBuilder.append(car.getName().getName());
            stringBuilder.append(" ");
        }

        stringBuilder.append("가 최종 우승했습니다.");

        System.out.println(stringBuilder);
    }
}
