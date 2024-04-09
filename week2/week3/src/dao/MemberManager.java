package dao;

import java.util.ArrayList;

import classes.Member;

public class MemberManager {
	private ArrayList members = new ArrayList();
	private int index = 0;
	
	public void addMember(Member member) {
		this.members.get(index++);
	}
	
	public ArrayList getMembers() {		
		return this.members;
	}
	
	public int getIndex() {
		return this.index;
	}
	
}
