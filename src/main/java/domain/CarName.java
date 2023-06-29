package domain;

public class CarName {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR_MSG = "자동차의 이름은 " + MAXIMUM_NAME_LENGTH + "자 이내여야 합니다.";
    private final String name;
    public CarName(String name) {
        validNameLength(name);
        this.name = name;
    }

    public void validNameLength(String name) {
        if(name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MSG);
        }
    }

    public String getName() {
        return name;
    }
}
