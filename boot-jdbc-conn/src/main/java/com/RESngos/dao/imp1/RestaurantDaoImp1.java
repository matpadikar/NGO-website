package com.RESngos.dao.imp1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.RESngos.dao.RestaurantDao;
import com.RESngos.model.Restaurant;

@Repository
public class RestaurantDaoImp1 extends JdbcDaoSupport implements RestaurantDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	//@Override
	public void insertRestaurant(Restaurant res) {
		String sql = "INSERT INTO Restaurant " +
				"(resId, resName, resAddress, resEmail, resOwner, resMob) VALUES (?, ?, ?, ?, ?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				res.getResId(), res.getResName()
		});
	}
	
	//@Override
	public void insertRestaurants(final List<Restaurant> restaurants) {
		String sql = "INSERT INTO Restaurant " + "(resId, resName, resAddress, resEmail, resOwner, resMob) VALUES (?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Restaurant restaurant = restaurants.get(i);
				ps.setString(1, restaurant.getResId());
				ps.setString(2, restaurant.getResName());
			}
			
			public int getBatchSize() {
				return restaurants.size();
			}
		});

	}
	//@Override
	public List<Restaurant> getAllRestaurants(){
		String sql = "SELECT * FROM restaurant";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Restaurant> result = new ArrayList<Restaurant>();
		for(Map<String, Object> row:rows){
			Restaurant emp = new Restaurant();
			emp.setResId((String)row.get("resId"));
			emp.setResName((String)row.get("resName"));
			emp.setResAddress((String)row.get("resAddress"));
			emp.setResEmail((String)row.get("resEmail"));
			emp.setResOwner((String)row.get("resOwner"));
			emp.setResMob((String)row.get("resMob"));
			result.add(emp);
		}
		
		return result;
	}

	//@Override
	public Restaurant getRestaurantById(String resId) {
		String sql = "SELECT * FROM restaurant WHERE resId = ?";
		return (Restaurant)getJdbcTemplate().queryForObject(sql, new Object[]{resId}, new RowMapper<Restaurant>(){
			//@Override
			public Restaurant mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Restaurant res = new Restaurant();
				res.setResId(rs.getString("resId"));
				res.setResName(rs.getString("resName"));
				return res;
			}
		});
	}
}
