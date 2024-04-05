package Day_08_OO4_0405;

public class Product {
	private int code;
	private String name;
	private int price;
	private int amount;
	
	public Product(int code, String name, int price, int amount) {
		this.code = code;
		this.name = name;
		this.price= price;
		this.amount = amount;
	}
	
	public Product() {
		super();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String toString(int code, String name, int price, int amount) {
		return "상품코드: "+code+"상품명: "+name+" 상품가격: "+price+" 수량: "+amount;
	}

}
