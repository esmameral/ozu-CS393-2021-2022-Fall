package com.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.student.model.Student;
@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {
	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> findAll() {
		 return jdbcTemplate.query("SELECT ID, NAME FROM student",new StudentRowMapper());
	}
	
	class StudentRowMapper implements RowMapper<Student > {
	   
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
	        student.setId(rs.getInt("id"));
	        student.setName(rs.getString("name"));
			return student;
		}
}
}
