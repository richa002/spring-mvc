/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.web;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Acer
 */
public class EmpDao {
private JdbcTemplate template;
    
public EmpDao(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	
	
	public int save(Emp emp) {

		String sql = "insert into emp(name,salary,designation) values(?,?,?)";

		try {

			int counter = template.update(sql,
					new Object[] { emp.getName(), String.valueOf(emp.getSalary()), emp.getDesignation()});

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
        
        public List<Emp> read() {
		List<Emp> list = template.query("SELECT * FROM emp", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp emp = new Emp();

				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(Integer.parseInt(rs.getString("salary")));
				emp.setDesignation(rs.getString("designation"));

				return emp;
			}

		});

		return list;
	}
        
        public List<Emp> findEmpById(int id) {
String sql="select * from emp where id=?";    
   
		//return (Emp)template.queryForObject(sql,new Object[] { id }, new BeanPropertyRowMapper(Emp.class));
		
                List<Emp> list = template.query(sql,
				new Object[] { id }, new RowMapper<Emp>() {

					@Override
					public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
						Emp emp = new Emp();

						emp.setId(rs.getInt("id"));
						emp.setName(rs.getString("name"));
						emp.setSalary(Integer.parseInt(rs.getString("salary")));
						emp.setDesignation(rs.getString("designation"));

						return emp;
					}

				});

		return list;
	}
	

   
        
        public int update(Emp emp) {
		String sql = "update  emp set name=?, salary=?, designation= ? where id=?";

		try {
//int counter=template.update(sql, emp.getName(), emp.getSalary(),
             //   emp.getDesignation(), emp.getId());
			int counter = template.update(sql,
					new Object[] { emp.getName(), String.valueOf(emp.getSalary()), emp.getDesignation(), emp.getId() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
        public int delete(int id) {
		String sql = "delete from emp where id=?";

		try {

			int counter = template.update(sql, new Object[] { id });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

    public List<Emp> getEmployeesByPage(int pageid,int total){    
    String sql="select * from emp limit "+(pageid-1)+","+total;    
    return template.query(sql,new RowMapper<Emp>(){    
        public Emp mapRow(ResultSet rs, int row) throws SQLException {    
            Emp e=new Emp();    
            e.setId(rs.getInt("id"));
						e.setName(rs.getString("name"));
						e.setSalary(Integer.parseInt(rs.getString("salary")));
						e.setDesignation(rs.getString("designation"));

            return e;    
        }    
    });    
}    
}