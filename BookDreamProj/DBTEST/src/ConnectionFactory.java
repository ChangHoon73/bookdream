import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {

   private static int maxconn = 0;
   private static String url = null;
   private static String driver = null;
   private static String user = null;
   private static String password = null;
   private static ConnectionFactory connFactory = new ConnectionFactory();
   
   static {
	   try {
		loadProperities("jdbc.properties");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   private ConnectionFactory(){};
   
   public static ConnectionFactory getDefaultFactory(){
	   if(connFactory == null){
		   connFactory = new ConnectionFactory();
	   }
	   return connFactory;
   }
   
   public Connection createConnection() throws ClassNotFoundException, SQLException{
	   Class.forName(driver);
	   Connection conn = DriverManager.getConnection(url, user, password);
	   return conn;
   }
   
   public static void loadProperities(String filename) throws IOException{
	   Properties p = new Properties();
	   FileInputStream fis = new FileInputStream(filename);
	   p.load(fis);
	   fis.close();
	   url = p.getProperty("url");
	   driver = p.getProperty("driver");
	   user = p.getProperty("user");
	   password = p.getProperty("password");
	   maxconn = Integer.parseInt(p.getProperty("maxconn"));
   }
   
   public static int getMaxConn(){
	   return maxconn;
   }
   

}
