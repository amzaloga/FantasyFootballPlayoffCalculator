package calculatorPlayoff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectionLayerOpenConnection {
	ResultSet rs;

	public ResultSet openConnection(String query) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ffc?user=root&password=Football31*");
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	public void updateQuery(String query) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ffc?user=root&password=Football31*");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception d) {
			System.out.println(d);
		}
	}

}
