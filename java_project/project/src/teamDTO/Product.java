package teamDTO;

public class Product {
	private int icode;
	private String iname;
	private int iprice;
	private int count;
	
	public Product() {
	}
	public Product(int icode, String iname, int iprice, int count) {
		this.icode = icode; // 상품번호
 		this.iname = iname; // 상품이름
		this.iprice = iprice; // 상품가격
		this.count = count; // 상품제고
	}
	public int getIcode() {
		return icode;
	}
	public void setIcode(int icode) {
		this.icode = icode;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public int getIprice() {
		return iprice;
	}
	public void setIprice(int iprice) {
		this.iprice = iprice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Product [icode=" + icode + ", iname=" + iname + ", iprice=" + iprice + ", count=" + count + "]";
	}
	
}
