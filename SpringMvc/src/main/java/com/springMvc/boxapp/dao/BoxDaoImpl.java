package com.springMvc.boxapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springMvc.boxapp.model.Box;

public class BoxDaoImpl implements BoxDao {
	
	private JdbcTemplate jdbcTemplate;
	public BoxDaoImpl(){
		
	}
	public BoxDaoImpl(DataSource datasource){
		jdbcTemplate =new JdbcTemplate(datasource);
	}

	@Override
	public void addBook(Box box) {
		float a=0;
		if(box.getCountry()!=null){
		if(box.getCountry().equals("Sweden")){
			a= (float) (box.getWeight()*1.3);	
		}else if(box.getCountry().equals("China")){
			a= (float) (box.getWeight()*4);
		}
		else if(box.getCountry().equals("Australia")){
			a= (float) (box.getWeight()*7.2);
		}
		else if(box.getCountry().equals("Brazil")){
			a= (float) (box.getWeight()*8.6);
		}
		
		String sql="Insert into boxtable(name,weight,color,country,cost) values (?,?,?,?,?)";
		System.out.println("result:"+box.getName()+box.getColor());
		jdbcTemplate.update(sql,new Object[]{box.getName(),box.getWeight(),box.getColor(),box.getCountry(),a});
		}
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
				box.setCost(rs.getFloat("cost"));
				return box;
			}
			
		});
		return listBoxes;
	}


}
