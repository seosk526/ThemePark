package themepark;

import java.util.Scanner;

public class OutputClass {
	Scanner sc = null;
	
	public OutputClass() {
		sc = new Scanner(System.in);
	}
	
	// 티켓 가격 출력
	public void pricePrint(int priceResult) {
		System.out.printf("가격은 %d원 입니다.\n", priceResult);
		System.out.printf("감사합니다.\n\n");
	}
	
	// 주문내역 출력
	public void orderPrint(int totalPrice, int position, int[][] orderList) {
		ProcessClass process = new ProcessClass();
		
		System.out.printf("티켓 발권을 종료합니다. 감사합니다.\n");
		System.out.println();
		System.out.printf("=============시응월드=============");
		
		for (int index = 0; index < position; index++) {
			switch (orderList[index][0]) {
			case 1: // 주간권
				System.out.printf("주간권");
				break;
			case 2: // 야간권
				System.out.printf("야간권");
				break;
			default :
				break;
			}
			if (process.calcAgeGroup(orderList[index][1]) == ConstValueClass.baby) {
				System.out.printf("유아    ");
			} else if (process.calcAgeGroup(orderList[index][1]) == ConstValueClass.child) {
				System.out.printf("어린이  ");
			} else if (process.calcAgeGroup(orderList[index][1]) == ConstValueClass.teen) {
				System.out.printf("청소년  ");
			} else if (process.calcAgeGroup(orderList[index][1]) == ConstValueClass.adult) {
				System.out.printf("어른    ");
			} else {
				System.out.printf("노인    ");
			}
			System.out.printf("X %3d", orderList[index][2]);
			System.out.printf("X %8d원", orderList[index][3]);
			
			switch (orderList[index][4]) {
			case 1:
				System.out.printf("*우대적용 없음\n");
				break;
			case 2:
				System.out.printf("*장애인 우대적용\n");
				break;
			case 3:
				System.out.printf("*국가유공자 우대적용\n");
				break;	
			case 4:
				System.out.printf("*다자녀 우대적용\n");
				break;
			case 5:
				System.out.printf("*임산부 우대적용\n");
				break;
			default :
				break;	
			}
		}
		System.out.println();
		System.out.printf("입장료 총액은 %d원 입니다.\n", totalPrice);
		System.out.printf("===============================");
		System.out.println();
	}
	
	// 이어서 주문 or 주문내역 출력 후 종료
	public int orderContinue() {
		int countSelect = 0;
		System.out.printf("게속 발권 하시겠습니까?\n"
				+ "1. 티켓 발권\n"
				+ "2. 종료\n");
		while (true) {
			countSelect = sc.nextInt();
			if (countSelect == 1 || countSelect == 2) {
				break;
			} else {
				errorMessagePrint();
			}
		}
		return countSelect;		
	}
	
	public void errorMessagePrint() {
		System.out.printf("잘못 입력하셨습니다.\n");
	}
}
