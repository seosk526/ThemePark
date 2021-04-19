package themepark0419;

import java.io.IOException;
import java.util.ArrayList;

public class OutputClass {
	// 발권 중 중간 내역 출력
		public static void printResult(String ticketSelect_Zone , String sort, int totalPrice, int ticketnum) {
			System.out.printf("가격은 %d원 입니다.\n", totalPrice);		
		}
		// 우대 사유 출력
		public static String reason(int discountNum) throws IOException {
			String result = null;
			if(discountNum == 1) {
				result = "*우대적용 없음";
				return result;
			} else if(discountNum == 2) {
				result = "*장애인 우대적용";
				return result;
			} else if(discountNum == 3) {
				result = "*국가유공자 우대적용";
				return result;
			} else if(discountNum == 4) {
				result = "*다자녀 우대적용";
				return result;
			} else if (discountNum == 5) {
				result = "*임산부 우대적용";
				return result;
			} else {
				result = "잘못 입력하셨습니다.";
				return result;
			}
		}
		// 발권 끝낼 시 총 내역 출력
		public static void printDetail(int ticketType, String sort, int totalPrice, int ticketNum, 
													 String result, ArrayList<OrderInfo> orderListArray) {
			System.out.println("=========  polypoly world  =========");
			
			String text = "";										
				
			for (int i = 0; i < orderListArray.size(); i++) {
				OrderInfo info = orderListArray.get(i);		
				text = info.gettTicketSelectZone() + ", " + info.getSort() + ", " + 
						info.getTicketNum() + ", " + info.getFinalPrice() + ", " + info.getResult();
				System.out.println(text);			
			} 
		}
		// 총 내역 저장 메서드
		public static void savelist(int ticketType, String sort, int totalPrice, int ticketNum, 
				 					String result, ArrayList<OrderInfo> orderListArray) {			
			
			OrderInfo infoset = new OrderInfo();
			
			infoset.settTicketSelectZone(ticketType);
			infoset.setSort(sort);
			infoset.setTicketNum(ticketNum);
			infoset.setFinalPrice(totalPrice);
			infoset.setResult(result);
				
			orderListArray.add(infoset);
		}
		//파일 저장
		public static void Ordersave(String tZone, String sort, int finalPrice, int ticketNum, String result) throws IOException {
			
			SaveList.list(String.valueOf(tZone));
			SaveList.list(String.valueOf(sort));
			SaveList.list(String.valueOf(ticketNum));			
			SaveList.list(String.valueOf(finalPrice));
			SaveList.reason(result);
			
		}
		
	} //class종료


