package kr.or.bookdream.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import kr.or.bookdream.db.ConnectionPool;
import kr.or.bookdream.vo.Category1;
import kr.or.bookdream.vo.Logins;

public class LoginDAO {
	/**
	 * 사용자 로그인 체크 함수
	 */
	public boolean loginUser(String userid, String userpw){
		boolean bloginSuccess = false;
		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select email from members where email='"+userid+"' and pw='"+userpw+"' ");
			while(rs.next()){
				bloginSuccess = true;
			}
			
		}catch(Exception err){
			System.err.println(err.toString());
		}finally {
			if(rs != null)
				try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if(stmt != null)
				try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(pool != null) pool.releaseConnection(conn);
		}
		
		return bloginSuccess;
	}

	public Vector<Logins> getLoginInfo(String email, boolean bLogin) {
		Vector<Logins>  vc = new Vector<Logins>();
		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select no, email, name from members where email='"+email+"' ");
			while(rs.next()){
				vc.add(new Logins(rs.getInt("no"), rs.getString("email"), rs.getString("name"), bLogin));
			}
			
		}catch(Exception err){
			System.err.println(err.toString());
		}finally {
			if(rs != null)
				try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if(stmt != null)
				try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(pool != null) pool.releaseConnection(conn);
		}
		
		return vc;
		
	}
}
