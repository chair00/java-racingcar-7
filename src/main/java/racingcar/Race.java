package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    List<Car> cars;
    int attempts;

    public Race(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void startRace() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
            }
            printRaceResult();
        }
        printWinners();
    }

    public void printRaceResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getCurrentLocation()));
        }
        System.out.println();
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxLocation = -1;

        for (Car car : cars) {
            if (car.getCurrentLocation() > maxLocation) {
                maxLocation = car.getCurrentLocation();
                winners.clear();
                winners.add(car);
            } else if (car.getCurrentLocation() == maxLocation) {
                winners.add(car);
            }
        }
        return winners;
    }

    public void printWinners() {
        List<Car> winners = findWinners();
        StringBuilder winnersNames = new StringBuilder("최종 우승자 : ");
        for (Car car : winners) {
            winnersNames.append(car.getName() + ", ");
        }
        String result = winnersNames.toString();

        // 마지막 ", "만 제거 (replaceAll 보다 substring이 성능이 좋음)
        if (result.endsWith(", ")) {
            result = result.substring(0, result.length() - 2);
        }
        System.out.println(result);
    }
}
