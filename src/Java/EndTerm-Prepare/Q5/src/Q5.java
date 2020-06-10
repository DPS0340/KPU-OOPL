import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		ContactManager contactManager = new ContactManager(50);
		ContactGroupManager contactGroupManager = new ContactGroupManager(50);
		Scanner scanner = new Scanner(System.in);
		while(true) {
			int command = MainMenu.IssueMenu(scanner);
			switch (command) {
			case 1:
				MainMenu.addPerson(scanner, contactManager);
				break;
			case 2:
				MainMenu.addCompany(scanner, contactManager);
				break;
			case 3:
				contactManager.search(scanner);
				break;
			case 4:
				contactManager.showAll();
				break;
			case 5:
				MainMenu.addGroup(scanner, contactGroupManager);
				break;
			case 6:
				contactGroupManager.showAll();
				break;
			case 0:
				return;
			default:
				break;
			}
		}
	}
}
