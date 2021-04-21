package Themepark_final;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int totalPrice = 0;
		int isContinue = 0;
		int isExit = 0;
		ArrayList<Customer> orderList;
		Customer customer;
		InputClass inputData;
		CalPriceClass calPrice;		
		do {
			orderList = new ArrayList<Customer>();			
			while (true) {
				// 입력부분
				inputData = new InputClass();
				inputData.runInput();				
				// 가격 계산 부분
				calPrice = new CalPriceClass(inputData);
				calPrice.runTicket();
				// 기록 저장 부분
				customer = new Customer(inputData.getTicket(), calPrice.getAge(), inputData.getOrderCount(), calPrice.getResultPrice(), inputData.getDiscountType());
				calPrice.saveOrderList(customer, orderList);
				// 총 금액 구하기
				totalPrice += calPrice.getResultPrice();
				// 금액 출력
				OutputClass.prtPrice(calPrice.getResultPrice());
				// 계속 진행 여부 입력
				isContinue = inputData.orderContinue();
				if (isContinue == 2) {
					break;
				}
			} // do 안에 있는 while문 종료
			OutputClass.prtOrderList(totalPrice, orderList);			
			isExit = inputData.programContinue();
		} while (isExit == 1); // isExit가 1인 동안 do안에 내용 실행
	}
}
