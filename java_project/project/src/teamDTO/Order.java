package teamDTO;

public class Order {
	private int oidx;	// pk
	private long ordercode; // 주문코드
	private int icode; // 상품번호
	private int idx; // 회원번호
	private String orderdate; // 주문날짜 
	private int count; // 수량갯수
	private int price; // 가격
	
	public Order() {
	}
	public Order(int icode, int count) {
		this.icode = icode;
		this.count = count;
	}
	public Order(int oidx, long ordercode, int icode, int idx, String orderdate, int count, int price) {
		this.oidx = oidx;
		this.ordercode = ordercode;
		this.icode = icode;
		this.idx = idx;
		this.orderdate = orderdate;
		this.count = count;
		this.price = price;
	}

	public int getOidx() {
		return oidx;
	}
	public void setOidx(int oidx) {
		this.oidx = oidx;
	}
	public long getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(long ordercode) {
		this.ordercode = ordercode;
	}
	public int getIcode() {
		return icode;
	}
	public void setIcode(int icode) {
		this.icode = icode;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [oidx=" + oidx + ", ordercode=" + ordercode + ", icode=" + icode + ", idx=" + idx + ", orderdate="
				+ orderdate + ", count=" + count + ", price=" + price + "]";
	}
	
	
}
