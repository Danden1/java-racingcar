package racingcar.service;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

import java.util.List;
import java.util.Queue;

public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void addCar(String name) {
        carRepository.save(new Car(name));
    }

    public List<Car> findCars() {
        return carRepository.findAll();
    }

    public Queue<Integer> findMovementRangeOfCars() {
        return carRepository.findAllMovementRange();
    }

    public Queue<String> findNameOfCars() {
        return carRepository.findAllNames();
    }

    public Queue<String> findWinners(int maxMovementRange) {
        return carRepository.findWinnersByMaxMovementRange(maxMovementRange);
    }

    public int findMaxMovementRange() {
        return carRepository.findMaxMovementRange();
    }

    public Car findCar(String name) {
        return carRepository.findByName(name);
    }

    public void resetCarMovementRange(String Name) {
        carRepository.resetMovementRangeByName(Name);
    }

    public void resetCarsMovementRange() {
        carRepository.resetAllMovementRange();
    }

    public void moveCars() {
        carRepository.updateCarsMovementRange();
    }
}