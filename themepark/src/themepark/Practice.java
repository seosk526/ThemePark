package themepark;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Practice {
	static Scanner sc = new Scanner(System.in);
	// 나이별 입장요금
	static int baby_Price = 0;
	static int child_Day_Price = 46000, child_After4_Price = 35000;
	static int teen_Day_Price = 50000, teen_After4_Price = 40000;
	static int adult_Day_Price = 56000, adult_After4_Price = 45000;
	static int old_Day_Price = 46000, old_After4_Price = 35000;	
	// 주민번호 분석
	static long full_Digit = 10000000000000L;     //14자리
	static long full_Digit_Min = 10000000000L;  // 11자리
	static int seven_Digit = 1000000;
	static int two_Digit = 100, one_Digit = 10, old_Generation = 1900, new_Generation = 2000, male_Old = 1,
			female_Old = 2, male_New = 3, female_New = 4, before_Birth = 2, after_Birth = 1;
	// 나이 범위
	static int baby_Min = 1, child_Min = 3, teen_Min = 13, adult_Min = 19, child_Max = 12, teen_Max = 18,
			adult_Max = 64;
	// 나이에 따른 그룹 번호
	static int baby = 1, child = 2, teen = 3, adult = 4, old = 5;
	// 할인율(성인 요금 기준 장애인: 50%, 국가유공자 50%, 다자녀 30%, 임산부 50%)
	static float disable_Discount_Rate = 0.5f, merit_Discount_Rate = 0.5f, pregnant_Discount_Rate = 0.5f,
			multichile_Discount_Rate = 0.7f;
	// 최대 주문량
	static int count_Max = 10, count_Min = 1;
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalPrice = 0; // 주문 총액
		int position = 0; // 주문 내역 배열 탐색용
		int fileposition = 0; // 파일 출력 첫 줄 구분
		int reportPosition = 0;
		int[][] orderList = new int[100][5];
		int isExit = 0;

		// do {
		// 여기에 과연 무엇을 넣어야 하나
		// }
		while (true) {
			long customerIDNumber = 0; // 주민등록번호
			int ticketSelect = 0, orderCount = 0, discountSelect = 0; // 권종, 주문 갯수, 우대사항
			int priceResult = 0, age = 0; // 가격, 나이
			int continueSelect = 0; // 이어서 주문
			
			//입력함수 호출
			inputData(ticketSelect, customerIDNumber, orderCount, discountSelect);
			//priceResult = processIntegeration(customerIDNumber, ticketSelect, discountSelect, priceResult, age);
		}
	}
		// 권종 입력 매소드
		public static int inputTicketSelect() {   
			int ticketSelect;
			System.out.println("권종을 선택하세요.\n" + "1. 주간권\n" + "2. 야간권");
			while (true) {
				ticketSelect = sc.nextInt();  // 주간권, 야간권 번호 입력
				if (ticketSelect == 1 || ticketSelect == 2) {
					break;
				} else {
					
				}
			}
			return ticketSelect;				
		}
		// 주민번호 입력 매소드
		public static long inputCustomerIDNumber() {
			System.out.println("주민번호를 입력하세요.");
			long customerIDNumber = sc.nextInt(); // 주민번호 입력
			while (true) {
				if (customerIDNumber >= full_Digit_Min && customerIDNumber < full_Digit) {     // 11<=customID<14
					break;
				} else {
					//printErrorMessage();
				}
			}
			return customerIDNumber;					
		}
        // 주문 갯수 입력 매소드
		public static int inputOrderCount() {
			int orderCount;
			System.out.println("몇 개를 주문하시겠습니까? (최대 10개)");
			while (true) {
				orderCount = sc.nextInt();
				if (orderCount <= count_Max && orderCount >= count_Min) {
					break;
				} else {
					//printErrorMessage();
				}
			}
			return orderCount;
		}
		// 우대사항 입력 매소드
		public static int inputDiscountSelect() {
			int discountSelect;
			System.out.println("우대사항을 선택하세요.\n" + "1. 없음 (나이 우대는 자동처리)\n" + "2. 장애인\n" + "3. 국가유공자\n" + "4. 다자녀\n" + "5. 임산부");
			while (true) {
				discountSelect = sc.nextInt();
				if (discountSelect >= 1 && discountSelect <= 5) {
					break;
				} else {
					//printErrorMessage();
				}
			}
			return discountSelect;			
		}
		// 입력 함수 호출
		public static void inputData(int ticketSelect, long customerIDNumber, int orderCount, int discountSelect) {
			ticketSelect = inputTicketSelect();                             // 권종 입력
			customerIDNumber = inputCustomerIDNumber();   // 주민번호 입력
			orderCount = inputOrderCount();                              // 주문 갯수 입력
			discountSelect = inputDiscountSelect();                   // 우대사항 입력
		}
		
		public static int calcAge(long customID) {
			long calcIDNumber = 0;  // 생년월일
			int customYear = 0, customMonth = 0, customDay = 0;  // 구매자 생년월일
			int todayYear = 0, todayMonth = 0, todayDay = 0; // 오늘 날짜
			int type = 0;  // 구매자 성별 및 2000년생 구분
			int koreanAge = 0, age = 0;
			
			customID += full_Digit;  // 앞자리 보존 위해 해당값 더함(19505262169711)
			calcIDNumber = (int) (customID / seven_Digit);   // ex)19505262
			type = (int) (calcIDNumber % 10);  //뒷자리 첫 번호 추출 ex) 2
			
			calcIDNumber = calcIDNumber / one_Digit;   // ex)19505262 / 10 = 1950526
			customDay = (int) (calcIDNumber % two_Digit);  // 일 계산 ex)1950526 % 100 = 26
			
			calcIDNumber = calcIDNumber / two_Digit;  // ex)1950526 / 100 = 19505
			customMonth = (int) (calcIDNumber % two_Digit);  // 월 계산 ex)19505 % 100 = 5
			
			calcIDNumber = calcIDNumber / two_Digit;  // ex)19505 / 100 = 195
			customYear = (int) (calcIDNumber % two_Digit);  // 생년 계산 ex)195 % 100 = 95
			
			if (type == male_New ||type == female_New) {
				customYear += new_Generation;   // 2000년생 이상인 경우 2000 더함
			} else {
				customYear += old_Generation;   // 아닌 경우 1900 더함
			}
			
			Calendar cal = Calendar.getInstance();
			//cal.add(Calendar.YEAR, -2000);
			cal.get(Calendar.YEAR);  // 현재 년도
			cal.get((Calendar.MONTH) + 1);  // 현재 월
			cal.get(Calendar.DATE); // 현재 일			
			koreanAge = cal.get(Calendar.YEAR) - customYear + 1;  // 한국식 나이
			
			if (customMonth < todayMonth || customMonth == todayMonth && customDay <= todayDay) {
				age = koreanAge - after_Birth;  // 생일 안지났기 때문에 2살 차감
			} else {
				age = koreanAge - before_Birth;  // 생일 지났기 때문에 1살 차감
			}	
			return age;
		}
			// 연령대별 분류
			public static int calcAgeGroup(int age) {				
				if (age < child_Min)	{  
					return 1;   //int baby = 1, child = 2, teen = 3, adult = 4, old = 5;
				} else if (age >= child_Min && age <= child_Max) {
					return 2;
				} else if (age >= teen_Min && age <= teen_Max) {
					return 3;
				} else if (age >= adult_Min && age <= adult_Max ) {
					return 4;
				} else if (age >adult_Max) {
					return 5;
				}
				return age;
			}
			// 권종과 나이에 따른 금액 계산
			public static int calcPriceProcess(int age, int ticketSelect) {
				int calcPrice = 0;
				if (calcAgeGroup(age) == baby) {
					calcPrice = baby_Price;
				} 
				else if (calcAgeGroup(age) == child) {
					if (ticketSelect == 1) {
						calcPrice = child_Day_Price;
					} else if (ticketSelect == 2) {
						calcPrice = child_After4_Price ;
					}
				}
				else if (calcAgeGroup(age) == teen) {
					if (ticketSelect == 1) {
						calcPrice = teen_Day_Price;
					} else if (ticketSelect == 2) {
						calcPrice = teen_After4_Price ;
					}
				}
				else if (calcAgeGroup(age) == adult) {
					if (ticketSelect == 1) {
						calcPrice = adult_Day_Price;
					} else if (ticketSelect == 2) {
						calcPrice = adult_After4_Price ;
					}
				}
				else {
					if (ticketSelect == 1) {
						calcPrice = old_Day_Price;
					} else if (ticketSelect == 2) {
						calcPrice = old_After4_Price ;
					}
				}
				return calcPrice;				
			}
			
			//우대사항에 따른 할인 계산
			public static int calcDiscount(int calcPrice, int discountSelect) {
				switch (discountSelect) {
				case 2:
					calcPrice = (int) (calcPrice * disable_Discount_Rate);
					break;
				case 3:
					calcPrice = (int) (calcPrice * merit_Discount_Rate);
					break;
				case 4:
					calcPrice = (int) (calcPrice * multichile_Discount_Rate);
					break;
				case 5:
					calcPrice = (int) (calcPrice * pregnant_Discount_Rate);
					break;
				default:
					break;
				}
				return calcPrice;
			}
			// 주문 갯수에 따른 금액 계산
			public static int calcPriceResult(int calcPrice, int orderCount) {
				return (calcPrice * orderCount);
			}		
			// 계산 함수 호출  int*age가 나오는데 이게 무슨 말인지 모르겠땨
			public static int processIntergration(long customerIDNumber, int ticketSelect, int discountSelect, int orderCount, int priceResult, int age) {
				int calcPrice = 0;
				age = calcAge(customerIDNumber);                                  // 만 나이 계산
				calcPrice = calcPriceProcess(age, ticketSelect);               //권종과 나이에 따른 금액 계산
				calcPrice = calcDiscount(calcPrice, discountSelect);       // 우대사항에 따른 할인 계산
				priceResult = calcPriceResult(calcPrice, orderCount);    // 주문 갯수에 따른 금액 계산
				return priceResult;																   // 최종 요금 반환 
			}
			
			// 주문 내역 저장
			public static void saveOrderList(int ticketSelect, int age, int orderCount, int priceResult, int discountSelect, int position, int orderList[5]) {
				
			}
			
		
		public static void printPrice(int number2, int number3) {
			System.out.printf("가격은 %s원 입니다.\n"
					+ "감사합니다.\n"
					+ "계속 발권 하시겠습니까?\n"
					+ "1. 티켓 발권\n"
					+ "2. 종료");
			number2 = sc.nextInt();
			if (number2 == 1) {
			
			} else if (number2 == 2) {
				System.out.printf("티켓 발권을 종료합니다. 감사합니다.\n");
				System.out.printf("========시응월드========\n");
				
				//기록 담겨야 함				
				
				System.out.printf("입장료 총액은 %d원 입니다.");
				System.out.printf("========시응월드========\n");
				System.out.printf("계속 진행(1: 새로운 주문, 2: 프로그램 종료");
				number3 = sc.nextInt();
				if (number3 == 1) {
					
				} else if (number3 == 2) {
					
				}
			}
		}
}
