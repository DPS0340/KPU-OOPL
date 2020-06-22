package kpu.subjclass;

import kpu.member.Member;

public class SubjectClass {
	private int id;
	private String subject;
	Member[] mList;
	int index;
	public SubjectClass(int id, String subject) {
		this.id = id;
		this.subject = subject;
		this.mList = new Member[30];
		this.index = 0;
	}
	public boolean insert(Member elem) {
		if(index >= 30) {
			return false;
		}
		mList[index++] = elem;
		return true;
	}
	public int getID() {
		return id;
	}
	public String getSubject() {
		return subject;
	}
	public void showAll() {
		System.out.println("----------------------");
		System.out.println("구분    ID    이름      전공/소속       학년");
		System.out.println("----------------------");
		for(int i=0;i<index;i++) {
			mList[i].showWithType();
		}
		System.out.println("----------------------");
	}
	public Member getMemberByName(String name) {
		for(int i=0;i<index;i++) {
			if(mList[i].getName().equals(name)) {
				return mList[i];
			}
		}
		return null;
	}
	
	public void showData() {
		System.out.println(String.format("%d     %s", id, subject));
	}
}
