package kpu.app.mainctrl;

import java.util.Scanner;

public class MainCtrl {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			int res = MainMenu.showMenu(scanner);
			boolean choiced = choice(res);
			if(!choiced) {
				return;
			}
		}
	}
	public static boolean choice(int res) {
		switch (res) {
		case 0:
			System.out.println("프로그램 종료");
			return false;
		case 1:
			System.out.println("<1. 학생 추가>");
			return true;
		case 2:
			System.out.println("<2. 학생 목록 출력>");
			return true;
		case 3:
			System.out.println("<3. 교수 추가>");
			return true;
		case 4:
			System.out.println("<4. 교수 목록 출력>");
			return true;
		case 5:
			System.out.println("<5. 구성원 조회>");
			return true;
		case 6:
			System.out.println("<6. 모든 구성원 목록 출력>");
			return true;
		case 7:
			System.out.println("<7. 클래스 추가>");
			return true;
		case 8:
			System.out.println("<8. 클래스 목록 출력>");
			return true;
		case 9:
			System.out.println("<9. 클래스별 구성원 추가>");
			return true;
		case 10:
			System.out.println("<10. 클래스 구성 내용 출력>");
			return true;
		case 11:
			System.out.println("<11. 모든 클래스 구성 내용 출력>");
			return true;
		default:
			System.out.println("잘못된 입력입니다.");
			return true;
		}
	}
}
