package themepark;

import java.util.Scanner;

public class InputClass {
	Scanner sc = null;
	OutputClass outputclass = new OutputClass();

	public InputClass() {
		sc = new Scanner(System.in);		
	}

	// 권종 입력 매소드
	public int inputTicketSelect() {
		int ticketSelect;
		System.out.println("권종을 선택하세요.\n" + "1. 주간권\n" + "2. 야간권");
		while (true) {
			ticketSelect = sc.nextInt(); // 주간권, 야간권 번호 입력
			if (ticketSelect == 1 || ticketSelect == 2) {
				break;
			} else {
				outputclass.errorMessagePrint();
			}
		}
		return ticketSelect;
	}

	// 주민번호 입력 매소드
	public long inputCustomerIDNumber() {
		System.out.println("주민번호를 입력하세요.");
		long customerIDNumber = sc.nextLong(); // 주민번호 입력
		while (true) {
			if (customerIDNumber >= ConstValueClass.full_Digit_Min && customerIDNumber < ConstValueClass.full_Digit) { // 11<=customID<14
				break;
			} else {
				outputclass.errorMessagePrint();
			}
		}
		return customerIDNumber;
	}

	// 주문 갯수 입력 매소드
	public int inputOrderCount() {
		int orderCount;
		System.out.println("몇 개를 주문하시겠습니까? (최대 10개)");
		while (true) {
			orderCount = sc.nextInt();
			if (orderCount <= ConstValueClass.count_Max && orderCount >= ConstValueClass.count_Min) {
				break;
			} else {
				outputclass.errorMessagePrint();
			}
		}
		return orderCount;
	}

	// 우대사항 입력 매소드
	public int inputDiscountSelect() {
		int discountSelect;
		System.out.println(
				"우대사항을 선택하세요.\n" + "1. 없음 (나이 우대는 자동처리)\n" + "2. 장애인\n" + "3. 국가유공자\n" + "4. 다자녀\n" + "5. 임산부");
		while (true) {
			discountSelect = sc.nextInt();
			if (discountSelect >= 1 && discountSelect <= 5) {
				break;
			} else {
				outputclass.errorMessagePrint();
			}
		}
		return discountSelect;
	}

	// 입력 함수 호출
	public void inputData(int ticketSelect, long customerIDNumber, int orderCount, int discountSelect) {
		ticketSelect = inputTicketSelect(); // 권종 입력
		customerIDNumber = inputCustomerIDNumber(); // 주민번호 입력
		orderCount = inputOrderCount(); // 주문 갯수 입력
		discountSelect = inputDiscountSelect(); // 우대사항 입력
	}	
}
