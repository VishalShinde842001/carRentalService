package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bo.Pagination;
import com.dao.CarDao;
import com.modal.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Repository
public class CarDaoImpl implements CarDao {

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Car> carList(Pagination pagination, String platform) throws Exception {
		List<Car> carList = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			StringBuffer query = new StringBuffer(
					"select c.*,f.type,r.* from car c inner join fuel_type f on c.fuel_type_id=f.fuel_type_id left join rental_rate r on c.rental_rate_id=r.rental_rate_id ");
			PreparedStatement ps = con.prepareStatement(query.toString());
			ResultSet rs = ps.executeQuery();
			carList = new ArrayList<Car>();
			Car car = null;
			while (rs.next()) {
				car = new Car();
				car.setCarId(rs.getLong("car_id"));
				car.setBrand(rs.getString("brand"));
				car.setModel(rs.getString("model"));
				car.setRegistrationNumber(rs.getString("registration_number"));
				car.setLaunchDate(rs.getTimestamp("launch_date").toLocalDateTime());
				car.setMileage(rs.getDouble("mileage"));
				car.setAirBagsCount(rs.getInt("air_bags_count"));
				car.setIsActive(rs.getBoolean("status"));

				carList.add(car);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (null != con) {
				con.close();
			}
		}
		return carList;
	}

	@Override
	public Long carListCount(Pagination pagination, String platform) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
