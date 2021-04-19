package themepark0419;

public class Div {
	public static String divage(int nowAge) {
		String sort = null;
		if (nowAge < ConstValueClass.child_Min) {
			sort = "유아";
			return sort;
		} else if (nowAge >= ConstValueClass.child_Min && nowAge < ConstValueClass.teen_Min) {
			sort = "어린이";
			return sort;
		} else if (nowAge >= ConstValueClass.teen_Min && nowAge < ConstValueClass.adult_Min) {
			sort = "청소년";
			return sort;
		} else if (nowAge >= ConstValueClass.adult_Min && nowAge < ConstValueClass.adult_Max) {
			sort = "성인";
			return sort;
		} else {
			sort = "노인";
			return sort;
		}
	}
	
	public static String t_zone(int ticketType) {
		if (ticketType == 1) {
			String ticketSelect_Zone = "주간권";
			return ticketSelect_Zone;
		} else {
			String ticketSelect_Zone = "야간권";
			return ticketSelect_Zone;
		}
	}
}
