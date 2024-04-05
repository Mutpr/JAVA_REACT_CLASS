package Day_08_OO4_0405;

public class Student {
	private int code;
	private String name;
	private int kr;
	private int en;
	private int math;
	public Student() {
		super();
	}
	public Student(int code,String name,int kr,int en,int math) {
		this.code = code;
		this.en=en;
		this.kr=kr;
		this.name=name;
		this.math=math;
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
	public int getKr() {
		return kr;
	}
	public void setKr(int kr) {
		this.kr = kr;
	}
	public int getEn() {
		return en;
	}
	public void setEn(int en) {
		this.en = en;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String toString() {
		return "학번: "+code+" 이름: "+name+" 국어: "+kr+" 영어: "+en+" 수학: "+math+" 합계: "+plus(math, en, kr)+" 평균: "+avg(math, en, kr);
	}
	
	public int plus(int math, int en, int kr) {
		int answer = math+en+kr;
		return answer;
	}
	
	public double avg(int math, int en, int kr) {
		double answer = (double)math+en+kr/3;
		return answer;
	}
}
