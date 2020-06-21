package group;

public class GManager {
	Group[] arr;
	int index;
	int length;
	
	public GManager(int length) {
		this.length = length;
		arr = new Group[length];
		index = 0;
	}
	
	public void insert(Group group) {
		if(index + 1 >= length) {
			return;
		}
		arr[index++] = group;
	}
	
	public Group getGroupByIdx(int idx) {
		if(index <= idx - 1) {
			return null;
		}
		return arr[idx - 1];
	}
	
	public int getNextInt() {
		return index + 1;
	}
	
	public void showAll() {
		System.out.println("---------------------");
		System.out.println("Group ID     이름");
		System.out.println("---------------------");
		for(int i=0;i<index;i++) {
			System.out.println(String.format("%d    %s", i+1, arr[i].getName()));
		}
		System.out.println("---------------------");
	}
}
