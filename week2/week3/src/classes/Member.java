package classes;

public class Member {
	private int id;
	private String name;
	private double point;
	
	public Member() {
		super();
	}
	public Member(int id, String name, double point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPoint() {
		return point;
	}
	
	
}
