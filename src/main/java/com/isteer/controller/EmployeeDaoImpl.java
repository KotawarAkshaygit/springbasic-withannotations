package com.isteer.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	
	
	private JdbcTemplate jdbcTemplate;
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	
	public void addemp(Employee employee) {
		
		jdbcTemplate.update("insert into employee values(?,?,?,?)",new Object[] 
				{
				 employee.getId(),employee.getName(),employee.getSalary(),employee.getDesignation() });
		
	}

	public Employee getEmployeeById(int id) {
	
		Employee employee=(Employee) jdbcTemplate.queryForObject("select * from employee where id=?",new Object[]
				{id}, new RowMapper<Employee>()
				{
					public Employee mapRow(ResultSet rs,int rowNum) throws SQLException
					{
						Employee employee=new Employee();
						employee.setId(rs.getInt(1));
						employee.setName(rs.getString(2));
						employee.setSalary(rs.getInt(3));
						employee.setDesignation(rs.getString(4));
						return employee;
					}
				}

				
	);
		return employee;
	}

}
