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

	public Student(int code, String name, int kr, int en, int math) {
		this.code = code;
		this.en = en;
		this.kr = kr;
		this.name = name;
		this.math = math;
	}

	public Student(int code) {
		this.code = code;
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
		if (code != 0 || name.equals("")) {
			return "학번: " + code + " 이름: " + name + " 국어: " + kr + " 영어: " + en + " 수학: " + math + " 합계: "
					+ plus(math, en, kr) + " 평균: " + avg(math, en, kr);
		} else {
			return "";
		}

	}

	public int plus(int math, int en, int kr) {
		int answer = math + en + kr;
		return answer;
	}

	public double avg(int math, int en, int kr) {
		double answer = (double) math + en + kr / 3;
		return answer;
	}

	public void studentDeletion(Student[] deleteStudent, String student) {
		System.out.println("삭제할 학생의 학번 또는 이름을 입력해주세요.");
		int studentCode = Integer.parseInt(student);
		for (int i = 0; i < deleteStudent.length; i++) {
			if (deleteStudent[i].getCode() == studentCode && deleteStudent[i].getCode() == 0) {
				try {
					int code = 0;
					String name = "";
					int kr = 0;
					int en = 0;
					int math = 0;
					if (code == 0) {
						System.out.println("이미 삭제된 학생정보입니다.");
					}
				} catch (Exception e) {
					for (int j = 0; j < deleteStudent.length; j++) {
						if (deleteStudent[i].getName().equals(student)) {
							int code = 0;
							String name = "";
							int kr = 0;
							int en = 0;
							int math = 0;
						}
					}
				}
			}
		}

	}
}
