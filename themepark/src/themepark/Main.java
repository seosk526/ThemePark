package themepark;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 나이별 입장요금
		int baby_Price = 0;
		int child_Day_Price = 46000, child_After4_Price = 35000;
		int teen_Day_Price = 50000, teen_After4_Price = 40000;
		int adult_Day_Price = 56000, adult_After4_Price = 45000;
		int old_Day_Price = 46000, old_After4_Price = 35000;
		// 주민번호 분석
		long full_Digit = 10000000000000L;
		long full_Digit_Min = 10000000000L;
		int seven_Digit =  1000000;
		int two_Digit = 100, one_Digit = 10, old_Generation = 1900, new_Generation = 2000, 
				male_Old = 1, female_Old = 2, male_New = 3, female_New = 4, before_Birth = 2, after_Birth = 1;
		// 나이 범위
		int baby_Min = 1, child_Min = 3, teen_Min = 13, adult_Min = 19, 
				child_Max = 12, teen_Max = 18, adult_Max = 64;
		// 나이에 따른 그룹 번호
		int baby = 1, child = 2, teen = 3, adult = 4, old = 5;
		// 할인율(성인 요금 기준 장애인: 50%, 국가유공자 50%, 다자녀 30%, 임산부 50%)
		double disable_Discount_Rate = 0.5, 
					merit_Discount_Rate = 0.5, 
					pregnant_Discount_Rate = 0.5,	
					multichile_Discount_Rate = 0.7;  	
		// 최대 주문량
		int count_Max = 10, count_Min = 1;
		
		int totalPrice = 0;
		int position = 0;
		int fileposition = 0;
		int reportPosition = 0;
		int[][] orderList = new int [100][5];
		int isExit = 0;
		
		//do {
			    //여기에 과연 무엇을 넣어야 하나
		//} 
			while (true) {
			long customerIDNumber = 0;  														// 주민등록번호
			int ticketSelect = 0, orderCount = 0, discountSelect = 0;    // 권종, 주문 갯수, 우대사항
			int priceResult = 0, age = 0;  														// 가격, 나이		
			int continueSelect = 0;                                                                 // 이어서 주문
		}
			
	public int inputTicketSelect() {
		int ticketSelect = 0;
		System.out.println("권종을 선택하세요.\n" + "1. 주간권\n" + "2. 야간권");
		while (true) {
			ticketSelect = sc.nextInt();
			if (ticketSelect == 1 || ticketSelect == 2) {
				break;
			} else {
				//errorMessagePrint();
			}
			get
		}
	}
			
			public void inputData(int ticketSelect, long customerIDNumber, int orderCount, int discountSelect)	{
		
	}

			/*System.out.println("권종을 선택하세요.\n" + "1. 주간권\n" + "2. 야간권");
			int num1 = sc.nextInt(); // 주간권, 야간권 번호 입력
			System.out.println("주민번호를 입력하세요.");
			String regnum = sc.next(); // 주민번호 입력
			String reg1 = regnum.substring(0, 2);
			System.out.println(reg1);
			System.out.println("몇 개를 주문하시겠습니까? (최대 10개)");
			int amount = sc.nextInt(); // 수량 입력
			System.out.println(
					"우대사항을 선택하세요.\n" + "1. 없음 (나이 우대는 자동처리)\n" + "2. 장애인\n" + "3. 국가유공자\n" + "4. 다자녀\n" + "5. 임산부");
			int num2 = sc.nextInt(); // 우대사항 입력
			System.out.printf("가격은 %d원입니다.\n" // 추후 가격 변수 입력
					+ "감사합니다.\n"
					+ "계속 발권 하시겠습니까?\n"
					+ "1. 티켓 발권\n"
					+ "2. 종료\n");
			int num3 = sc.nextInt(); // 발권여부 입력
			*/
	}
}