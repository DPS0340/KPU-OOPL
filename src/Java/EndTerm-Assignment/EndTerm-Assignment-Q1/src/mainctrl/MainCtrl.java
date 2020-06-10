package mainctrl;

import member.Student;
import team.Team;

public class MainCtrl {
	public static void main(String[] args) {
		Student student = new Student(1, "홍학생", new Team(1, "아침이다"), "소프트웨어", 1);
		student.showFormat();
	}
}
