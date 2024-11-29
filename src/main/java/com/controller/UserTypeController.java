package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bo.Response;
import com.service.UserTypeService;
import com.utils.ErrorConstants;
import com.utils.UrlConstants;

@RestController
@RequestMapping(UrlConstants.API_BASE_URL + "user-type/")
@CrossOrigin
public class UserTypeController {

	@Autowired
	private UserTypeService userTypeService;

	@GetMapping(UrlConstants.LIST_URL)
	public Response getAllUserTypes() {
		Response response = new Response();
		try {
			response.setStatus(ErrorConstants.SUCESS);
			response.setMessage(ErrorConstants.LIST_GET_SUCESSFULLY);
			response.setResult(userTypeService.getAllUserTypes());
		} catch (Exception e) {
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR_MESSAGE);
		}
		return response;
	}

}
