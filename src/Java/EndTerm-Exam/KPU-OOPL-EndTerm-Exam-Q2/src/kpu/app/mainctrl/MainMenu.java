package kpu.app.mainctrl;

import java.util.Scanner;

public class MainMenu {
	static int showMenu(Scanner scanner) {
		System.out.println(" << 메 인 메 뉴 >>");
		System.out.println(" 1. 학생 추가");
		System.out.println(" 2. 학생 목록 출력");
		System.out.println("");
		System.out.println(" 3. 교수 추가");
		System.out.println(" 4. 교수 목록 출력");
		System.out.println("");		
		System.out.println(" 5. 구성원 조회");
		System.out.println(" 6. 모든 구성원 목록 출력");
		System.out.println("");
		System.out.println(" 7. 클래스 추가");
		System.out.println(" 8. 클래스 목록 출력");
		System.out.println("");
		System.out.println(" 9. 클래스별 구성원 추가");
		System.out.println(" 10. 클래스 구성 내용 출력");
		System.out.println(" 11. 모든 클래스 구성 내용 출력");
		System.out.println("");
		System.out.println(" 0. 종료");
		System.out.println("-------------------");
		System.out.printf("메뉴 번호? >>");
		int res = scanner.nextInt();
		return res;
	}
}
