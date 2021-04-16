package themepark;

import java.util.Calendar;

public class ProcessClass {

	public int calcAge(long customerIDNumber) {
		long calcIDNumber = 0; // 생년월일
		int customYear = 0, customMonth = 0, customDay = 0; // 구매자 생년월일
		int todayYear = 0, todayMonth = 0, todayDay = 0; // 오늘 날짜
		int type = 0; // 구매자 성별 및 2000년생 구분
		int koreanAge = 0, age = 0;

		customerIDNumber += ConstValueClass.full_Digit; // 앞자리 보존 위해 해당값 더함(19505262169711)
		calcIDNumber = (int) (customerIDNumber / ConstValueClass.seven_Digit); // ex)19505262
		type = (int) (calcIDNumber % 10); // 뒷자리 첫 번호 추출 ex) 2

		calcIDNumber = calcIDNumber / ConstValueClass.one_Digit; // ex)19505262 / 10 = 1950526
		customDay = (int) (calcIDNumber % ConstValueClass.two_Digit); // 일 계산 ex)1950526 % 100 = 26

		calcIDNumber = calcIDNumber / ConstValueClass.two_Digit; // ex)1950526 / 100 = 19505
		customMonth = (int) (calcIDNumber % ConstValueClass.two_Digit); // 월 계산 ex)19505 % 100 = 5

		calcIDNumber = calcIDNumber / ConstValueClass.two_Digit; // ex)19505 / 100 = 195
		customYear = (int) (calcIDNumber % ConstValueClass.two_Digit); // 생년 계산 ex)195 % 100 = 95

		if (type == ConstValueClass.male_New || type == ConstValueClass.female_New) {
			customYear += ConstValueClass.new_Generation; // 2000년생 이상인 경우 2000 더함
		} else {
			customYear += ConstValueClass.old_Generation; // 아닌 경우 1900 더함
		}

		Calendar cal = Calendar.getInstance();
		cal.get(Calendar.YEAR); // 현재 년도
		cal.get((Calendar.MONTH) + 1); // 현재 월
		cal.get(Calendar.DATE); // 현재 일
		koreanAge = cal.get(Calendar.YEAR) - customYear + 1; // 한국식 나이

		if (customMonth < todayMonth || customMonth == todayMonth && customDay <= todayDay) {
			age = koreanAge - ConstValueClass.after_Birth; // 생일 안지났기 때문에 2살 차감
		} else {
			age = koreanAge - ConstValueClass.before_Birth; // 생일 지났기 때문에 1살 차감
		}
		return age;
	}

	// 연령대별 분류
	public int calcAgeGroup(int age) {
		// int baby = 1, child = 2, teen = 3, adult = 4, old = 5;
		if (age < ConstValueClass.child_Min) {
			return ConstValueClass.baby;
		} else if (age >= ConstValueClass.child_Min && age <= ConstValueClass.child_Max) {
			return ConstValueClass.child;
		} else if (age >= ConstValueClass.teen_Min && age <= ConstValueClass.teen_Max) {
			return ConstValueClass.teen;
		} else if (age >= ConstValueClass.adult_Min && age <= ConstValueClass.adult_Max) {
			return ConstValueClass.adult;
		} else if (age > ConstValueClass.adult_Max) {
			return ConstValueClass.old;
		}
		return age;
	}

	// 권종과 나이에 따른 금액 계산
	public int calcPriceProcess(int age, int ticketSelect) {
		int calcPrice = 0;
		if (calcAgeGroup(age) == ConstValueClass.baby) {
			calcPrice = ConstValueClass.baby_Price;
		} else if (calcAgeGroup(age) == ConstValueClass.child) {
			if (ticketSelect == 1) {
				calcPrice = ConstValueClass.child_Day_Price;
			} else if (ticketSelect == 2) {
				calcPrice = ConstValueClass.child_After4_Price;
			}
		} else if (calcAgeGroup(age) == ConstValueClass.teen) {
			if (ticketSelect == 1) {
				calcPrice = ConstValueClass.teen_Day_Price;
			} else if (ticketSelect == 2) {
				calcPrice = ConstValueClass.teen_After4_Price;
			}
		} else if (calcAgeGroup(age) == ConstValueClass.adult) {
			if (ticketSelect == 1) {
				calcPrice = ConstValueClass.adult_Day_Price;
			} else if (ticketSelect == 2) {
				calcPrice = ConstValueClass.adult_After4_Price;
			}
		} else {
			if (ticketSelect == 1) {
				calcPrice = ConstValueClass.old_Day_Price;
			} else if (ticketSelect == 2) {
				calcPrice = ConstValueClass.old_After4_Price;
			}
		}
		return calcPrice;
	}

	// 우대사항에 따른 할인 계산
	public int calcDiscount(int calcPrice, int discountSelect) {
		switch (discountSelect) {
		case 2: // 장애인
			calcPrice = (int) (calcPrice * ConstValueClass.disable_Discount_Rate);
			break;
		case 3: // 국가유공자
			calcPrice = (int) (calcPrice * ConstValueClass.merit_Discount_Rate);
			break;
		case 4: // 다자녀
			calcPrice = (int) (calcPrice * ConstValueClass.multichile_Discount_Rate);
			break;
		case 5: // 임산부
			calcPrice = (int) (calcPrice * ConstValueClass.pregnant_Discount_Rate);
			break;
		default:
			break;
		}
		return calcPrice;
	}

	// 주문 갯수에 따른 금액 계산
	public int calcPriceResult(int calcPrice, int orderCount) {
		return (calcPrice * orderCount);
	}

	// 계산 함수 호출 int*age가 나오는데 이게 무슨 말인지 모르겠땨
	public int processIntergration(long customerIDNumber, int ticketSelect, int discountSelect, int orderCount,
			int priceResult, int age) {
		int calcPrice = 0;
		age = calcAge(customerIDNumber); // 만 나이 계산
		calcPrice = calcPriceProcess(age, ticketSelect); // 권종과 나이에 따른 금액 계산
		calcPrice = calcDiscount(calcPrice, discountSelect); // 우대사항에 따른 할인 계산
		priceResult = calcPriceResult(calcPrice, orderCount); // 주문 갯수에 따른 금액 계산
		return priceResult; // 최종 요금 반환
	}
	
	// 주문 내역 저장
	public void saveOrderList(int ticketSelect, int age, int orderCount, int priceResult, int discountSelect,
			int position, int[][] orderList) {
		orderList[position][0] = ticketSelect;
		orderList[position][1] = age;
		orderList[position][2] = orderCount;
		orderList[position][3] = priceResult;
		orderList[position][4] = discountSelect;
		position++;
	}
}
