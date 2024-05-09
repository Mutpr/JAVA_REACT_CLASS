package week3_0409_membersMVC;

public class Member {
	private int id;
	private String name;
	private double point;
	private int code;
	
	public Member() {
		super();
	}
public Member(int id, String name, double point, int code) {
		this.id = id;
		this.name = name;
		this.point = point;
		this.code = code;
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
	
	public int getCode() {
		return code;
	}
	
	
}
