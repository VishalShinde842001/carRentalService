package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bo.Response;
import com.dao.ObjectDao;
import com.exception.CustomException;
import com.modal.User;
import com.modal.UserType;
import com.service.UserService;
import com.utils.ErrorConstants;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ObjectDao objectDao;

	@Override
	public Response addUser(User user) throws Exception {
		try {
			if (user == null || user.getMobile() == null || user.getEmail() == null || user.getPassword() == null
					|| null == user.getUserTypeId()) {
				throw new CustomException(ErrorConstants.REQUIRED_FIELD_MISSING,
						ErrorConstants.REQUIRED_FIELD_MISSING_MESSAGE);
			}

			User existingUserByMobile = objectDao.getObjectByParam(User.class, "mobile", user.getMobile());
			if (null != existingUserByMobile) {
				throw new CustomException(ErrorConstants.DUPLICATE_ENTRY,
						"The mobile number you entered is already in use. Please check and try again.");
			}

			User existingUserByEmail = objectDao.getObjectByParam(User.class, "email", user.getEmail());
			if (null != existingUserByEmail) {
				throw new CustomException(ErrorConstants.DUPLICATE_ENTRY,
						"The email you entered is already in use. Please check and try again.");
			}
			UserType userType = objectDao.getObjectById(UserType.class, user.getUserTypeId());
			user.setUserType(userType);
			objectDao.saveObject(user);

		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	@Override
	public Response login(User user) throws Exception {
		Response response = new Response();
		try {
			System.out.println("user.getMobile()========>" + user.getMobile());
			System.out.println("user.getUserTypeId(======>" + user.getUserTypeId());
			if (null == user || null == user.getMobile() || user.getPassword() == null
					|| user.getUserTypeId() == null) {
				throw new CustomException(ErrorConstants.REQUIRED_FIELD_MISSING,
						ErrorConstants.REQUIRED_FIELD_MISSING_MESSAGE);
			}
			UserType usertype = objectDao.getObjectById(UserType.class, user.getUserTypeId());
			User existingUserByMobile = objectDao.getObjectByTwoParams(User.class, "mobile", user.getMobile(),
					"userType", usertype);
			if (null == existingUserByMobile) {
				throw new CustomException(ErrorConstants.DATA_NOT_FOUND,
						"No user found with the provided mobile number. Please verify and try again.");
			} else if (null != existingUserByMobile && existingUserByMobile.getPassword() != null
					&& !user.getPassword().equalsIgnoreCase(existingUserByMobile.getPassword())) {
				throw new CustomException(ErrorConstants.INVALID_CREDENTIALS,
						ErrorConstants.INTERNAL_SERVER_ERROR_MESSAGE);
			}

			response.setStatus(ErrorConstants.SUCESS);
			response.setMessage(ErrorConstants.LOGIN_SUCESSFULLY_MESSAGE);
			existingUserByMobile.setPassword(null);
			response.setResult(existingUserByMobile);
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public Response changeActiveStatus(Long userId) throws Exception {
		Response response = new Response();
		try {
			if (null == userId || userId < 0) {
				throw new CustomException(ErrorConstants.REQUIRED_FIELD_MISSING,
						ErrorConstants.REQUIRED_FIELD_MISSING_MESSAGE);
			}
			User user = objectDao.getObjectById(User.class, userId);
			if (user == null) {
				throw new CustomException(ErrorConstants.DATA_NOT_FOUND, "User not found with the provided ID.");
			}
			user.setIsActive(user.getIsActive() != null && user.getIsActive() == true ? false : true);
			objectDao.updateObject(user);

		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
