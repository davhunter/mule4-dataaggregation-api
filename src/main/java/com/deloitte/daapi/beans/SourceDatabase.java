package com.deloitte.daapi.beans;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.InitializingBean;

/**
 * Spring Bean used to initialize the in-memory Derby database.
 * 
 * @author David Hunter (Deloitte)
 * @apiviz.landmark
 *
 */
public class SourceDatabase implements InitializingBean {

	/**
	 * Called by Spring at runtime. Examines the in-memory database, and, if it
	 * doesn't exist (based on whether the <code>sources</code> table exists),
	 * creates it and populates it with sample data.
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		String dbURL = "jdbc:derby:memory:sourceDB;create=true";

		Connection conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			conn = DriverManager.getConnection(dbURL);
			DatabaseMetaData md = conn.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);

			int i = 0;
			while (rs.next()) {
				if (rs.getString(3).equalsIgnoreCase("sources")) {
					i = 1;
				}
			}

			if (i != 1) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("CREATE TABLE sources (\n" + "    id INTEGER PRIMARY KEY,\n"
						+ "    name VARCHAR(500),\n" + "    url VARCHAR(2000)\n" + ")");
				stmt.executeUpdate(
						"INSERT INTO sources (id, name, url) VALUES (1, 'Twitter', 'https://www.twitter.com')");
				stmt.executeUpdate("INSERT INTO sources (id, name, url) VALUES (2, 'Google','https://www.google.ca')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

	}

}
