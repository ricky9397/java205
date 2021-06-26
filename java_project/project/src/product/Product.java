package product;

public class Product {
	
	private int icode;
	private String iname;
	private int count;
	private int iprice;

	public Product() {}
	
	public Product(int icode,String iname, int iprice ,int count) {
		this.icode = icode;
		this.iname = iname;
		this.iprice = iprice;
		this.count = count;
	}

	public Product(int icode,  int count) {
		this.icode = icode;
		this.count = count;
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

}
