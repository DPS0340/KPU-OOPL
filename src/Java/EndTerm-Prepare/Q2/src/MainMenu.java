import java.util.Scanner;

public class MainMenu {
	static int IssueMenu(Scanner scanner) {		
		System.out.println("------�� ��------");
		System.out.println("1. ����ó �߰�");
		System.out.println("2. ����ó ��� ���");
		System.out.println("0. ����");
		System.out.println("---------------");
		System.out.printf(">>");
		if(scanner.hasNextInt()) {
			int res = scanner.nextInt();
			return res;
		}
		return 0;
	}
	
	static void addAddress(Scanner scanner, ContactManager contactManager) {
		String name, email, group;
		System.out.println("<<����ó �����Է�>>");
		System.out.printf("  - �̸�: ");
		name = scanner.next();
		System.out.printf("  - �̸���: ");
		email = scanner.next();
		System.out.printf("  - �׷�: ");
		group = scanner.next();
		Contact contact = new Contact(name, email, group);
		contactManager.addContact(contact);
		System.out.println(String.format("   >> %s %s �߰� ����...", group, name));
		return;
	}
}
