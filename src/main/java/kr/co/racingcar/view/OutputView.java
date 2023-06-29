package kr.co.racingcar.view;

import kr.co.racingcar.domain.Car;
import kr.co.racingcar.domain.Cars;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OutputView {
    public static final int GAME_END = 0;

    public static void outputResult(Cars cars) {
        System.out.println("실행 결과");

        for (Car car : cars.getCars()) {
            System.out.print(car.getCarName() + " : ");
            int position = car.getPosition();

            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }

            System.out.println();
        }

        System.out.println();
    }

    public static void outputWinner(Cars winners) {

        for (Car winner : winners.getCars()) {
            System.out.print("[" + winner.getCarName() + "] ");
        }

        System.out.println("가 최종 우승했습니다.");
    }
}
