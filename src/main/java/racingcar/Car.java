package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final static int MOVE = 1;
    private final static int MOVE_THRESHOLD = 4;

    private String name;
    private int currentLocation;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void move() {
        int randomNumber = pickNumberInRange(0, 9);
        if (randomNumber >= MOVE_THRESHOLD) {
            currentLocation += MOVE;
        }
    }
}
