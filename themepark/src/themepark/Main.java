package themepark;

import java.util.Scanner;

public class Main {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int totalPrice = 0; // 주문 총액
		int position = 0; // 주문 내역 배열 탐색용
		int fileposition = 0; // 파일 출력 첫 줄 구분
		int reportPosition = 0;
		int[][] orderList = new int[100][5];
		int isExit = 0;
		
			while (true) {
				long customerIDNumber = 0; // 주민등록번호
				int ticketSelect = 0, orderCount = 0, discountSelect = 0; // 권종, 주문 갯수, 우대사항
				int priceResult = 0, age = 0; // 가격, 나이
				int continueSelect = 0; // 이어서 주문
				//입력함수 호출
				InputClass inputclass = new InputClass();				
				inputclass.inputData(ticketSelect, customerIDNumber, orderCount, discountSelect);
				
				ProcessClass processclass = new ProcessClass();
				// 요금계산
				processclass.processIntergration(customerIDNumber, ticketSelect, discountSelect, orderCount, priceResult, age);
				// 주만 내역 저장
				processclass.saveOrderList(ticketSelect, age, orderCount, priceResult, discountSelect, position, orderList);
				// 요금합계 합산
				totalPrice += priceResult;
				OutputClass outputclass = new OutputClass();
				outputclass.pricePrint(priceResult);
				continueSelect = outputclass.orderContinue();
				if (continueSelect == 2) {
					break;
				}
			}
			OutputClass outputclass = new OutputClass();
			outputclass.orderPrint(totalPrice, position, orderList);
			//outputclass.orderFilePrint();
			
			System.out.printf("계속 진행(1. 새로운 주문, 2: 프로그램 종료): ");
			isExit = sc.nextInt();
			position = 0;
			totalPrice = 0;		
	}
}