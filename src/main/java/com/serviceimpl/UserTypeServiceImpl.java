package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ObjectDao;
import com.modal.UserType;
import com.service.UserTypeService;

@Service
public class UserTypeServiceImpl implements UserTypeService {

	@Autowired
	private ObjectDao objectDao;

	@Override
	public List<UserType> getAllUserTypes() throws Exception {
		return objectDao.getListByOneParam(UserType.class, "isActive", true);
	}

}
