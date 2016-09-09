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
	
	public boolean setBooksAdd(Vector<Books> vbooks, int membersno){
		membersno = 1;
		boolean bresult = false;
		ConnectionPool pool = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		CommonUtil cu = new CommonUtil();
		try{
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			pstmt = conn.prepareStatement("insert into books(title,isbn,author,publisher,pdate,edition,status, link,registdate,rpoint,members_no, category1_no, category2_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1, vbooks.get(0).getTitle() );	
			pstmt.setString(2, vbooks.get(0).getIsbn() );	
			pstmt.setString(3, vbooks.get(0).getAuthor() );	
			pstmt.setString(4, vbooks.get(0).getPublisher() );	
			pstmt.setString(5, vbooks.get(0).getPdate() );	
			pstmt.setInt(6, vbooks.get(0).getEdition() );	
			pstmt.setString(7, vbooks.get(0).getStatus() );	
			pstmt.setString(8, vbooks.get(0).getLink() );	
			pstmt.setString(9, cu.getNowTime() );	
			pstmt.setInt(10, vbooks.get(0).getRpoint() );	
			pstmt.setInt(11, membersno );	
			pstmt.setInt(12, vbooks.get(0).getCategory1_no() );	
			pstmt.setInt(13, vbooks.get(0).getCategory2_no() );	
			bresult = pstmt.execute();	
			
			if(bresult){
				pstmt2.getConnection().prepareStatement("insert into history(wdate,books_no, members_no) values(?,?,?)");
				pstmt2.setString(1, cu.getNowTime());
				pstmt2.setInt(2, vbooks.get(0).getNo());
				pstmt2.setInt(1, membersno);
				pstmt2.execute();
			}
		}catch(Exception err){
			System.err.println(err.toString());
		}finally {
			if(pstmt2 != null)
				try {pstmt2.close();} catch (SQLException e) {e.printStackTrace();}
			if(pstmt != null)
				try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(pool != null) pool.releaseConnection(conn);
		}
		
		return bresult;
	}
}
