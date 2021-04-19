package themepark0419;

import java.io.IOException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<OrderInfo> orderinfo = new ArrayList<OrderInfo>();
		
		int ticketSelect = 0, orderCount = 0, discountSelect = 0, moreSelect = 0;
		String customerIDNumber = null;
		
		int ticketPrice, discountPrice, finalPrice, age;
		String ticketSelect_Zone = null;
		String sort, result;
		
		InputClass input = new InputClass();
		
		SaveList.head();
		do {
			SaveList.date();
			ticketSelect = input.inputTicketSelect();  // 권종 입력
			customerIDNumber = input.inputCustomerIDNumber(); // 주민번호 입력 
			age = ProcessClass.calcAge(customerIDNumber); // 나이 계산
			orderCount = input.inputOrderCount(); // 티켓 수량 입력
			
			ticketPrice = ProcessClass.calcPriceProcess(ticketSelect, age); // 권종별 가격 측정
	
			discountSelect = input.inputDiscountSelect(); // 우대사항 입력

			discountPrice = ProcessClass.discount(ticketPrice, discountSelect); // 우대사항 적용된 가격 측정

			finalPrice = ProcessClass.calcPriceResult(orderCount, discountPrice); // 최종가격 측정

			finalPrice = ProcessClass.priceResult(customerIDNumber, ticketSelect, discountSelect, orderCount, age, finalPrice);
			// totalPrice 측정
			ticketSelect_Zone = ZoneSortClass.t_zone(ticketSelect);
			sort = ZoneSortClass.divage(age);
			result = OutputClass.reason(discountSelect);
			
			OutputClass.printResult(ticketSelect_Zone, sort, finalPrice, orderCount);
			OutputClass.savelist(ticketSelect, sort, finalPrice, orderCount, result, orderinfo);
			
			moreSelect = input.printMore();
		} while (moreSelect != 2); {
			OutputClass.printDetail(ticketSelect, sort, finalPrice, orderCount, result, orderinfo);
		}
	}
}
