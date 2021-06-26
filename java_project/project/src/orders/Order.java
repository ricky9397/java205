package orders;

public class Order {
	
	private int oidx;
	private long ordercode;
	private int icode;
	private int idx ;
	private String orderdate;
	private int count;
	private int oprice;
	
	public Order() {
	}
	
	public Order(int idx) {
		this.idx = idx;
	}
	
	public Order(int oidx, long ordercode, int icode, int idx, String orderdate, int count, int oprice) {
		this.oidx = oidx;
		this.ordercode = ordercode;
		this.icode = icode;
		this.idx = idx;
		this.orderdate = orderdate;
		this.count = count;
		this.oprice = oprice;
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
	public int getOprice() {
		return oprice;
	}
	public void setOprice(int oprice) {
		this.oprice = oprice;
	}
	
	
}
