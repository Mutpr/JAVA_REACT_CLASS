package Day_08_OO4_0405;


//데이터 전담 관리 클래스
public class StudentManager {
	private Student[] stds = new Student[10];
	private int index = 0;
	
	public void addStudent(Student std) {
		stds[index++] = std;
		//데이터 보관을 manager가 하고있음
	}
	
	public Student[] getStds() {
		return stds;
	}
	
	public int getIndex() {
		return index;
	}
}
