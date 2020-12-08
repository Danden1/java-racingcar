package com.woowahan.racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.woowahan.racing.constant.Message;

public class Cars {
	private final List<Car> cars;

	private Cars(List<String> carNames) {
		this.cars = new ArrayList<>();
		carNames.forEach(
			carName -> cars.add(Car.create(carName))
		);
	}

	public static Cars of(List<String> carNames) {

		return new Cars(carNames);
	}

	public List<String> getWinners() {
		int maxValue = findMaxDistance();
		return this.cars.stream()
			.filter(car -> maxValue == car.getDistance())
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public GameResult moveCars(GameRandom gameRandom) {
		for (Car car : this.cars) {
			car.move(gameRandom.isWin());
		}
		return GameResult.of(this.cars);
	}

	int findMaxDistance() {
		return this.cars
			.stream()
			.mapToInt(Car::getDistance)
			.max()
			.orElseThrow(() -> new NullPointerException(Message.MSG_NOT_FOUND_DISTANCE));
	}

	public List<Car> getCars() {
		return cars;
	}
}
