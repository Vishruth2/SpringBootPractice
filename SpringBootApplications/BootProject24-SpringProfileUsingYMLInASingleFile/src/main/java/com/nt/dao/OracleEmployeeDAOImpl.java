package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("ora_empDAO")
@Profile({"prod"})
public class OracleEmployeeDAOImpl implements IEmployeeDAO {
	//create the query
			private static final  String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN (?,?,?) ORDER BY JOB";
			
			@Autowired
			private DataSource ds;
			
			public OracleEmployeeDAOImpl() {
				System.out.println("OracleEmployeeDAOImpl.OracleEmployeeDAOImpl()::");
			}
			
	@Override
	public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("EmployeeDAOImpl.getEmployeeByDesgs() :: ds class name ::"+ds.getClass());
		
		List<Employee> list = null;
		//get pooled jdbc con object
		try(Connection con = ds.getConnection();
				//create a prepared statement
			 	PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS)
			)
		{
			//set values to the query parameters
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			//execute query
			try(ResultSet rs = ps.executeQuery()){
				//copy the records of resultSet object to List<Employee> object
				list = new ArrayList<>();
				while (rs.next()) {
					//copy each record of RS to employee object
					Employee emp = new Employee();
					emp.setEno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));
					
					//add employee object to list object
					list.add(emp);
				}//while
				
			}//try2 with resource
			
			catch (Exception e) {
				e.printStackTrace();
				throw e; //exception propagation
			}
			
		}//try1 with resource
		
		catch (SQLException se) {
			se.printStackTrace();
			throw se; //exception propagation
		}
		
		
		return list;
	}//method

}
