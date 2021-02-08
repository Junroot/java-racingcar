package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.utils.WinnerUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerUtilsTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("루트"));
        cars.add(new Car("소롱"));
    }

    @Test
    @DisplayName("우승자가 한명인 경우")
    void findWinnersTest_한명() {
        cars.get(0).tryToMove(5);
        cars.get(1).tryToMove(3);

        List<String> expected = new ArrayList<>();
        expected.add(cars.get(0).getName());

        List<String> actual = WinnerUtils.findWinners(cars);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("우승자가 두명인 경우")
    void findWinnersTest_두명_이상() {
        cars.add(new Car("포비"));

        List<String> expected = new ArrayList<>();
        for (Car car : cars) {
            car.tryToMove(5);
            expected.add(car.getName());
        }

        List<String> actual = WinnerUtils.findWinners(cars);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("모두 움직이지 않은 경우")
    void findWinnerTest_모두_움직이지_않음() {
        List<String> expected = new ArrayList<>();
        for (Car car : cars) {
            expected.add(car.getName());
        }

        List<String> actual = WinnerUtils.findWinners(cars);
        assertThat(actual).isEqualTo(expected);
    }
}
