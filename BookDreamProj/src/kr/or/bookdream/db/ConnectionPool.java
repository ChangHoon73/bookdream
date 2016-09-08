package kr.or.bookdream.db;
import java.sql.*;
import java.util.*;

public class ConnectionPool {

	private static ConnectionPool cp = null;
	private ConnectionFactory cf = null;
	private Vector pool = null;
	private int initCon = 0;
	private int maxCon = 0;
	private int users = 0;

	private ConnectionPool(int initCon, int maxCon) throws SQLException, ClassNotFoundException {
		this.initCon = initCon;
		this.maxCon = maxCon;
		cf = ConnectionFactory.getDefaultFactory();
		pool = new Vector();
		for (int i = 0; i < initCon; i++) {
			pool.add(createConnection());
		}
	}

	public static synchronized ConnectionPool getInstance() throws SQLException, ClassNotFoundException {
		if (cp == null) {
			cp = new ConnectionPool(10, 20);
		}
		return cp;
	}

	public synchronized Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		while ((conn = getPooledConnection()) == null) {
			try {
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}

		users++;
		return conn;
	}

	public synchronized void releaseConnection(Connection conn) {
		pool.add(conn);
		users--;
		notifyAll();
	}

	private Connection getPooledConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		int size = pool.size();
		if (size > 0) {
			conn = (Connection) (pool.elementAt(0));
			pool.removeElementAt(0);
		} else if (users < maxCon || maxCon == 0) {
			pool.add(createConnection());
		}
		return conn;

	}

	private Connection createConnection() throws SQLException, ClassNotFoundException {
		Connection conn = cf.createConnection();
		System.out.println("== a connection was created");
		return conn;

	}

}
