package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bo.Response;
import com.exception.CustomException;
import com.modal.User;
import com.service.UserService;
import com.utils.ErrorConstants;
import com.utils.UrlConstants;

@RestController
@CrossOrigin
@RequestMapping(UrlConstants.API_BASE_URL + "user/")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(UrlConstants.ADD_URL)
	private Response addUser(User user) {
		Response response = new Response();
		try {
			return userService.addUser(user);
		} catch (CustomException ce) {
			response.setStatus(ce.getErrorCode());
			response.setMessage(ce.getMessage());
		} catch (Exception e) {
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR_MESSAGE);
		}
		return response;
	}

	@PostMapping(UrlConstants.LOGIN_URL)
	private Response login(User user) {
		Response response = new Response();
		try {
			return userService.login(user);
		} catch (CustomException ce) {
			response.setStatus(ce.getErrorCode());
			response.setMessage(ce.getMessage());
		} catch (Exception e) {
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR_MESSAGE);

		}
		return response;

	}

	@GetMapping(UrlConstants.CHANGE_ACTIVE_STATUS + "/{userId}")
	private Response changeActiveStatus(@PathVariable("userId") Long userId) {
		Response response = new Response();
		try {
			return userService.changeActiveStatus(userId);
		} catch (Exception e) {
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR_MESSAGE);

		}
		return response;

	}

}
