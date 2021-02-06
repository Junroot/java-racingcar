package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void carNameTest_정상_입력() {
        assertThatCode(() -> {
            new Car("루트");
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"너무 긴 이름", ""})
    void carNameTest_잘못된_길이_입력(String input) {
        assertThatThrownBy(() -> {
            new Car(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자 이하로 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"5, 1", "2, 0", "100, 1"}, delimiter = ',')
    void tryToMoveTest(int input, int expected) {
        Car car = new Car("테스트");
        car.tryToMove(input);
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }
}
