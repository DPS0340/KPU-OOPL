public class ContactManager {
	Contact[] ContactArr;
	int index;
	int max_len;
	public ContactManager(int n) {
		ContactArr = new Contact[n];
		max_len = n;
		index = 0;
	}
	
	public int nextIndex() {
		return index + 1;
	}
	public void addContact(Contact elem) {
		if(index >= max_len) {
			return;
		}
		ContactArr[index++] = elem;
	}
	public void showAll() {
		System.out.println("-----------------------------------");
		System.out.println("이름            이메일                그룹");
		System.out.println("-----------------------------------");
		for(int i=0;i<index;i++) {
			ContactArr[i].showData();			
		}
		System.out.println("-----------------------------------");
	}
	
	public int getIndex() {
		return index;
	}
	
	
}
