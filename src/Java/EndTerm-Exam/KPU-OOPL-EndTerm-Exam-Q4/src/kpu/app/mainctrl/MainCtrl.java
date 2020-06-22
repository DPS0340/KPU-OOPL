package kpu.app.mainctrl;

import java.util.Scanner;

import kpu.member.MemberList;
import kpu.member.Professor;
import kpu.member.Student;

public class MainCtrl {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MemberList memberList = new MemberList(50);
		memberList.insert(new Student(memberList.getNextIndex(), "ȫ�л�", "����Ʈ����", 3));
		memberList.insert(new Student(memberList.getNextIndex(), "���л�", "���Ӱ���", 2));
		memberList.insert(new Student(memberList.getNextIndex(), "���л�", "��ǻ�Ͱ���", 1));
		memberList.insert(new Professor(memberList.getNextIndex(), "ȫ����", "Computer"));
		memberList.insert(new Professor(memberList.getNextIndex(), "�ڱ���", "Software"));

		while(true) {
			int res = MainMenu.showMenu(scanner);
			boolean choiced = choice(res, scanner, memberList);
			if(!choiced) {
				return;
			}
		}
	}
	public static boolean choice(int res, Scanner scanner, MemberList memberList) {
		switch (res) {
		case 0:
			System.out.println("���α׷� ����");
			return false;
		case 1:
			System.out.println("<1. �л� �߰�>");
			memberList.insertStudentByUserInput(scanner);
			return true;
		case 2:
			System.out.println("<2. �л� ��� ���>");
			memberList.showStudents();
			return true;
		case 3:
			System.out.println("<3. ���� �߰�>");
			memberList.insertProfessorByUserInput(scanner);
			return true;
		case 4:
			System.out.println("<4. ���� ��� ���>");
			memberList.showProfessors();
			return true;
		case 5:
			System.out.println("<5. ������ ��ȸ>");
			System.out.println("�̱���");
			return true;
		case 6:
			System.out.println("<6. ��� ������ ��� ���>");
			System.out.println("�̱���");
			return true;
		case 7:
			System.out.println("<7. Ŭ���� �߰�>");
			System.out.println("�̱���");
			return true;
		case 8:
			System.out.println("<8. Ŭ���� ��� ���>");
			System.out.println("�̱���");
			return true;
		case 9:
			System.out.println("<9. Ŭ������ ������ �߰�>");
			System.out.println("�̱���");
			return true;
		case 10:
			System.out.println("<10. Ŭ���� ���� ���� ���>");
			System.out.println("�̱���");
			return true;
		case 11:
			System.out.println("<11. ��� Ŭ���� ���� ���� ���>");
			System.out.println("�̱���");
			return true;
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
			return true;
		}
	}
}
