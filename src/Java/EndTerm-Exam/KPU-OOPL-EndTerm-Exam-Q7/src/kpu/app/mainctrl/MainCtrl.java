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
		classManager.insert(new SubjectClass(classManager.getNextIndex(), "객체지향"));
		classManager.insert(new SubjectClass(classManager.getNextIndex(), "OOPL"));
		classManager.insert(new SubjectClass(classManager.getNextIndex(), "Java"));
		classManager.insert(new SubjectClass(classManager.getNextIndex(), "네트워크"));
		memberList.insert(new Student(memberList.getNextIndex(), "홍학생", "소프트웨어", 3));
		memberList.insert(new Student(memberList.getNextIndex(), "김학생", "게임공학", 2));
		memberList.insert(new Student(memberList.getNextIndex(), "박학생", "컴퓨터공학", 1));
		memberList.insert(new Professor(memberList.getNextIndex(), "홍교수", "Computer"));
		memberList.insert(new Professor(memberList.getNextIndex(), "박교수", "Software"));
		classManager.getElemByIndex(1).insert(memberList.getMemberByName("홍학생"));
		classManager.getElemByIndex(1).insert(memberList.getMemberByName("김학생"));
		classManager.getElemByIndex(1).insert(memberList.getMemberByName("홍교수"));

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
			System.out.println("프로그램 종료");
			return false;
		case 1:
			System.out.println("<1. 학생 추가>");
			memberList.insertStudentByUserInput(scanner);
			return true;
		case 2:
			System.out.println("<2. 학생 목록 출력>");
			memberList.showStudents();
			return true;
		case 3:
			System.out.println("<3. 교수 추가>");
			memberList.insertProfessorByUserInput(scanner);
			return true;
		case 4:
			System.out.println("<4. 교수 목록 출력>");
			memberList.showProfessors();
			return true;
		case 5:
			System.out.println("<5. 구성원 조회>");
			memberList.findElemByUserInput(scanner);
			return true;
		case 6:
			System.out.println("<6. 모든 구성원 목록 출력>");
			memberList.showAll();
			return true;
		case 7:
			System.out.println("<7. 클래스 추가>");
			classManager.insertClassWithUserInput(scanner);
			return true;
		case 8:
			System.out.println("<8. 클래스 목록 출력>");
			classManager.showAll();
			return true;
		case 9:
			System.out.println("<9. 클래스별 구성원 추가>");
			classManager.insertClassComponentWithUserInput(scanner, memberList);
			return true;
		case 10:
			System.out.println("<10. 클래스 구성 내용 출력>");
			classManager.showClassComponentsWithUserInput(scanner);
			return true;
		case 11:
			System.out.println("<11. 모든 클래스 구성 내용 출력>");
			classManager.showAllComponents();
			return true;
		default:
			System.out.println("잘못된 입력입니다.");
			return true;
		}
	}
}
