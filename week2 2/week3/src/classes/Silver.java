package classes;
public class Silver {
	private String id;
	private String name;
	private int point;
	
	public double getBonus(){
		return this.point * 0.02;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Silver(String id, String name, int point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}
	public Silver() {
		super();
	}
	
	
}
