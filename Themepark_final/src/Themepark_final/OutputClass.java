package Themepark_final;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class OutputClass {
	private static BufferedWriter bw;
	private static String fileName = "report.csv";

	public static void errMsg() {
		System.out.println("잘못 입력하셨습니다.");
	}

	public static void prtPrice(int totalPrice) {
		System.out.printf("가격은 %d 원 입니다.\n", totalPrice);
		System.out.printf("감사합니다.\n\n");
	}

	public static void prtOrderList(int totalPrice, ArrayList<Customer> orderList) throws Exception {
		System.out.printf("티켓 발권을 종료합니다. 감사합니다.\n\n");
		System.out.printf("========================= PolyLand =========================\n");
		Customer cus = null;
		for (int i = 0; i < orderList.size(); i++) {
			cus = orderList.get(i);
			cus.getTicketTypeStr();
			System.out.printf("%s\t", cus.getTicketTypeStr());			// 권종입력(주간/야간)
			System.out.printf("%s\t", cus.getAgeStr());						// 연령입력(유아, 어린이,...)
			System.out.printf("X %3d\t", cus.getOrderCount());		// 수량입력
			System.out.printf("%8d원\t", cus.getPrice());					// 금액입력
			System.out.printf("%s\n", cus.getDiscountTypeStr());	// 우대사항 입력(국가유공자, 임산부...)
			writeFile(cus);
			writeDB(cus);
		}
		System.out.printf("\n입장료 총액은 %d원 입니다.\n", totalPrice);
		System.out.printf("============================================================\n\n");
	}
	
	private static void writeFile(Customer customer) throws IOException {
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), "utf-8"));
		File file = new File(fileName);
		if (file.exists()) {
			bw.append(String.format("%s,%s,%s,%d,%d,%s\n", 
					customer.getDate(), customer.getTicketType(), customer.getAge(), 
					customer.getOrderCount(), customer.getPrice(), customer.getDiscountType()));
			bw.close();
		} else {
			bw.write("날짜,권종,연령구분,수량,가격,우대사항\n");
			bw.close();
		}
	}
	
	private static void writeDB(Customer customer) throws Exception {		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb", "root", "147258");
		Statement stmt = conn.createStatement();
		stmt.execute("INSERT INTO report VALUES ("
				+ customer.getDate() + ","
				+ customer.getTicketType() + ","
				+ customer.getAge() + ","
				+ customer.getOrderCount() + ","
				+ customer.getPrice() + ","
				+ customer.getDiscountType() + ");"
				);
		stmt.close();
		conn.close();		
	}
}
