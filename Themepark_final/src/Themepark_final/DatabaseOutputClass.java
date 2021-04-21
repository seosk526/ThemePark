package Themepark_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseOutputClass {
	private Connection conn;
	private Statement stmt;
	
	public DatabaseOutputClass() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb", "root", "147258");
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addToDatabase(Customer customer) {
		try {
			String str = "INSERT INFO `report` (`date`, `type`, `age`, `count`, `price`, `advantage`)"
					+ "VALUES (now(), "
					+ "'" + customer.getTicketTypeStr() + "', "
					+ "'" + customer.getAgeStr() + "', "
					+ "'" + customer.getOrderCount() + "', "
					+ "'" + customer.getPrice() + "',"
					+ "'" + customer.getDiscountTypeStr() + "',);";
			System.out.println(str);
			stmt.execute(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
