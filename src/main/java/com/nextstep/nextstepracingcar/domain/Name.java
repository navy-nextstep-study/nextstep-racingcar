package com.nextstep.nextstepracingcar.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Name {

    private final static int NAME_LENGTH_LIMIT = 5;
    private final static int NAME_LENGTH_MIN = 0;
    private final static Pattern pattern = Pattern.compile("^[a-zA-Z]*$");

    private String name;

    public Name(String name) {
        validateNameIsCharacters(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameIsCharacters(String name) {
        Matcher matcher = pattern.matcher(name);

        if (!matcher.find()) {
            throw new IllegalArgumentException("자동차 이름이 영어로 이루어져있지 않습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5글자를 초과했습니다.");
        }

        if (name.length() == NAME_LENGTH_MIN) {
            throw new IllegalArgumentException("자동차 이름의 길이가 0글자일 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
