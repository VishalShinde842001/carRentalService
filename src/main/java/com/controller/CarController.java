package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bo.Pagination;
import com.bo.Response;
import com.modal.Car;
import com.service.CarService;
import com.utils.ErrorConstants;
import com.utils.UrlConstants;

@RestController
@CrossOrigin
@RequestMapping(UrlConstants.API_BASE_URL + "car/")
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping(UrlConstants.ADD_URL)
	public Response addCar(@RequestBody Car car) {
		Response response = new Response();
		try {
			return carService.addCar(car);
		} catch (Exception e) {
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR_MESSAGE);
		}
		return response;
	}

	@PostMapping(UrlConstants.LIST_URL)
	public Response carList(@RequestBody Pagination pagination, @RequestParam("platform") String platform) {
		Response response = new Response();
		try {

		} catch (Exception e) {
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR_MESSAGE);
		}
		return response;
	}

}
