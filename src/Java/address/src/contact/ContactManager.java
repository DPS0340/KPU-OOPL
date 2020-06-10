package contact;

public class ContactManager {
	Contact[] ContactArr;
	int index;
	public ContactManager() {
		ContactArr = new Contact[50];
		index = 0;
	}
	
	public int nextIndex() {
		return index + 1;
	}
	public boolean insert(Contact elem) {
		if(index >= 50) {
			return false;
		}
		ContactArr[index++] = elem;
		return true;
	}
	
	public int getIndex() {
		return index;
	}
}
