package kpu.app.mainctrl;

import kpu.member.Student;

public class MainCtrl {
	public static void main(String[] args) {
		Student student = new Student(1, "홍학생", "소프트웨어", 3);
		student.showWithFormat();
	}
}
