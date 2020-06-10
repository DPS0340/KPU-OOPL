package group;

public class GroupManager {
	Group[] groupArr;
	int index;
	GroupManager() {
		groupArr = new Group[50];
		index = 0;
	}
	
	public boolean insert(Group elem) {
		if(index >= 50) {
			return false;
		}
		groupArr[index++] = elem;
		return true;
	}
	
	public int nextIndex() {
		return index + 1;
	}
	
	public int getIndex() {
		return index;
	}
}
