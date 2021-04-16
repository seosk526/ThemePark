package themepark;

public class ConstValueClass {
	// 나이별 입장요금
	public static final int baby_Price = 0;
	public static final int child_Day_Price = 46000, child_After4_Price = 35000;
	public static final int teen_Day_Price = 50000, teen_After4_Price = 40000;
	public static final int adult_Day_Price = 56000, adult_After4_Price = 45000;
	public static final int old_Day_Price = 46000, old_After4_Price = 35000;
	// 주민번호 분석
	public static final long full_Digit = 10000000000000L; // 14자리
	public static final long full_Digit_Min = 10000000000L; // 11자리
	public static final int seven_Digit = 1000000;
	public static final int two_Digit = 100, one_Digit = 10, old_Generation = 1900, new_Generation = 2000, male_Old = 1,
			female_Old = 2, male_New = 3, female_New = 4, before_Birth = 2, after_Birth = 1;
	// 나이 범위
	public static final int baby_Min = 1, child_Min = 3, teen_Min = 13, adult_Min = 19, child_Max = 12, teen_Max = 18,
			adult_Max = 64;
	// 나이에 따른 그룹 번호
	public static final int baby = 1, child = 2, teen = 3, adult = 4, old = 5;
	// 할인율(성인 요금 기준 장애인: 50%, 국가유공자 50%, 다자녀 30%, 임산부 50%)
	public static final float disable_Discount_Rate = 0.5f, merit_Discount_Rate = 0.5f, pregnant_Discount_Rate = 0.5f,
			multichile_Discount_Rate = 0.7f;
	// 최대 주문량
	public static final int count_Max = 10, count_Min = 1;
}
