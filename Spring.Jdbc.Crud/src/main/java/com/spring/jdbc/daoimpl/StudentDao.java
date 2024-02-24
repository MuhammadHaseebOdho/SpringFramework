package com.spring.jdbc.daoimpl;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.model.Student;

public class StudentDao {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Student addStudent(Student student) {
		String addQuery = "INSERT INTO students(NAME,rollnum,age,department) VALUES('" + student.getName() + "','"
				+ student.getRollNumber() + "','" + student.getAge() + "','" + student.getDepartment() + "')";
		jdbcTemplate.update(addQuery);
		return student;
	}

	
	  public Student getStudentById(Integer id) {
	  
	  String getQuery="select * from students where id='"+id+"'";
	  RowMapper<Student> rowMapper=new RowMapperImpl();
	  return jdbcTemplate.queryForObject(getQuery,rowMapper);  
	  }
	  
	  public List<Student> getAllStudents(){
		  String getAllQuery="Select * from students";
		  return jdbcTemplate.query(getAllQuery,new RowMapperImpl());
	  }
	 

	public Student updateStudent(Student student,Integer id) {
		String updateQuery = "update students set name='" + student.getName() + "',rollnum='" + student.getRollNumber()
				+ "',age='" + student.getAge() + "',department='" + student.getDepartment() + "' where id='"+id+"'";
		jdbcTemplate.update(updateQuery);
		return student;
	}
	
	public void deleteStudent(Integer id) {
		String deleteQuery="delete from students where id='" + id+ "'";
		jdbcTemplate.update(deleteQuery);
	}

}
