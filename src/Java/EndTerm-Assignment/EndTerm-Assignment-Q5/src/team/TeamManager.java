package team;

public class TeamManager {
	Team[] teamList;
	int index;
	int max_length;
	
	public TeamManager(int length) {
		index = 0;
		max_length = length;
		teamList = new Team[length];
	}
	
	public int getNextIndex() {
		return index + 1;
	}
	
	public boolean insert(Team elem) {
		if(index >= max_length) {
			return false;
		}
		teamList[index++] = elem;
		return true;
	}
	
	public Team getTeamByIndex(int idx) {
		if(idx > index) {
			return null;
		}
		return teamList[idx-1];
	}
	
	public void showAll() {
		System.out.println("-------------------");
		System.out.println("ID      Team 이름");
		System.out.println("-------------------");
		for(int i=0;i<index;i++) {
			teamList[i].show();
		}
		System.out.println("-------------------");
	}
}
