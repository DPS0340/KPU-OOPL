import java.util.Scanner;

public class MainMenu {
	static int IssueMenu(Scanner scanner) {		
		System.out.println("------�� ��------");
		System.out.println("1. ����ó(���) �߰�");
		System.out.println("2. ����ó(ȸ��) �߰�");
		System.out.println("3. ����ó ��ȸ");
		System.out.println("4. ����ó ��� ���");
		System.out.println("5. ����ó �׷� �߰�");
		System.out.println("6. ����ó �׷� ��� ���");
		System.out.println("0. ����");
		System.out.println("---------------");
		System.out.printf(">>");
		if(scanner.hasNextInt()) {
			int res = scanner.nextInt();
			return res;
		}
		return 0;
	}
	
	static void addPerson(Scanner scanner, ContactManager contactManager) {
		String name, email, group;
		System.out.println("<<����ó �����Է�>>");
		System.out.printf("  - �̸�: ");
		name = scanner.next();
		System.out.printf("  - �̸���: ");
		email = scanner.next();
		System.out.printf("  - �׷�: ");
		group = scanner.next();
		Contact contact = new Person(name, email, group);
		contactManager.addContact(contact);
		System.out.println(String.format("   >> %s %s �߰� ����...", group, name));
		return;
	}
	
	static void addCompany(Scanner scanner, ContactManager contactManager) {
		String name, email, group, city;
		System.out.println("<<����ó �����Է�>>");
		System.out.printf("  - �̸�: ");
		name = scanner.next();
		System.out.printf("  - �̸���: ");
		email = scanner.next();
		System.out.printf("  - �׷�: ");
		group = scanner.next();
		System.out.printf("  - ����: ");
		city = scanner.next();
		Contact contact = new Company(name, email, group, city);
		contactManager.addContact(contact);
		System.out.println(String.format("   >> %s %s �߰� ����...", group, name));
		return;
	}
	
	static void addGroup(Scanner scanner, ContactGroupManager contactGroupManager) {
		int id;
		String name;
		System.out.println("<<����ó �׷� ���� �Է�>>");
		id = contactGroupManager.getNextIndex();
		System.out.printf("  - �׷� ID: %d\n", id);
		System.out.printf("  - �̸�: ");
		name = scanner.next();
		ContactGroup group = new ContactGroup(id, name);
		contactGroupManager.insert(group);
		System.out.println(String.format(">> %s: �׷� �߰� ����...", name));
	}
}
