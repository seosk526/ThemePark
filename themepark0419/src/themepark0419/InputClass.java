package themepark0419;

import java.util.Scanner;

public class InputClass {
	Scanner sc = null;

	public InputClass() {
		sc = new Scanner(System.in);
	}
	// 권종 입력 매소드
	public int inputTicketSelect() {
		int ticketSelect = 0;
		System.out.println("권종을 선택하세요.\n" + "1. 주간권\n" + "2. 야간권");
		while (true) {
			ticketSelect = sc.nextInt();
			if (ticketSelect == 1 || ticketSelect == 2) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		return ticketSelect;
	}
	// 주민번호 입력 매소드
	public String inputCustomerIDNumber() {
		String customerIDNumber = "";
		System.out.println("주민번호를 입력하세요.");
		customerIDNumber = sc.next();
		while (true) {
			if (customerIDNumber.length() == 13) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		return customerIDNumber;
	}
	// 주문 갯수 입력 매소드
	public int inputOrderCount() {
		System.out.println("몇 개를 주문하시겠습니까? (최대 10개)");
		int orderCount = sc.nextInt();
		return orderCount;
	}
	// 우대사항 입력 매소드
	public int inputDiscountSelect() {
		int discountSelect = 0;
		System.out.println(
				"우대사항을 선택하세요.\n" + "1. 없음 (나이 우대는 자동처리)\n" + "2. 장애인\n" + "3. 국가유공자\n" + "4. 다자녀\n" + "5. 임산부");
		while (true) {
			discountSelect = sc.nextInt();
			if (discountSelect >= 1 && discountSelect <= 5) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		return discountSelect;
	}
    // 발권진행여부 입력 매소드
	public int printMore() {
		System.out.printf("게속 발권 하시겠습니까?\n" + "1. 티켓 발권\n" + "2. 종료\n");
		int moreNum = sc.nextInt();
		return moreNum;
	}
}
