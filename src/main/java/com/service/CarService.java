package com.service;

import java.util.List;

import com.bo.Pagination;
import com.bo.Response;
import com.modal.Car;

public interface CarService {

	Response addCar(Car car) throws Exception;

	List<Car> carList(Pagination pagination, String platform) throws Exception;

	Long carListCount(Pagination pagination, String platform) throws Exception;
}
