import java.util.Scanner;

public class MainMenu {
	static int IssueMenu(Scanner scanner) {		
		System.out.println("------메 뉴------");
		System.out.println("1. 연락처 추가");
		System.out.println("2. 연락처 목록 출력");
		System.out.println("0. 종료");
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
		System.out.println("<<연락처 정보입력>>");
		System.out.printf("  - 이름: ");
		name = scanner.next();
		System.out.printf("  - 이메일: ");
		email = scanner.next();
		System.out.printf("  - 그룹: ");
		group = scanner.next();
		Contact contact = new Contact(name, email, group);
		contactManager.addContact(contact);
		System.out.println(String.format("   >> %s %s 추가 성공...", group, name));
		return;
	}
}
