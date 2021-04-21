package Themepark_final;

import java.util.Scanner;

public class InputClass {
	private Scanner sc;
	private int ticket;
	private String idNumber;
	private int orderCount;
	private int discountType;
	

	public InputClass() {
		this.ticket = 0;
		this.idNumber = "";
		this.orderCount = 0;
		this.discountType = 0;
	}

	public int getTicket() {
		return ticket;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public int getDiscountType() {
		return discountType;
	}

	public void runInput() {
		ticket = inputTicket();
		idNumber = inputCustomerID();
		orderCount = inputOrderCount();
		discountType = inputDiscount();
	}
	
	// 권종 입력
	public int inputTicket() {
		int ticket = 0;
		System.out.printf("\n권종을 선택하세요.\n");
		System.out.printf("1. 주간권\n");
		System.out.printf("2. 야간권\n");
		while (true) {
			sc = new Scanner(System.in);
			try {
				ticket = sc.nextInt();
			} catch (Exception e) {
				e.getStackTrace();
			}
			if (ticket == 1 || ticket == 2) {
				break;
			} else {
				OutputClass.errMsg();
			}
		}
		return ticket;
	}
	// 주민번호 입력
	public String inputCustomerID() {
		String idNumber = "";
		System.out.printf("주민등록번호를 입력하세요('-'제외)\n");
		while (true) {
			sc = new Scanner(System.in);
			idNumber = sc.nextLine();
			if (idNumber.length() == 13 && ((int) idNumber.charAt(6) >= 49 && (int) idNumber.charAt(6) <= 52)) { // 문자 1,2,3,4는 int로 변환하면 49-52
				break;
			} else {
				OutputClass.errMsg();
			}
		}
		return idNumber;
	}
	// 수량 입력
	public int inputOrderCount() {
		int orderCount = 0;
		System.out.printf("몇 장을 주문하시겠습니까? (최대 10개)\n");
		while (true) {
			sc = new Scanner(System.in);
			orderCount = sc.nextInt();
			if (orderCount >= ConstValueClass.count_Min && orderCount <= ConstValueClass.count_Max) {
				break;
			} else {
				OutputClass.errMsg();
			}
		}
		return orderCount;
	}
	// 우대사항 입력
	public int inputDiscount() {
		int discountType = 0;
		System.out.printf("우대사항을 선택하세요.\n");
		System.out.printf("1. 없음(나이 우대는 자동처리)\n");
		System.out.printf("2. 장애인\n");
		System.out.printf("3. 국가유공자\n");
		System.out.printf("4. 다자녀\n");
		System.out.printf("5. 임산부\n");

		while (true) {
			sc = new Scanner(System.in);
			discountType = sc.nextInt();
			if (discountType >= 1 && discountType <= 5) {
				break;
			} else {
				OutputClass.errMsg();
			}
		}
		return discountType;
	}
	// 추가 발권 진행여부 입력
	public int orderContinue() {
		int isContinue = 0;
		System.out.printf("계속 발권 하시겠습니까?\n");
		System.out.printf("1. 티켓발권\n");
		System.out.printf("2. 종료\n");
		while (true) {
			sc = new Scanner(System.in);
			isContinue = sc.nextInt();
			if (isContinue == 1 || isContinue == 2) {
				break;
			} else {
				OutputClass.errMsg();
			}
		}
		return isContinue;
	}
	
	public int programContinue() {
		int isExit = 0;
		System.out.printf("계속 진행(1: 새로운 주문, 2: 프로그램 종료) : ");
		sc = new Scanner(System.in);
		isExit = sc.nextInt();
		
		return isExit;
	}
}
