package themepark0419;

public class OrderInfo {
	public String tTicketSelectZone;
	public String sort;
	public int ticketNum;
	public int finalPrice;
	public String result;	

	public String gettTicketSelectZone() {
		return tTicketSelectZone;
	}
	public void settTicketSelectZone(int tTicketSelectZone) {
		if (tTicketSelectZone == 1) {
			this.tTicketSelectZone = "주간권";
		} else if (tTicketSelectZone == 2) {
			this.tTicketSelectZone = "야간권";
		}
	}
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}
	public int getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
