package com.springMvc.boxapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springMvc.boxapp.model.Box;

public class BoxDaoImpl implements BoxDao {
	
	private JdbcTemplate jdbcTemplate;
	public BoxDaoImpl(DataSource datasource){
		jdbcTemplate =new JdbcTemplate(datasource);
	}

	@Override
	public void addBook(Box box) {
		String sql="Insert into boxtable(name,weight,color,country) values (?,?,?,?)";
		jdbcTemplate.update(sql,box.getName(),box.getWeight(),box.getColor(),box.getCountry());
	}

	@Override
	public List<Box> listBoxes() {
		String sql="select * from boxtable";
		List<Box> listBoxes= jdbcTemplate.query(sql, new RowMapper<Box>(){

			@Override
			public Box mapRow(ResultSet rs, int row) throws SQLException {
				Box box=new Box();
				box.setId(rs.getInt("id"));
				box.setName(rs.getString("name"));
				box.setWeight(rs.getFloat("weight"));
				box.setColor(rs.getString("color"));
				box.setCountry(rs.getString("country"));
				return box;
			}
			
		});
		return listBoxes;
	}

	@Override
	public void deleteBox(int id) {
		String sql="delete from boxtable where id=?";
		jdbcTemplate.update(sql, id);
	}

}
