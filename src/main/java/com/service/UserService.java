package com.service;

import com.bo.Response;
import com.modal.User;

public interface UserService {

	Response addUser(User user) throws Exception;

	Response login(User user) throws Exception;

	Response changeActiveStatus(Long userId) throws Exception;

}
