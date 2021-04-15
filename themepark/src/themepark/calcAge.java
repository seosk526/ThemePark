package themepark;

import java.util.Calendar;
import java.util.Scanner;

public class calcAge {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long customID = 9505262169711L;
		long full_Digit = 10000000000000L; // 14자리
		long full_Digit_Min = 10000000000L; // 11자리
		int seven_Digit = 1000000;
		int two_Digit = 100, one_Digit = 10, old_Generation = 1900, new_Generation = 2000, male_Old = 1, female_Old = 2,
				male_New = 3, female_New = 4, before_Birth = 2, after_Birth = 1;
		// 나이 범위
		int baby_Min = 1, child_Min = 3, teen_Min = 13, adult_Min = 19, child_Max = 12, teen_Max = 18, adult_Max = 64;
		// 나이에 따른 그룹 번호
		int baby = 1, child = 2, teen = 3, adult = 4, old = 5;

		long calcIDNumber = 0; // 생년월일
		int customYear = 0, customMonth = 0, customDay = 0; // 구매자 생년월일
		int todayYear = 0, todayMonth = 0, todayDat = 0; // 오늘 날짜
		int type = 0; // 구매자 성별 및 2000년생 구분
		int koreanAge = 0, age = 0;

		customID += full_Digit; // 앞자리 보존 위해 해당값 더함(19505262169711)
		calcIDNumber = (int) (customID / seven_Digit); // ex)19505262
		type = (int) (calcIDNumber % 10);
		
		// System.out.println(calcIDNumber);
		// System.out.println(type);
		// System.out.println(1950526 / 100);
		// System.out.println(19505 % 100);
		// System.out.println(19505 / 100);
		// System.out.println(195 % 100);

		
		Calendar cal = Calendar.getInstance();
		//cal.add(Calendar.YEAR, -2000);
		cal.get(Calendar.YEAR);
		cal.get((Calendar.MONTH) + 1);
		cal.get(Calendar.DATE);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));
		koreanAge = cal.get(Calendar.YEAR) - 1995 + 1;
		System.out.println(koreanAge);
	}
	
	public static int inputTicketSelect() {    //return을 어떻게 해야 될지 모르겠음.........
		System.out.println("권종을 선택하세요.\n" + "1. 주간권\n" + "2. 야간권");
		while (true) {
			int ticketSelect = sc.nextInt();  // 주간권, 야간권 번호 입력
			if (ticketSelect == 1 || ticketSelect == 2) {
				break;
			} else {
				//printErrorMessage();
			}
		}				
	}
}
