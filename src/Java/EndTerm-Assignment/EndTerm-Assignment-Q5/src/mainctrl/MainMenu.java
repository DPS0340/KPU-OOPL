package mainctrl;

import java.util.Scanner;

public abstract class MainMenu {
	static int issueMenu(Scanner scanner) {
		System.out.println(" << �� �� �� �� >>");
		System.out.println(" 1. �л� ��� �߰�");
		System.out.println(" 2. �л� ��� ��� ���");
		System.out.println();
		System.out.println(" 3. ���� ��� �߰�");
		System.out.println(" 4. ���� ��� ��� ���");
		System.out.println(" 5. ��� ��ȸ");
		System.out.println(" 6. ��ü ��� ��� ���");
		System.out.println();
		System.out.println(" 0. ����");
		System.out.println("----------------------------------");
		System.out.printf("�޴� ��ȣ? >>");
		int res = scanner.nextInt();
		return res;
	}
}
