package week2_0405_contactMVC;

public class Contact {
	private int id;
	private String name;
	private String phone;
	
	public Contact() {
		super();
	}
	public Contact(int id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
}
