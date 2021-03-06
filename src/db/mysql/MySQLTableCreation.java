package db.mysql;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class MySQLTableCreation {
	// Run this as Java application to reset db schema.
	public static void main(String[] args) {
		try {
			// Ensure the driver is imported.
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// This is java.sql.Connection. Not com.mysql.jdbc.Connection.
			Connection conn = null;

			// Step 1 Connect to MySQL.
			try {
				System.out.println("Connecting to \n" + MySQLDBUtil.URL);
				conn = DriverManager.getConnection(MySQLDBUtil.URL);
			} catch (SQLException e) {
				System.out.println("SQLException " + e.getMessage());
				System.out.println("SQLState " + e.getSQLState());
				System.out.println("VendorError " + e.getErrorCode());
			}
			if (conn == null) {
				return;
			}
			// Step 2 Drop tables in case they exist.
			Statement stmt = conn.createStatement();

			String sql = "DROP TABLE IF EXISTS event_history";
			stmt.executeUpdate(sql);

			sql = "DROP TABLE IF EXISTS restaurant_history";
			stmt.executeUpdate(sql);

			sql = "DROP TABLE IF EXISTS new_history";
			stmt.executeUpdate(sql);

			sql = "DROP TABLE IF EXISTS place_history";
			stmt.executeUpdate(sql);

			sql = "DROP TABLE IF EXISTS categories";
			stmt.executeUpdate(sql);

			sql = "DROP TABLE IF EXISTS events";
			stmt.executeUpdate(sql);

			sql = "DROP TABLE IF EXISTS restaurants";
			stmt.executeUpdate(sql);

			sql = "DROP TABLE IF EXISTS news";
			stmt.executeUpdate(sql);

			sql = "DROP TABLE IF EXISTS places";
			stmt.executeUpdate(sql);

			sql = "DROP TABLE IF EXISTS users";
			stmt.executeUpdate(sql);

			// Step 3. Create new tables.
			sql = "CREATE TABLE events " 
					+ "(item_id VARCHAR(255) NOT NULL, " 
					+ "name VARCHAR(255), "
					+ "date VARCHAR(255), " 
					+ "byline VARCHAR(255), "
					+ "categories VARCHAR(255), "
					+ "city VARCHAR(255), " 
					+ "state VARCHAR(255), " 
					+ "country VARCHAR(255), "
					+ "zipcode VARCHAR(255), " 
					+ "address VARCHAR(255), " 
					+ "rating FLOAT, "
					+ "latitude FLOAT, "
					+ "longitude FLOAT, " 
					+ "description VARCHAR(255), " 
					+ "snippet VARCHAR(255), "
					+ "snippet_url VARCHAR(255), " 
					+ "image_url VARCHAR(255), " 
					+ "url VARCHAR(255), "
					+ "PRIMARY KEY ( item_id ))";
			stmt.executeUpdate(sql);

			sql = "CREATE TABLE restaurants "
					+ "(item_id VARCHAR(255) NOT NULL, " 
					+ "name VARCHAR(255), "
					+ "date VARCHAR(255), " 
					+ "byline VARCHAR(255), "
					+ "categories VARCHAR(255), "
					+ "city VARCHAR(255), " 
					+ "state VARCHAR(255), " 
					+ "country VARCHAR(255), "
					+ "zipcode VARCHAR(255), " 
					+ "address VARCHAR(255), " 
					+ "rating FLOAT, "
					+ "latitude FLOAT, "
					+ "longitude FLOAT, " 
					+ "description VARCHAR(255), " 
					+ "snippet VARCHAR(255), "
					+ "snippet_url VARCHAR(255), " 
					+ "image_url VARCHAR(255), " 
					+ "url VARCHAR(255), "
					+ "PRIMARY KEY ( item_id ))";
			stmt.executeUpdate(sql);

			sql = "CREATE TABLE news " 
					+ "(item_id VARCHAR(255) NOT NULL, " 
					+ "name VARCHAR(255), "
					+ "date VARCHAR(255), " 
					+ "byline VARCHAR(255), "
					+ "categories VARCHAR(255), "
					+ "city VARCHAR(255), " 
					+ "state VARCHAR(255), " 
					+ "country VARCHAR(255), "
					+ "zipcode VARCHAR(255), " 
					+ "address VARCHAR(255), " 
					+ "rating FLOAT, " 
					+ "latitude FLOAT, "
					+ "longitude FLOAT, " 
					+ "description VARCHAR(255), " 
					+ "snippet VARCHAR(255), "
					+ "snippet_url VARCHAR(255), " 
					+ "image_url VARCHAR(255), " 
					+ "url VARCHAR(255), "
					+ "PRIMARY KEY ( item_id ))";
			stmt.executeUpdate(sql);

			sql = "CREATE TABLE places " 
					+ "(item_id VARCHAR(255) NOT NULL, " 
					+ "name VARCHAR(255), "
					+ "date VARCHAR(255), " 
					+ "byline VARCHAR(255), "
					+ "categories VARCHAR(255), "
					+ "city VARCHAR(255), " 
					+ "state VARCHAR(255), " 
					+ "country VARCHAR(255), "
					+ "zipcode VARCHAR(255), " 
					+ "address VARCHAR(255), " 
					+ "rating FLOAT, "
					+ "latitude FLOAT, "
					+ "longitude FLOAT, " 
					+ "description VARCHAR(255), " 
					+ "snippet VARCHAR(255), "
					+ "snippet_url VARCHAR(255), " 
					+ "image_url VARCHAR(255), " 
					+ "url VARCHAR(255), "
					+ "PRIMARY KEY ( item_id ))";
			stmt.executeUpdate(sql);

			sql = "CREATE TABLE users " 
					+ "(user_id VARCHAR(255) NOT NULL, " 
					+ " password VARCHAR(255) NOT NULL, "
					+ " first_name VARCHAR(255), last_name VARCHAR(255), " 
					+ " PRIMARY KEY ( user_id ))";
			stmt.executeUpdate(sql);

			sql = "CREATE TABLE event_history " 
					+ "(history_id bigint(20) unsigned NOT NULL AUTO_INCREMENT, "
					+ " user_id VARCHAR(255) NOT NULL , " 
					+ " item_id VARCHAR(255) NOT NULL, "
					+ " last_favor_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, " 
					+ " PRIMARY KEY (history_id),"
					+ "FOREIGN KEY (item_id) REFERENCES events(item_id),"
					+ "FOREIGN KEY (user_id) REFERENCES users(user_id))";
			stmt.executeUpdate(sql);

			sql = "CREATE TABLE restaurant_history "
					+ "(history_id bigint(20) unsigned NOT NULL AUTO_INCREMENT, "
					+ " user_id VARCHAR(255) NOT NULL , "
					+ " item_id VARCHAR(255) NOT NULL, "
					+ " last_visited_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
					+ " PRIMARY KEY (history_id),"
					+ "FOREIGN KEY (item_id) REFERENCES restaurants(item_id),"
					+ "FOREIGN KEY (user_id) REFERENCES users(user_id))";
			stmt.executeUpdate(sql);

			sql = "CREATE TABLE new_history " 
					+ "(history_id bigint(20) unsigned NOT NULL AUTO_INCREMENT, "
					+ " user_id VARCHAR(255) NOT NULL , " 
					+ " item_id VARCHAR(255) NOT NULL, "
					+ " last_favor_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, " 
					+ " PRIMARY KEY (history_id),"
					+ "FOREIGN KEY (item_id) REFERENCES news(item_id),"
					+ "FOREIGN KEY (user_id) REFERENCES users(user_id))";
			stmt.executeUpdate(sql);

			sql = "CREATE TABLE place_history " 
					+ "(history_id bigint(20) unsigned NOT NULL AUTO_INCREMENT, "
					+ " user_id VARCHAR(255) NOT NULL , " 
					+ " item_id VARCHAR(255) NOT NULL, "
					+ " last_favor_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, " 
					+ " PRIMARY KEY (history_id),"
					+ "FOREIGN KEY (item_id) REFERENCES places(item_id),"
					+ "FOREIGN KEY (user_id) REFERENCES users(user_id))";
			stmt.executeUpdate(sql);

			// Step 4: insert data
			// Create a fake user
			sql = "INSERT INTO users " + "VALUES (\"1111\", \"3229c1097c00d497a0fd282d586be050\", \"Stephen\", \"Yep\")";

			System.out.println("Executing query:\n" + sql);
			stmt.executeUpdate(sql);

			System.out.println("Import is done successfully.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
