package mainctrl;

import member.Student;
import team.Team;

public class MainCtrl {
	public static void main(String[] args) {
		Student student = new Student(1, "ȫ�л�", new Team(1, "��ħ�̴�"), "����Ʈ����", 1);
		student.showFormat();
	}
}
