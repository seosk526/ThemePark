package themepark0419;

import java.util.Calendar;

public class ProcessClass {
	public static int calcAge (String customerIDNumber) {
		Calendar cal = Calendar.getInstance();
		int todayYear = cal.get(Calendar.YEAR); // 현재 년도
		int todayMonth = cal.get(Calendar.MONTH + 1); // 현재 월
		
		int year = Integer.parseInt(customerIDNumber.substring(0, 2));  //95
		int month = Integer.parseInt(customerIDNumber.substring(2, 4));  //05
		int generation = Integer.parseInt(customerIDNumber.substring(6, 7));  //2
		
		int birthYear = 0;
		int age =0;
		if (generation == 1 || generation == 2) {
			birthYear = ConstValueClass.OLD_GEN + year;
			if (month > todayMonth) {
				age = (todayYear - birthYear);
			} else {
				age = (todayYear - birthYear) + 1;
			}
		} else {
			birthYear = ConstValueClass.NEW_GEN + year;
			if (month > todayMonth) {
				age = (todayYear - birthYear);
			} else {
				age = (todayYear - birthYear) + 1;
			}
		}
		return age;
	}
	
	public static int calcPriceProcess(int ticketType, int age) {
		int ticketPrice = 0;
		if (ticketType == 1) {
			if (age < ConstValueClass.child_Min) {
				ticketPrice = ConstValueClass.baby_Price;
				return ticketPrice;
			} else if (age >= ConstValueClass.child_Min && age < ConstValueClass.teen_Min) {
				ticketPrice = ConstValueClass.child_Day_Price;
				return ticketPrice;
			} else if (age >= ConstValueClass.teen_Min && age < ConstValueClass.adult_Min) {
				ticketPrice = ConstValueClass.teen_Day_Price;
				return ticketPrice;
			} else if (age >= ConstValueClass.adult_Min && age < ConstValueClass.adult_Max) {
				ticketPrice = ConstValueClass.adult_Day_Price;
				return ticketPrice;
			} else {
				ticketPrice = ConstValueClass.old_Day_Price;
				return ticketPrice;
			}
		} else if (ticketType == 2) {
				if (age < ConstValueClass.child_Min) {
					ticketPrice = ConstValueClass.baby_Price;
					return ticketPrice;
				} else if (age >= ConstValueClass.child_Min && age < ConstValueClass.teen_Min) {
					ticketPrice = ConstValueClass.child_After4_Price;
					return ticketPrice;
				} else if (age >= ConstValueClass.teen_Min && age < ConstValueClass.adult_Min) {
					ticketPrice = ConstValueClass.teen_After4_Price;
					return ticketPrice;
				} else if (age >= ConstValueClass.adult_Min && age < ConstValueClass.adult_Max) {
					ticketPrice = ConstValueClass.adult_After4_Price;
					return ticketPrice;
				} else {
					ticketPrice = ConstValueClass.old_After4_Price;
					return ticketPrice;				
			}			
		}
		return ticketPrice;		
	}
	
	public static int discount(int ticketPrice, int discountNum) {
		int discountPrice = 0;
		if (discountNum == 1) {
			discountPrice = ticketPrice;
			return discountPrice;
		} else if (discountNum == 2) {
			discountPrice = (int) (ticketPrice * ConstValueClass.disable_Discount_Rate);
			return discountPrice;
		} else if (discountNum == 3) {
			discountPrice = (int) (ticketPrice * ConstValueClass.merit_Discount_Rate);
			return discountPrice;
		} else if (discountNum == 4) {
			discountPrice = (int) (ticketPrice * ConstValueClass.multichile_Discount_Rate);
			return discountPrice;
		} else if (discountNum == 5) {
			discountPrice = (int) (ticketPrice * ConstValueClass.pregnant_Discount_Rate);
			return discountPrice;
		} else {
			return discountPrice;
		}
	}
	
	public static int calcPriceResult(int ticketNum, int discountPrice) {
		int finalPrice = discountPrice * ticketNum;
		return finalPrice;
	}
	
	public static int priceResult(String customerIDNumber, int ticketType, int discountNum, int ticketNum, int age, int totalPrice) {
		int calPrice = 0;
		age = calcAge(customerIDNumber);
		calPrice = calcPriceProcess(ticketType, age);
		calPrice = discount(calPrice, discountNum);
		totalPrice = totalPrice + calcPriceResult(ticketNum, calPrice);
		return totalPrice;
	}
}
