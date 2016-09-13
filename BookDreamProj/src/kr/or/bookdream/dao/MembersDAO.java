package kr.or.bookdream.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import kr.or.bookdream.db.ConnectionPool;
import kr.or.bookdream.util.CommonUtil;
import kr.or.bookdream.vo.Books;
import kr.or.bookdream.vo.History;
import kr.or.bookdream.vo.Members;

public class MembersDAO {
	public Vector<Members> getMembersListAll(String get_email){
		Vector<Members> vmembers = new Vector<Members>();
		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM members WHERE email = '" + get_email + "'");
			while(rs.next()){
				vmembers.add(new Members(
						rs.getInt("no"), 
						rs.getString("email"),
						rs.getString("pw"),
						rs.getString("name"),
						rs.getString("tel"),
						rs.getString("sido"),
						rs.getString("gugun"),
						rs.getString("dong"),
						rs.getString("registdate"),
						rs.getString("authdate"),
						rs.getInt("sticker")
						));
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
		
		return vmembers;
	}
	
	public Vector<Members> getMembersSelectId(int memberno){
		
		Vector<Members> vmembers = new Vector<Members>();
		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from members where no='"+memberno+"' ");
			System.out.println("select * from members where no='"+memberno+"' ");
			System.out.println("[MembersDAO][getMembersSelectId]  memberno="+memberno);
			while(rs.next()){
				vmembers.add(new Members(
						rs.getInt("no"), 
						rs.getString("email"),
						rs.getString("pw"),
						rs.getString("name"),
						rs.getString("tel"),
						rs.getString("sido"),
						rs.getString("gugun"),
						rs.getString("dong"),
						rs.getString("registdate"),
						rs.getString("authdate"),
						rs.getInt("sticker")
						));
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
		
		return vmembers;
	}

	
	
	public boolean setMembersAdd(String email,
							     String pw,
							     String name,
							     String tel,
							     String sido,
							     String gugun,
							     String dong,
							     String registdate,
							     String authdate,
							     int    sticker)
	{
		boolean add_result = false;
	
		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		CommonUtil cu = new CommonUtil();

		try{
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();

			pstmt = conn.prepareStatement("insert into members(email,pw,name,tel,sido,gugun,dong,registdate,authdate,sticker) values(?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1, email);	
			pstmt.setString(2, pw);	
			pstmt.setString(3, name );	
			pstmt.setString(4, tel );	
			pstmt.setString(5, sido );	
			pstmt.setString(6, gugun );	
			pstmt.setString(7, dong );	
			pstmt.setString(8, cu.getNowDate());	
			pstmt.setString(9,cu.getNowDate() );	
			pstmt.setInt(10, sticker );
			
			pstmt.execute();	
			add_result = true;
			System.out.println("[MembersDAO][setMembersAdd] member data INSERT "+add_result);
				
		}catch(Exception err){
			System.err.println(err.toString());
		}finally {
			if(rs != null)
				try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if(stmt != null)
				try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(pool != null) pool.releaseConnection(conn);
		}
		
		return add_result;
	}
	
	
	public boolean setMembersUpdate(int no,
									String email,
									String pw,
									String name,
									String tel,
									String sido,
									String gugun,
									String dong,
									String registdate,
									String authdate,
									int    sticker)
	{
		boolean update_result = false;

		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		CommonUtil cu = new CommonUtil();

		try{
		pool = ConnectionPool.getInstance();
		conn = pool.getConnection();

		pstmt = conn.prepareStatement("update members set email = ?,pw = ?,name = ?,tel = ?,sido = ?,gugun = ?,dong = ?,registdate = ?,authdate = ?,sticker = ? where no = " + no );

		pstmt.setString(1, email);	
		pstmt.setString(2, pw);	
		pstmt.setString(3, name );	
		pstmt.setString(4, tel );	
		pstmt.setString(5, sido );	
		pstmt.setString(6, gugun );	
		pstmt.setString(7, dong );	
		pstmt.setString(8, cu.getNowDate());	
		pstmt.setString(9, cu.getNowDate() );	
		pstmt.setInt(10, sticker );

		pstmt.execute();	
		update_result = true;
		System.out.println("[MembersDAO][setMembersUpdate] member data Update "+update_result);

		}catch(Exception err){
		System.err.println(err.toString());
		}finally {
		if(rs != null)
		try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		if(stmt != null)
		try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
		if(pool != null) pool.releaseConnection(conn);
		}

		return update_result;
	}
	
	public boolean setMembersDelete(int no)
	{
		boolean delete_result = false;

		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		CommonUtil cu = new CommonUtil();

		try{
		pool = ConnectionPool.getInstance();
		conn = pool.getConnection();

		pstmt = conn.prepareStatement("delete from members where no = " + no );

		pstmt.execute();	
		delete_result = true;

		}catch(Exception err){
		System.err.println(err.toString());
		}finally {
		if(rs != null)
		try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		if(stmt != null)
		try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
		if(pool != null) pool.releaseConnection(conn);
	}

return delete_result;
}

	
}
