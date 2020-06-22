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
		// 상속시 @Override
		return;
	}
	
	@Override
	public void showWithFormat() {
		System.out.println("----------------------");
		System.out.println("ID    이름      전공       학년");
		System.out.println("----------------------");
		showData();
		System.out.println("----------------------");
	}
	
}
