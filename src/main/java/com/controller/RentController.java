package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bo.Response;
import com.utils.UrlConstants;

@RestController
@CrossOrigin
@RequestMapping(UrlConstants.API_BASE_URL + "rent/")
public class RentController {

	@PostMapping(UrlConstants.RENT_CAR_REQUEST)
	public Response addRentalCarRequest() {
		Response response = new Response();
		try {

		} catch (Exception e) {

		}
		return response;

	}
}
