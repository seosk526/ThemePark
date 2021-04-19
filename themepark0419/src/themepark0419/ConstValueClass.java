package themepark0419;

import java.io.File;

public class ConstValueClass {
	// 나이별 입장요금
		public static final int baby_Price = 0;
		public static final int child_Day_Price = 46000, child_After4_Price = 35000;
		public static final int teen_Day_Price = 50000, teen_After4_Price = 40000;
		public static final int adult_Day_Price = 56000, adult_After4_Price = 45000;
		public static final int old_Day_Price = 46000, old_After4_Price = 35000;
		// 할인율(성인 요금 기준 장애인: 50%, 국가유공자 50%, 다자녀 30%, 임산부 50%)
		public static final double disable_Discount_Rate = 0.5, merit_Discount_Rate = 0.5, pregnant_Discount_Rate = 0.5,
				multichile_Discount_Rate = 0.7;
		// 나이에 따른 그룹 번호
		public static final int baby = 1, child = 2, teen = 3, adult = 4, old = 5;
		// 나이 범위
		public static final int baby_Min = 1, child_Min = 3, teen_Min = 13, adult_Min = 19, child_Max = 12, teen_Max = 18,
				adult_Max = 64;
		//주민번호 조회
		public static double personalNum = 0;
		public static final int OLD_GEN = 1900;
		public static final int NEW_GEN = 2000;
		
		static File file = new File("test.txt");
}
