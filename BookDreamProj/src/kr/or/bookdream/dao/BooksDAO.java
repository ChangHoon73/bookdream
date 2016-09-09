package kr.or.bookdream.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import kr.or.bookdream.db.ConnectionPool;
import kr.or.bookdream.vo.Books;
import kr.or.bookdream.vo.Category1;

public class BooksDAO {
	public Vector<Books> getBooksListAll(){
		Vector<Books> vbooks = new Vector<Books>();
		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from books order by registdate desc limit 0,20");
			while(rs.next()){
				vbooks.add(new Books(
						rs.getInt("no"), 
						rs.getString("title"),
						rs.getString("isbn"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getString("pdate"),
						rs.getInt("edition"),
						rs.getString("status"),
						rs.getString("link"),
						rs.getString("registdate"),
						rs.getInt("rpoint"),
						rs.getInt("members_no"),
						rs.getInt("category1_no"),
						rs.getInt("category2_no")
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
		
		return vbooks;
	}
	
	/**
	 * 책의 pk값을 받아 내용을 불러오는 함수
	 * @param booksno
	 * @return Vector<Books>
	 */
	public Vector<Books> getBooksSelectId(int booksno){
		Vector<Books> vbooks = new Vector<Books>();
		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from books where no='"+booksno+"' ");
			while(rs.next()){
				vbooks.add(new Books(
						rs.getInt("no"), 
						rs.getString("title"),
						rs.getString("isbn"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getString("pdate"),
						rs.getInt("edition"),
						rs.getString("status"),
						rs.getString("link"),
						rs.getString("registdate"),
						rs.getInt("rpoint"),
						rs.getInt("members_no"),
						rs.getInt("category1_no"),
						rs.getInt("category2_no")
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
		
		return vbooks;
	}
}
