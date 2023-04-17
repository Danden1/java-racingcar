package study.racingcar.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.Car;

public class CarFactoryTest {

  @DisplayName("이름배열 순서에 맞게 이름을 갖는 자동차를 생성한다.")
  @Test
  public void create_cars_nameOfCars() {
    String[] names = new String[]{"a", "b", "c"};

    List<Car> cars = CarFactory.createCars(names);

    assertThat(cars.size()).isEqualTo(names.length);
    for (int i = 0; i < names.length; i++) {
      assertThat(cars.get(i).getName()).isEqualTo(names[i]);
    }
  }
}
