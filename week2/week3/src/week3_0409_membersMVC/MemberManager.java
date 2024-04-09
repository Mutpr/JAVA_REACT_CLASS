package week3_0409_membersMVC;

import java.util.ArrayList;

public class MemberManager {

	private ArrayList<Member> members = new ArrayList();
	private MemberView view = new MemberView();
	MemberController memberController = new MemberController();

	public void addMember(ArrayList<Member> memberInfo) {
		if(memberController.isDuplicatedMember(memberInfo)==true) {
			this.members.addAll(memberInfo);
			view.showWarning();
		}else {
			view.showApprove();
		}
	}

	public ArrayList<Member> getAllMember(ArrayList<Member> allMemberInfo) {
		return this.members = allMemberInfo;
	}
	
	public ArrayList<Member> deleteMember(ArrayList<Member> memberList,int index, String name) {
		for(int i=0; i<memberList.size(); i++) {
			if(memberList.get(i).getName().equals(name)) {
				memberList.remove(index);
			}else {
				view.showWarning();
			}
		}

		return memberList;
	}
	
	public ArrayList<Member> updateMember(ArrayList<Member> memberList, int index, String name, double point){
		Member member=new Member(index, name, point, 0);
		for(int i=0; i<memberList.size(); i++) {
			if(memberList.get(i).getName().equals(name)) {
				memberList.set(index, member);
			}else {
				view.showWarning();
			}
		}return memberList;
	}
}
