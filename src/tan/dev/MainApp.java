package tan.dev;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainApp {
	
	// Input List
	static List<Person> input(int studentNumber, int teachernumber){
		List<Person> personList = new ArrayList<Person>();
		Scanner sc = new Scanner(System.in);
		System.out.println("=========Student===========");
		for (int i = 0; i < studentNumber; i++) {
			System.out.println("Student: Nhap vao lan luot ten,tuoi,MSSV,DiemTB:");
			String name = sc.next();
			int age = sc.nextInt();
			String idStudent = sc.next();
			float diemTrungBinh = sc.nextFloat();
			Person studentPerson = new Student(name, age, idStudent, diemTrungBinh);
			personList.add(studentPerson);
		}
		System.out.println("==========Teacher========");
		for (int i = 0; i < teachernumber; i++) {
			System.out.println("Teacher: Nhap vao lan luot ten,tuoi,MSGV,He so luong");
			String name = sc.next();
			int age = sc.nextInt();
			String idGV = sc.next();
			float heSoLuong = sc.nextFloat();
			Person teacherPersoon = new Teacher(name, age, idGV, heSoLuong);
			personList.add(teacherPersoon);	
		}
		return personList;
	}
	
	//Print
	static void print(List<Person> personList) {
		for (Person person : personList) {
			String str = person.toString();
			System.out.println(str);
		}
	}
	
	// FindMax
	static void find(List<Person> personList) {
		Iterator<Person> it = personList.iterator();
		float maxStudent = 0;
		float maxTeacher = 0;
		String preStu = personList.get(0).name;
		String preTea = personList.get(0).name;
		while (it.hasNext()) {
			Person person = it.next();
			if (person instanceof Student == true){
				Student stu;
				stu = (Student) person;
				if (stu.getDiemTrungBinh() > maxStudent) {
					maxStudent = stu.getDiemTrungBinh();
					preStu = stu.name;
				}
			}else {
				Teacher tea;
				tea = (Teacher) person;
				if (tea.getHeSoLuong() > maxTeacher) {
					maxTeacher = tea.getHeSoLuong();
					preTea = tea.name;
				}
			}
		}
		String strStudent = String.format("SV Diem cao nhat: %s -- %f",preStu,maxStudent);
		String strTeacher = String.format("GV co HSL cao nhat: %s -- %f", preTea,maxTeacher);
		System.out.println(strStudent);
		System.out.println(strTeacher);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> personList;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao so GV: ");
		int numberStudent = sc.nextInt();
		System.out.println("Nhap vao so SV: ");
		int numberTeacher = sc.nextInt();
		personList = input(numberStudent, numberTeacher);
		print(personList);
		find(personList);
	}
}
