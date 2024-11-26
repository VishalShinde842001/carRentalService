package com.dao;

import java.util.List;

import com.bo.Pagination;
import com.modal.Car;

public interface CarDao {

	List<Car> carList(Pagination pagination, String platform) throws Exception;

	Long carListCount(Pagination pagination, String platform) throws Exception;
}
