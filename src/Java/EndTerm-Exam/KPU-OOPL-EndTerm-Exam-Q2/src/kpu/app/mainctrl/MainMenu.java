package kpu.app.mainctrl;

import java.util.Scanner;

public class MainMenu {
	static int showMenu(Scanner scanner) {
		System.out.println(" << �� �� �� �� >>");
		System.out.println(" 1. �л� �߰�");
		System.out.println(" 2. �л� ��� ���");
		System.out.println("");
		System.out.println(" 3. ���� �߰�");
		System.out.println(" 4. ���� ��� ���");
		System.out.println("");		
		System.out.println(" 5. ������ ��ȸ");
		System.out.println(" 6. ��� ������ ��� ���");
		System.out.println("");
		System.out.println(" 7. Ŭ���� �߰�");
		System.out.println(" 8. Ŭ���� ��� ���");
		System.out.println("");
		System.out.println(" 9. Ŭ������ ������ �߰�");
		System.out.println(" 10. Ŭ���� ���� ���� ���");
		System.out.println(" 11. ��� Ŭ���� ���� ���� ���");
		System.out.println("");
		System.out.println(" 0. ����");
		System.out.println("-------------------");
		System.out.printf("�޴� ��ȣ? >>");
		int res = scanner.nextInt();
		return res;
	}
}
