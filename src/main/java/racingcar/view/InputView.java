package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String DELIMINATOR = ",";

    public static int inputInt() {
        try {
            int number = scanner.nextInt();
            validatePositiveInt(number);
            return number;
        } catch (InputMismatchException e) {
            throw new RuntimeException("숫자가 아닌 것은 입력할 수 없습니다.");
        }
    }

    private static void validatePositiveInt(int number) {
        if (number < 0) {
            throw new IllegalStateException("음수는 입력할 수 없습니다.");
        }
    }

    public static String[] inputCarNames() {
        return scanner.next().split(DELIMINATOR);
    }
}
