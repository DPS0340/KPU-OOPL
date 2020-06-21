package contact;

import group.GManager;

public class CManager {
	Contact[] arr;
	int index;
	int length;
	
	public CManager(int length) {
		this.length = length;
		arr = new Contact[length];
		index = 0;
	}
	
	public void insert(Contact contact) {
		if(index + 1 >= length) {
			return;
		}
		arr[index++] = contact;
	}
	
	public Contact getContactByIdx(int idx) {
		if(index <= idx) {
			return null;
		}
		return arr[idx];
	}
	
	public Contact getContactByName(String name) {
		for(int i=0;i<index;i++) {
			if(arr[i].getName().equals(name)) {
				return arr[i];
			}
		}
		return null;
	}
	
	public int getNextInt() {
		return index + 1;
	}
	
	public void showAll(GManager gManager) {
		System.out.println("---------------------");
		System.out.println("이름   이메일       그룹     주소");
		System.out.println("---------------------");
		for(int i=0;i<index;i++) {
			arr[i].showData(gManager);
		}
		System.out.println("---------------------");
	}
}
