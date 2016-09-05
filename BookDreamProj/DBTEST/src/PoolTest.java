import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PoolTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select distinct sido from zip ");
		while(rs.next()){
			System.out.println(rs.getString("sido"));
		}
		rs.close();
		stmt.close();
		pool.releaseConnection(conn);
		
		
	}

}
