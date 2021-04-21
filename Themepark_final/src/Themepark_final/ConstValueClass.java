package Themepark_final;

import java.io.File;

public class ConstValueClass {
	// 나이별 입장요금
	public static final int baby_Price = 0;
	public static final int child_Day_Price = 46000;
	public static final int child_After4_Price = 35000;
	public static final int teen_Day_Price = 50000;
	public static final int teen_After4_Price = 40000;
	public static final int adult_Day_Price = 56000;
	public static final int adult_After4_Price = 45000;
	public static final int old_Day_Price = 46000;
	public static final int old_After4_Price = 35000;
	// 할인율(성인 요금 기준 장애인: 50%, 국가유공자 50%, 다자녀 30%, 임산부 50%)
	public static final double disable_Discount_Rate = 0.5;
	public static final double merit_Discount_Rate = 0.5;
	public static final double pregnant_Discount_Rate = 0.5;
	public static final double multichile_Discount_Rate = 0.7;
	// 우대사항에 따른 번호지정
	public static final int disable_Discount_Num = 2;
	public static final int merit_Discount_Num = 3;
	public static final int pregnant_Discount_Num = 4;
	public static final int multichile_Discount_Num = 5;
	// 나이에 따른 그룹 번호
	public static final int baby = 1;
	public static final int child = 2;
	public static final int teen = 3;
	public static final int adult = 4;
	public static final int old = 5;
	// 나이 범위
	public static final int baby_Min = 1;
	public static final int child_Min = 3;
	public static final int teen_Min = 13;
	public static final int adult_Min = 19;
	public static final int child_Max = 12;
	public static final int teen_Max = 18;
	public static final int adult_Max = 64;
	// 주민번호 조회
	public static double personalNum = 0;
	public static final int old_Gen = 1900;
	public static final int new_Gen = 2000;
	// 주문량 범위
	public static final int count_Max = 10;
	public static final int count_Min = 1;
	// data base
		public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
		public static final String DB_URL = "jdbc:mysql://localhost:3306/testdb"; 
		//jdbc:mysql://127.0.0.1:3306/testdb
		public static final String DB_ID = "root"; 
		public static final String DB_PW = "147258"; 
}