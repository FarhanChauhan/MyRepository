package in.ineuron;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class JdbcApp {

	static Logger logger = Logger.getLogger(JdbcApp.class);
	static {
		
		PropertyConfigurator.configure("src/main/java/in/ineuron/cfg/log4j.properties");
//		SimpleLayout layout = new SimpleLayout();
//		ConsoleAppender appender = new ConsoleAppender(layout);
//		logger.addAppender(appender);
//		logger.setLevel(Level.DEBUG);
	}
	public static void main(String[] args) {

		logger.debug("Control entered in main method");
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			logger.debug("Driver loaded successfully");

			String url = "jdbc:mysql:///octbatch";
			String user = "root";
			String password = "Farhan@123";
			connection = DriverManager.getConnection(url, user, password);
			logger.info("Connection object created successfully");
			
			statement = connection.createStatement();
			logger.info("Statement object created successfully");

			String sqlSelectQuery = "select sid,sname,sage from student";
			resultSet = statement.executeQuery(sqlSelectQuery);
			logger.info("ResultSet object created by executing query");

			while (resultSet.next()) {
				System.out.println(resultSet.getInt("sid") + "\t" + resultSet.getString("sname") + "\t"
						+ resultSet.getInt("sage"));
			}
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			logger.error("Class not found Exception");
		} catch (SQLException se) {
			se.printStackTrace();
			logger.error("SQL Exception"+se.getMessage()+"===>"+se.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal("unknown exception occured");
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
				logger.error("SQL Exception"+se.getMessage()+"===>"+se.getErrorCode());
			}
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
				logger.error("SQL Exception"+se.getMessage()+"===>"+se.getErrorCode());
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
				logger.error("SQL Exception"+se.getMessage()+"===>"+se.getErrorCode());
			}
		}
		logger.debug("main method executed");
	}
}
