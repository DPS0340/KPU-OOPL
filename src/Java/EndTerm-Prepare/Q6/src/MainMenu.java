import java.util.Scanner;

public class MainMenu {
	static int IssueMenu(Scanner scanner) {		
		System.out.println("------메 뉴------");
		System.out.println("1. 연락처(사람) 추가");
		System.out.println("2. 연락처(회사) 추가");
		System.out.println("3. 연락처 조회");
		System.out.println("4. 연락처 목록 출력");
		System.out.println("5. 연락처 그룹 추가");
		System.out.println("6. 연락처 그룹 목록 출력");
		System.out.println("0. 종료");
		System.out.println("---------------");
		System.out.printf(">>");
		if(scanner.hasNextInt()) {
			int res = scanner.nextInt();
			return res;
		}
		return 0;
	}
	
	static void addPerson(Scanner scanner, ContactManager contactManager, ContactGroupManager contactGroupManager) {
		String name, email;
		int groupID;
		ContactGroup group = null;
		System.out.println("<<연락처 정보입력>>");
		System.out.printf("  - 이름: ");
		name = scanner.next();
		System.out.printf("  - 이메일: ");
		email = scanner.next();
		contactGroupManager.showAll();
		System.out.printf("  - 그룹: ");
		groupID = scanner.nextInt();
		group = contactGroupManager.findGroupByID(groupID);
		if(group == null) {
			System.out.println("그룹을 찾지 못했습니다!");
			return;
		}
		Contact contact = new Person(name, email, group);
		contactManager.addContact(contact);
		System.out.println(String.format("   >> %s %s 추가 성공...", group.getName(), name));
		return;
	}
	
	static void addCompany(Scanner scanner, ContactManager contactManager, ContactGroupManager contactGroupManager) {
		String name, email, city;
		int groupID;
		ContactGroup group = null;
		System.out.println("<<연락처 정보입력>>");
		System.out.printf("  - 이름: ");
		name = scanner.next();
		System.out.printf("  - 이메일: ");
		email = scanner.next();
		contactGroupManager.showAll();
		System.out.printf("  - 그룹: ");
		groupID = scanner.nextInt();
		group = contactGroupManager.findGroupByID(groupID);
		if(group == null) {
			System.out.println("그룹을 찾지 못했습니다!");
			return;
		}
		System.out.printf("  - 도시: ");
		city = scanner.next();
		Contact contact = new Company(name, email, group, city);
		contactManager.addContact(contact);
		System.out.println(String.format("   >> %s %s 추가 성공...", group.getName(), name));
		return;
	}
	
	static void addGroup(Scanner scanner, ContactGroupManager contactGroupManager) {
		int id;
		String name;
		System.out.println("<<연락처 그룹 정보 입력>>");
		id = contactGroupManager.getNextIndex();
		System.out.printf("  - 그룹 ID: %d\n", id);
		System.out.printf("  - 이름: ");
		name = scanner.next();
		ContactGroup group = new ContactGroup(id, name);
		contactGroupManager.insert(group);
		System.out.println(String.format(">> %s: 그룹 추가 성공...", name));
	}
}
