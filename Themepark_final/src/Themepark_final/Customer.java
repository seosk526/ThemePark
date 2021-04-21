package Themepark_final;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	// 선언만 먼저해줌
	private String date;
	private int ticketType;
	private int age;
	private int orderCount;
	private int price;
	private int discountType;

	public Customer(int ticketType, int age, int orderCount, int price, int discountType) {
		// 따로 매소드 만들어서 this로 변수값 선언
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String orderDate = sdf.format(today);
		this.date = orderDate;
		this.ticketType = ticketType;
		this.age = CalPriceClass.ageGroup(age);
		this.orderCount = orderCount;
		this.price = price;
		this.discountType = discountType;
	}

	public String getDate() {
		return date;
	}

	public int getTicketType() {
		return ticketType;
	}

	public String getTicketTypeStr() {
		String ticketStr = "";
		switch (ticketType) {
		case 1:
			ticketStr = "주간권";
		case 2:
			ticketStr = "야간권";
		default:
			break;
		}
		return ticketStr;
	}

	public int getAge() {
		return age;
	}

	public String getAgeStr() {
		String ageGroup = "";
		switch (age) {
		case ConstValueClass.baby:
			ageGroup = "유아";
		case ConstValueClass.child:
			ageGroup = "어린이";
		case ConstValueClass.teen:
			ageGroup = "청소년";
		case ConstValueClass.adult:
			ageGroup = "어른";
		case ConstValueClass.old:
			ageGroup = "노인";
		default:
			break;
		}
		return ageGroup;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public int getPrice() {
		return price;
	}

	public int getDiscountType() {
		return discountType;
	}

	public String getDiscountTypeStr() {
		String discountStr = "";
		switch (discountType) {
		case 1:
			discountStr = "우대적용 없음";
		case ConstValueClass.disable_Discount_Num:
			discountStr = "* 장애인 우대적용";
		case ConstValueClass.merit_Discount_Num:
			discountStr = "* 국가유공자 우대적용";
		case ConstValueClass.multichile_Discount_Num:
			discountStr = "* 다자녀 우대적용";
		case ConstValueClass.pregnant_Discount_Num:
			discountStr = "* 임산부 우대적용";
		default:
			break;
		}
		return discountStr;
	}
}
