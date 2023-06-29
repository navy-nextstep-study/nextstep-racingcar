package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    private static final String POSITION = "-";

    public static void outputCarNamesComment() {
        System.out.printf("경주할 자동차 이름을 입력하세요(이름은 쉼표(%s)를 기준으로 구분).%n", InputView.DELIMINATOR);
    }

    public static void outputAttemptCountComment() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void outputResultComment() {
        System.out.println("실행 결과");
    }

    public static void outputCars(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.printf("%s : ", car.getName());
            outputPositionOfCar(car.getPosition());
        }
        System.out.println();
    }

    private static void outputPositionOfCar(int position) {
        while (position-- > 0) {
            System.out.print(POSITION);
        }
        System.out.println();
    }

    public static void outputWinners(Cars cars) {
        List<Car> winners = cars.getCars();
        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.printf("%s, ", winners.get(i).getName());
        }
        System.out.printf("%s가 최종 우승했습니다.", winners.get(winners.size() - 1).getName());
    }
}
