package kr.or.bookdream.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.plaf.synth.SynthSeparatorUI;

import kr.or.bookdream.db.ConnectionPool;
import kr.or.bookdream.vo.Category1;

public class GugunDAO {
	public Vector<String> getGugunListAll(String sido){
		Vector<String> vgugun = new Vector<String>();
		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		vgugun.add("구군선택");
		try{
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select distinct gugun from zip where sido='"+sido+"' ");
			System.out.println("select distinct gugun from zip where sido='"+sido+"' ");
			while(rs.next()){
				vgugun.add( rs.getString("gugun") );
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
		
		return vgugun;
	} // end 
}
