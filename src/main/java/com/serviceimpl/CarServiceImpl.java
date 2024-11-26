package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bo.Pagination;
import com.bo.Response;
import com.dao.CarDao;
import com.dao.ObjectDao;
import com.modal.Car;
import com.service.CarService;
import com.utils.AppConstants;
import com.utils.Utils;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private ObjectDao objectDao;

	@Autowired
	private CarDao carDao;

	@Override
	public Response addCar(Car car) throws Exception {
		try {
			car.setRegistrationNumber(Utils.generateRandomString(AppConstants.TEN));
			objectDao.saveObject(car.getRentalRate());
			car.setRentalRate(car.getRentalRate());
			objectDao.saveObject(car);

		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	@Override
	public List<Car> carList(Pagination pagination, String platform) throws Exception {
		return carDao.carList(pagination, platform);
	}

	@Override
	public Long carListCount(Pagination pagination, String platform) throws Exception {
		return carDao.carListCount(pagination, platform);
	}

}
