package kpu.app.mainctrl;

import java.util.Scanner;

import kpu.member.MemberList;
import kpu.member.Professor;
import kpu.member.Student;
import kpu.subjclass.ClassManager;
import kpu.subjclass.SubjectClass;

public class MainCtrl {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MemberList memberList = new MemberList(50);
		ClassManager classManager = new ClassManager(50);
		classManager.insert(new SubjectClass(classManager.getNextIndex(), "��ü����"));
		classManager.insert(new SubjectClass(classManager.getNextIndex(), "OOPL"));
		classManager.insert(new SubjectClass(classManager.getNextIndex(), "Java"));
		classManager.insert(new SubjectClass(classManager.getNextIndex(), "��Ʈ��ũ"));
		memberList.insert(new Student(memberList.getNextIndex(), "ȫ�л�", "����Ʈ����", 3));
		memberList.insert(new Student(memberList.getNextIndex(), "���л�", "���Ӱ���", 2));
		memberList.insert(new Student(memberList.getNextIndex(), "���л�", "��ǻ�Ͱ���", 1));
		memberList.insert(new Professor(memberList.getNextIndex(), "ȫ����", "Computer"));
		memberList.insert(new Professor(memberList.getNextIndex(), "�ڱ���", "Software"));
		classManager.getElemByIndex(1).insert(memberList.getMemberByName("ȫ�л�"));
		classManager.getElemByIndex(1).insert(memberList.getMemberByName("���л�"));
		classManager.getElemByIndex(1).insert(memberList.getMemberByName("ȫ����"));

		while(true) {
			int res = MainMenu.showMenu(scanner);
			boolean choiced = choice(res, scanner, memberList, classManager);
			if(!choiced) {
				return;
			}
		}
	}
	public static boolean choice(int res, Scanner scanner, MemberList memberList, ClassManager classManager) {
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
			memberList.findElemByUserInput(scanner);
			return true;
		case 6:
			System.out.println("<6. ��� ������ ��� ���>");
			memberList.showAll();
			return true;
		case 7:
			System.out.println("<7. Ŭ���� �߰�>");
			classManager.insertClassWithUserInput(scanner);
			return true;
		case 8:
			System.out.println("<8. Ŭ���� ��� ���>");
			classManager.showAll();
			return true;
		case 9:
			System.out.println("<9. Ŭ������ ������ �߰�>");
			classManager.insertClassComponentWithUserInput(scanner, memberList);
			return true;
		case 10:
			System.out.println("<10. Ŭ���� ���� ���� ���>");
			classManager.showClassComponentsWithUserInput(scanner);
			return true;
		case 11:
			System.out.println("<11. ��� Ŭ���� ���� ���� ���>");
			classManager.showAllComponents();
			return true;
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
			return true;
		}
	}
}
