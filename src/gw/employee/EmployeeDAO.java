package gw.employee;

import gw.util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<Employee> employeelist = new ArrayList<Employee>();
	
	public void register(Employee employee) {
		conn = DBConn.connect();
		try {
			
			String query = "INSERT INTO employee (id, pw, name, rank, depname, tel, phone, joinDate) VALUES (?, ?, ?, ?, ?, ?, ?, NOW())";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getPw());
			pstmt.setString(3, employee.getName());
			pstmt.setString(4, employee.getRank());
			pstmt.setString(5, employee.getDepname());
			pstmt.setString(6, employee.getTel());
			pstmt.setString(7, employee.getPhone());
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		finally {
			try {
				conn.close();
			}
			catch (SQLException e) {
				System.out.println("close");
				e.printStackTrace();
			}
		}
	}
	
	//DB에서 리스트로 사원 정보 땡겨옴
	public void setEmployeeList() {
		Employee employee = new Employee();
		conn = DBConn.connect();
		try {
			String query = "SELECT * FROM employee";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			
			while(rs.next()) {
				employee.setId(rs.getInt("id"));
				employee.setPw(rs.getString("pw"));
				employee.setName(rs.getString("name"));
				employee.setRank(rs.getString("rank"));
				employee.setDepname(rs.getString("depname"));
				employee.setTel(rs.getString("tel"));
				employee.setPhone(rs.getString("phone"));
				addList(employee);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		finally {
			try {
				conn.close();
			}
			catch (SQLException e) {
				System.out.println("close");
				e.printStackTrace();
			}
		}
	}
	public void addList(Employee e) {
		employeelist.add(e);
	}
	
	public List<Employee> getEmployeeList() {
		return employeelist;
	}
}
