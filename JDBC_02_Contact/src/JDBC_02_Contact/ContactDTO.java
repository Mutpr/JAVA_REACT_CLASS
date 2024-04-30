package JDBC_02_Contact;

public class ContactDTO {
	private int id;
	private String name;
	private String phone;
	
	public ContactDTO() {
		super();
	}
	
	public ContactDTO(int id,String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	
	public ContactDTO(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
