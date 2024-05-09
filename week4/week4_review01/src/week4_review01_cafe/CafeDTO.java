package week4_review01_cafe;

public class CafeDTO {
	private String menu;
	private int price;
	
	public CafeDTO() {
		super();
	}
	
	public CafeDTO(String menu, int price) {
		this.menu = menu;
		this.price = price;
	}
	
	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	
	

}
