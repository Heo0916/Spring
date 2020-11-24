package com.myway.tok.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myway.tok.model.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setSeq(rs.getInt("seq"));
		student.setId(rs.getString("id"));
		student.setName(rs.getString("name"));
		student.setAge(rs.getInt("age"));
		
		
		return student;
	}

}
