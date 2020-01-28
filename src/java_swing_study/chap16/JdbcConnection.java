package java_swing_study.chap16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class JdbcConnection {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/mysql_study?useSSL=false";
		String user = "user_mysql_study";
		String password = "rootroot";
		
		selectDepartment(url, user, password); 
		
		insertDepartment(url, user, password);
		
		updateDepartment(url, user, password);
		
		deleteDepartment(url, user, password);
	}

	private static void deleteDepartment(String url, String user, String password) {
		String deleteSql = "delete from department where deptno=?";
		try(Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = con.prepareStatement(deleteSql)){
			pstmt.setInt(1, 6);
			System.out.println(pstmt);
			int res = pstmt.executeUpdate();
			System.out.println("삭제 성공" + res);
		} catch (SQLException e) {
			System.err.println("해당 데이터베이스가 존재하지 않거나 계정 및 비밀번호 확인 요망" + e.getErrorCode());
			if(e.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "해당 부서번호가 이미 존재함");
			}
		}
	}

	private static void updateDepartment(String url, String user, String password) {
		String updateSql = "update department set deptname=?, floor=? where deptno=?";
		try(Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = con.prepareStatement(updateSql)){
			pstmt.setString(1, "행정");
			pstmt.setInt(2, 11);
			pstmt.setInt(3, 6);
			System.out.println(pstmt);
			int res = pstmt.executeUpdate();
			System.out.println("수정 성공" + res);
		} catch (SQLException e) {
			System.err.println("해당 데이터베이스가 존재하지 않거나 계정 및 비밀번호 확인 요망" + e.getErrorCode());
			if(e.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "해당 부서번호가 이미 존재함");
			}
		}
	}

	private static void insertDepartment(String url, String user, String password) {
		String insertSql = "insert into department values(?,?,?)";
		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = con.prepareStatement(insertSql);){
			pstmt.setInt(1, 6);
			pstmt.setString(2, "총무");
			pstmt.setInt(3, 30);
			
			System.out.println("연결 성공" + pstmt);
			
			int res = pstmt.executeUpdate();
			System.out.println("res : " + res);
		} catch(SQLException e) {
			System.err.println("해당 데이터베이스가 존재하지 않거나 계정 및 비밀번호 확인 요망" + e.getErrorCode());
			if(e.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "해당 부서번호가 이미 존재함");
			}
			e.printStackTrace();
		}
	}

	private static void selectDepartment(String url, String user, String password) {
		String sql = "select deptno, deptname, floor from department";
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);){
			// 1. JDBC Driver Load (생략가능)
//			Class.forName("com.mysql.jdbc.Driver");			
			
			// 2. 데이터베이스 접속
			// ?useSSL=false
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_study?useSSL=false", "user_mysql_study", "rootroot");
			System.out.println("접속 성공" + con);
			
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("select deptno, deptname, floor from department");
			List<Department> deptList = new ArrayList<>();
			
			while (rs.next()) {
				deptList.add(getDepartment(rs));
			}
			
			for(Department d : deptList) {
				System.out.println(d);
			}
			
			
		} catch (SQLException e) {
			System.err.println("해당 데이터베이스가 존재하지 않거나 계정 및 비밀번호 확인 요망" + e.getErrorCode());
			e.printStackTrace();
		} finally {
			
		}
		
		
		/*
		 * catch (ClassNotFoundException e) {
		 * System.err.println("해당 드라이버를 로드할 수 없습니다."); e.printStackTrace(); }
		 */
	}

	private static Department getDepartment(ResultSet rs) throws SQLException {
		int deptNo = rs.getInt("deptno"); //컬럼명 또는 0,1... 보통은 컬럼명으로 함
		String deptName = rs.getString("deptname");
		int floor = rs.getInt("floor");
		return new Department(deptNo, deptName, floor);
	}
}
