package kpu.member;

import kpu.app.show.Showable;

public abstract class Member implements Showable {
	protected int id;
	protected String name;
	
	public Member(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public void showData() {
		System.out.println(String.format("%d   %s", id, name));
	}
	
	@Override
	public void showWithType() {
		// ��ӽ� @Override
		return;
	}
	
	public void showWithFormat() {
		System.out.println("----------------------");
		System.out.println("ID    �̸�      ����       �г�");
		System.out.println("----------------------");
		showData();
		System.out.println("----------------------");
	}
}
