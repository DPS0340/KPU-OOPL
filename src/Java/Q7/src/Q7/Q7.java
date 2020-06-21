package Q7;

import java.util.Scanner;

import contact.CManager;
import contact.ComplexContact;
import contact.Contact;
import contact.SimpleContact;
import group.GManager;
import group.Group;

public class Q7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CManager cManager = new CManager(50);
		GManager gManager = new GManager(50);
		cManager.insert(new SimpleContact("홍길동", "kdh@kpu.co.kr", 4));
		cManager.insert(new ComplexContact("James", "jcral@abc.com", "New York", 6));
		gManager.insert(new Group("가족"));
		gManager.insert(new Group("과친구"));
		gManager.insert(new Group("중딩친구"));
		gManager.insert(new Group("고딩친구"));
		gManager.insert(new Group("구매사"));
		gManager.insert(new Group("고객사"));
		gManager.insert(new Group("대리점"));
		int command;
		while (true) {
			showMenu();
			command = scanner.nextInt();
			String name, email, address;
			int groupID;
			Contact contact = null;
			Group group = null;
			switch (command) {
			case 1:
				System.out.println("<<1. 기본연락처 추가>>");
				System.out.println("  - 이름> ");
				name = scanner.next();
				System.out.println("  - 이메일> ");
				email = scanner.next();
				gManager.showAll();
				System.out.println("  - 그룹> ");
				groupID = scanner.nextInt();
				if(groupID >= gManager.getNextInt()) {
					System.out.println("그룹 인덱스 초과");
					break;
				}
				SimpleContact simpleContact = new SimpleContact(name, email, groupID);
				cManager.insert(simpleContact);
				System.out.println(String.format(">> %s: 기본연락처 추가 성공...", name));
				break;
			case 2:

				System.out.println("<<2. 상세연락처 추가>>");
				System.out.println("  - 이름> ");
				name = scanner.next();
				System.out.println("  - 이메일> ");
				email = scanner.next();
				System.out.println("  - 주소> ");
				address = scanner.next();
				gManager.showAll();
				System.out.println("  - 그룹> ");
				groupID = scanner.nextInt();
				if(groupID >= gManager.getNextInt()) {
					System.out.println("그룹 인덱스 초과");
					break;
				}
				ComplexContact complexContact = new ComplexContact(name, email, address, groupID);
				cManager.insert(complexContact);
				System.out.println(String.format(">> %s: 상세연락처 추가 성공...", name));
				break;
			case 3:
				System.out.println("<<3. 연락처 조회>>");
				System.out.println("  - 이름> ");
				name = scanner.next();
				contact = cManager.getContactByName(name);
				if (contact == null) {
					System.out.println("그런 연락처는 없습니다.");
				}
				System.out.println("---------------------");
				System.out.println("이름   이메일       그룹     주소");
				System.out.println("---------------------");
				contact.showData(gManager);
				System.out.println("---------------------");
				break;
			case 4:
				System.out.println("<<4. 모든 연락처 출력>>");
				cManager.showAll(gManager);
				break;
			case 5:
				System.out.println("<<5. 연락처 그룹 추가>>");
				int nextGroupID = gManager.getNextInt();
				System.out.println(String.format("  - Group ID> %d", nextGroupID));
				System.out.println("  - 이름> ");
				name = scanner.next();
				group = new Group(name);
				gManager.insert(group);
				System.out.println(String.format(">> %s: 연락처 그룹 추가 성공...", name));
				break;
			case 6:
				System.out.println("<<6. 연락처 그룹 목록 출력>>");
				gManager.showAll();
				break;
			case 0:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
	public static void showMenu() {
		System.out.println("<<출력화면 모음>>");
		System.out.println("");
		System.out.println("-----[메 뉴]-----");
		System.out.println(" 1. 기본연락처 추가");
		System.out.println(" 2. 상세연락처 추가");
		System.out.println("");
		System.out.println(" 3. 연락처 조회");
		System.out.println(" 4. 모든 연락처 출력");
		System.out.println("");
		System.out.println(" 5. 연락처 그룹 추가");
		System.out.println(" 6. 연락처 그룹 목록 출력");
		System.out.println("");
		System.out.println(" 0. 종료");
		System.out.println("---------------");
		System.out.println("선택>>");
	}
}
