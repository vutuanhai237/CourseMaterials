package utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import model.ListStudent;

public class Utils {
	private static Logger LOGGER = LogManager.getLogger(ListStudent.class);

	public static class JDBCUtils {
		private static String jdbcURL = "jdbc:mysql://localhost:3306/demo";
		private static String jdbcUsername = "root";
		private static String jdbcPassword = "root";

		public static Date getSQLDate(LocalDate date) {
			return java.sql.Date.valueOf(date);
		}

		public static LocalDate getUtilDate(Date sqlDate) {
			return sqlDate.toLocalDate();
		}

		public static Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				LOGGER.info("Connect databse successfully");
			} catch (SQLException e) {
				printSQLException(e);
			} catch (ClassNotFoundException e) {
				LOGGER.error("JDBC not fould, conect database falled");
				e.printStackTrace();
			}
			return connection;
		}

		public static void printSQLException(SQLException ex) {
			for (Throwable e : ex) {
				if (e instanceof SQLException) {
					LOGGER.error("Conect database falled");
					LOGGER.error("SQLState: " + ((SQLException) e).getSQLState());
					LOGGER.error("Error Code: " + ((SQLException) e).getErrorCode());
					LOGGER.error("Message: " + e.getMessage());
					e.printStackTrace(System.err);
					Throwable t = ex.getCause();
					while (t != null) {
						LOGGER.error("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}
	}

	public static class JSONUtils {
		public static String getJSON(Object object) {
			String jsonString = new Gson().toJson(object);
			return jsonString;
		}
	}
}