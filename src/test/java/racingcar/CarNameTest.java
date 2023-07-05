package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarNameTest {
    @Test
    void carNameTest_normal() {
        CarName carName = new CarName("pobi");
        Assertions.assertThat(carName.getCarName()).isEqualTo("pobi");
    }

    @Test
    void carNameTest_over5characters() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName("crongcrong"));
    }

    @Test
    void carNameTest_null() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName(null));
    }
}
