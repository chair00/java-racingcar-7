package racingcar;

import java.util.*;

public class InputParser {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    // 자동차 이름 입력받고, 각 자동차 클래스에 저장하기.
    public List<Car> createCars(String input) {
        List<Car> cars = new ArrayList<>();

        List<String> carNames = Arrays.asList(input.split(","));
        checkDuplicated(carNames);

        for (String carName : carNames) {
            checkCarName(carName);
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }

    public boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    public boolean isCarNameValidLength(String carName) {
        return carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    public void checkCarName(String carName) {
        if (isBlank(carName)) {
            throw new IllegalArgumentException("자동차 이름이 비어있습니다.");
        }
        if (!isCarNameValidLength(carName)) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_CAR_NAME_LENGTH + "자 이하만 가능합니다.");
        }
    }

    public void checkDuplicated(List<String> carNames) {
        Set<String> carNameDistinct = new HashSet<>(carNames);

        if (carNames.size() != carNameDistinct.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public int getValidAttempts(String input) {
        // 양수인지 확인
        checkValidNumber(input);
        return Integer.parseInt(input);
    }

    public boolean isVaildNumber(String str) {
        return str.matches("\\d+");
    }

    public void checkValidNumber(String str) {
        if(!isVaildNumber(str)) {
            throw new IllegalArgumentException("횟수 입력이 올바르지 않습니다. 양수 입력만 허용합니다.");
        }
    }

}
