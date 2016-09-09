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
	
	public boolean setBooksAdd(
			String title, 
			String isbn, 
			String author, 
			String publisher, 
			String pdate, 
			int edition,
			String status,
			String link, 
			int rpoint, 
			int members_no, 
			int category1_no, 
			int category2_no){
		
		boolean bresult = false;
		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		CommonUtil cu = new CommonUtil();
		try{
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			pstmt = conn.prepareStatement("insert into books(title,isbn,author,publisher,pdate,edition,status, link,registdate,rpoint,members_no, category1_no, category2_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1, title );	
			pstmt.setString(2, isbn );	
			pstmt.setString(3, author );	
			pstmt.setString(4, publisher );	
			pstmt.setString(5, pdate );	
			pstmt.setInt(6, edition );	
			pstmt.setString(7, status );	
			pstmt.setString(8, link );	
			pstmt.setString(9, cu.getNowTime() );	
			pstmt.setInt(10, rpoint );	
			pstmt.setInt(11, members_no );	
			pstmt.setInt(12, category1_no );	
			pstmt.setInt(13, category2_no );	
			bresult = pstmt.execute();	
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select max(no) from books ");
			System.out.println("maxrow:"+pstmt.getMaxRows());
			{
				pstmt2 = conn.prepareStatement("insert into history(wdate,books_no, members_no) values(?,?,?)");
				pstmt2.setString(1, cu.getNowTime());
				pstmt2.setInt(2, rs.getInt(0));
				pstmt2.setInt(3, members_no);
				pstmt2.execute();
			}
		}catch(Exception err){
			System.err.println(err.toString());
		}finally {
			if(pstmt2 != null)
				try {pstmt2.close();} catch (SQLException e) {e.printStackTrace();}
			if(rs != null)
				try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if(stmt != null)
				try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(pstmt != null)
				try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(pool != null) pool.releaseConnection(conn);
		}
		
		return bresult;
	}
}
