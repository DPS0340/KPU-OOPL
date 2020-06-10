import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		ContactManager contactManager = new ContactManager(50);
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
			case 0:
				return;
			default:
				break;
			}
		}
	}
}
