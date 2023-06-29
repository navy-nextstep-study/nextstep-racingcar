package kr.co.racingcar.view;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String DELIMINATOR = ",";
    public static final int NAME_MAX_LENGTH = 5;

    public static int inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String inputCarName() {
        System.out.printf(String.format("경주할 자동차 이름을 입력하세요(이름은 쉼표(%s)를 기준으로 구분).", DELIMINATOR));
        return SCANNER.nextLine();
    }
}
