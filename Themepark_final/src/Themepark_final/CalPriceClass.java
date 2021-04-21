package Themepark_final;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CalPriceClass {
	private InputClass data;
	private int age;
	private int rawPrice;
	private int disPrice;
	private int resultPrice;
	
	public CalPriceClass(InputClass data) {
		this.data = data;
		this.rawPrice = 0;
		this.disPrice = 0;
		this.resultPrice = 0;
	}
	
	public int getAge() {
		return age;
	}

	public int getResultPrice() {
		return resultPrice;
	}
	
	public void runTicket() {
		age = customerAge(data.getIdNumber());
		rawPrice = calRawPrice(age, data.getTicket());
		disPrice = calDiscount(rawPrice, data.getDiscountType());
		resultPrice = calTotalPrice(disPrice, data.getOrderCount());
	}

	public int customerAge(String idNumber) {
		int age = 0;
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		int thisYear = Integer.parseInt(sdf.format(today).substring(0, 4));				// 2021
		int thisMonth = Integer.parseInt(sdf.format(today).substring(4, 6));			// 04
		int thisDay = Integer.parseInt(sdf.format(today).substring(6, 8));				// 19
		int cusYear = Integer.parseInt(idNumber.substring(0, 2));								// 95
		int cusMonth = Integer.parseInt(idNumber.substring(2, 4));							// 05
		int cusDay = Integer.parseInt(idNumber.substring(4, 6));								// 26
		if (idNumber.charAt(6) == '1' || idNumber.charAt(6) == '2') {
			cusYear += ConstValueClass.old_Gen;				// 1900년대
		} else if (idNumber.charAt(6) == '3' || idNumber.charAt(6) == '4') {
			cusYear += ConstValueClass.new_Gen;			// 2000년대
		}
		age = thisYear - cusYear;
		if (cusMonth > thisMonth || (cusMonth == thisMonth && cusDay > thisDay)) {
			age--; // 만 나이 계산시 생일 안지났으면 -1
		}
		return age;
	}

	// 연령별 각 그룹넘버 구분
	public static int ageGroup(int age) {
		if (age < ConstValueClass.child_Min) {
			return ConstValueClass.baby;
		} else if (age >= ConstValueClass.child_Min && age <= ConstValueClass.child_Max) {
			return ConstValueClass.child;
		} else if (age >= ConstValueClass.teen_Min && age <= ConstValueClass.teen_Max) {
			return ConstValueClass.teen;
		} else if (age >= ConstValueClass.adult_Min && age <= ConstValueClass.adult_Max) {
			return ConstValueClass.adult;
		} else {
			return ConstValueClass.old;
		}
	}

	// 연령별 금액 구분
	public int calRawPrice(int age, int ticket) {
		int rawPrice = 0;
		if (ageGroup(age) == ConstValueClass.baby) {
			rawPrice = ConstValueClass.baby_Price;
		} else if (ageGroup(age) == ConstValueClass.child) {
			if (ticket == 1) {
				rawPrice = ConstValueClass.child_Day_Price;
			} else {
				rawPrice = ConstValueClass.child_After4_Price;
			}
		} else if (ageGroup(age) == ConstValueClass.teen) {
			if (ticket == 1) {
				rawPrice = ConstValueClass.teen_Day_Price;
			} else {
				rawPrice = ConstValueClass.teen_After4_Price;
			}
		} else if (ageGroup(age) == ConstValueClass.adult) {
			if (ticket == 1) {
				rawPrice = ConstValueClass.adult_Day_Price;
			} else {
				rawPrice = ConstValueClass.adult_After4_Price;
			}
		} else if (ageGroup(age) == ConstValueClass.old) {
			if (ticket == 1) {
				rawPrice = ConstValueClass.old_Day_Price;
			} else {
				rawPrice = ConstValueClass.old_After4_Price;
			}
		}
		return rawPrice;
	}

	// 우대사항에 따른 금액 구분
	public int calDiscount(int rawPrice, int discountType) {
		double disPrice = 0;
		switch (discountType) {
		case ConstValueClass.disable_Discount_Num:
			disPrice = rawPrice * ConstValueClass.disable_Discount_Rate;
			break;
		case ConstValueClass.merit_Discount_Num:
			disPrice = rawPrice * ConstValueClass.merit_Discount_Rate;
			break;
		case ConstValueClass.multichile_Discount_Num:
			disPrice = rawPrice * ConstValueClass.multichile_Discount_Rate;
			break;
		case ConstValueClass.pregnant_Discount_Num:
			disPrice = rawPrice * ConstValueClass.pregnant_Discount_Rate;
			break;
		default:
			disPrice = rawPrice;
			break;
		}
		return (int) disPrice;
	}

	// 총금액 입력
	public int calTotalPrice(int disPrice, int orderCount) {
		return disPrice * orderCount;
	}

	public void saveOrderList(Customer customer, ArrayList<Customer> orderList) {
		orderList.add(customer);
	}
}
