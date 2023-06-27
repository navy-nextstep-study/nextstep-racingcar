package com.nextstep.nextstepracingcar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private final static int NAME_LENGTH_LIMIT = 5;
    private final static int NAME_LENGTH_MIN = 0;
    private final static Pattern patternString = Pattern.compile("^[a-zA-Z]*$");

    public static void validateString(String[] inputCars) {
        for (String car : inputCars) {
            Matcher matcher = patternString.matcher(car);
            isString(matcher);
            isEmpty(inputCars);
            isLengthInRange(car);
        }
    }

    public static void validateNumber(String inputNum) {
        isNumber(inputNum);
    }

    private static void isNumber(String inputNum) {
        if (!inputNum.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("입력된 문자는 숫자가 아닙니다.");
        }
    }

    private static void isEmpty(String[] inputCars) {
        if (inputCars.length < 2) {
            throw new IllegalArgumentException("자동차 경주는 자동차의 개수가 2개 이상이어야합니다.");
        }
    }

    private static void isString(Matcher matcher) {
        if (!matcher.find()) {
            throw new IllegalArgumentException("차의 이름은 영어만 가능하며 이름은 쉼표로만 구분이 가능합니다.");
        }
    }

    private static void isLengthInRange(String carName) {
        if (carName.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5글자를 초과했습니다.");
        }

        if (carName.length() == NAME_LENGTH_MIN) {
            throw new IllegalArgumentException("자동차 이름의 길이가 0글자일 수 없습니다.");
        }
    }
}
