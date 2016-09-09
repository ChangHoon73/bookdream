package kr.or.bookdream.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import kr.or.bookdream.db.ConnectionPool;
import kr.or.bookdream.vo.Books;
import kr.or.bookdream.vo.History;

public class HistoryDAO {
	public Vector<Books> getHistoryListAll(){
		Vector<Books> vhbooks = new Vector<Books>();
		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT books . * FROM history, books, members WHERE members.no = 1 AND books.members_no = members.no AND history.books_no = books.no");
			while(rs.next()){
				vhbooks.add(new Books(
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
		
		return vhbooks;
	}
	
	public Vector<History> getHistorySelectId(int books_no){
		Vector<History> vhistory = new Vector<History>();
		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT history . * , members.name FROM history, members WHERE history.books_no = '" + books_no + "' AND history.members_no = members.no");
			while(rs.next()){
				vhistory.add(new History(
						rs.getInt("no"), 
						rs.getString("wdate"),
						rs.getInt("members_no"),
						rs.getInt("books_no"),
						rs.getString("name")
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
		
		return vhistory;
	}
}
