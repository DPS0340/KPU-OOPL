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
			System.out.println("���α׷� ����");
			return false;
		case 1:
			System.out.println("<1. �л� �߰�>");
			return true;
		case 2:
			System.out.println("<2. �л� ��� ���>");
			return true;
		case 3:
			System.out.println("<3. ���� �߰�>");
			return true;
		case 4:
			System.out.println("<4. ���� ��� ���>");
			return true;
		case 5:
			System.out.println("<5. ������ ��ȸ>");
			return true;
		case 6:
			System.out.println("<6. ��� ������ ��� ���>");
			return true;
		case 7:
			System.out.println("<7. Ŭ���� �߰�>");
			return true;
		case 8:
			System.out.println("<8. Ŭ���� ��� ���>");
			return true;
		case 9:
			System.out.println("<9. Ŭ������ ������ �߰�>");
			return true;
		case 10:
			System.out.println("<10. Ŭ���� ���� ���� ���>");
			return true;
		case 11:
			System.out.println("<11. ��� Ŭ���� ���� ���� ���>");
			return true;
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
			return true;
		}
	}
}
