package week3_0409_membersMVC;

import java.util.ArrayList;
public class MemberController {

	private ArrayList<Member> members = new ArrayList();
	private MemberView view = new MemberView();

	public boolean isDuplicatedMember(ArrayList<Member> memberInfo) {
		for (int i = 0; i < memberInfo.size(); i++) {
			if (memberInfo.get(i).getName().equals(memberInfo.get(i).getName())) {
				return true;
			} else {
				return false;
			}
		}return true;
	}
	
	public void memberPromotion(ArrayList<Member> allMemberInfo, ArrayList<String> promotedMemberNameList) {
		for(int i=0; i<allMemberInfo.size(); i++) {
			if(promotedMemberNameList.get(i).equals(allMemberInfo.get(i).getName())) {
				
			}
		}
	}

}
