
public class ContactGroupManager {
	ContactGroup[] arr;
	int index;
	int max_len;
	public ContactGroupManager() {
		
	}
	public ContactGroupManager(int length) {
		arr = new ContactGroup[length];
		max_len = length;
	}
	public boolean insert(ContactGroup elem) {
		if(index >= max_len) {
			return false;
		}
		arr[index++] = elem;
		return true;
	}
	public int getNextIndex() {
		return index + 1;
	}
	public void showAll() {
		System.out.println("--------------------------------");
		System.out.println("Group ID      Group ¿Ã∏ß");
		System.out.println("--------------------------------");
		for(int i=0;i<index;i++) {
			arr[i].showData();
		}
		System.out.println("--------------------------------");

	}
}
