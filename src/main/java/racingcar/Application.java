package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();

        InputParser inputParser = new InputParser();
        List<Car> cars = inputParser.createCars(input);

        System.out.println("시도할 횟수는 몇 회인가요?");
        input = readLine();
        int attempts = inputParser.getValidAttempts(input);

        Race race = new Race(cars, attempts);

        race.startRace();
    }
}

