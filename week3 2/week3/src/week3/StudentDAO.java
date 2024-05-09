package week3;

import java.util.ArrayList;

public class StudentDAO {
	
	public StudentDAO() {
		super();
	}
	
	private int index = 0;
	private ArrayList<Student> studentList = new ArrayList<Student>();

	public int idSetting() {
		return index;
	}
	
	//Create
	public void createStudentList(Student musicInfo) {
		studentList.add(index++,musicInfo);
	}
	
	public ArrayList<Student> readStudentList(ArrayList<Student> studentList){
		return studentList;
	}

	public ArrayList<Student> updateStudentList(Student updatedStudentInfo){
		studentList.set(index, updatedStudentInfo);
		return studentList;
	}
	
	public void deleteStudent(int id) {
		for(Student student: studentList) {
			if(student.getId() == id) {
				studentList.remove(id);
			}else {
				System.out.println("경고! 이런 사용자는 존재하지 않습니다.");
			}
		}

	}
	
	public Student searchByName(String name) {
		for(Student student: studentList) {
			if(student.getName().contains(name)) {
				return student;
			}
		}return null;
	}
	//
	//
}
