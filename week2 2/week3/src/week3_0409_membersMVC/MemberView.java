package week3_0409_membersMVC;

import java.util.ArrayList;

public class MemberView {
	
	ArrayList<Member> member = new ArrayList<Member>();
	public MemberView() {
		super();
	}
	public MemberView(ArrayList<Member> member) {
		this.member = member;
	}

	public String showWarning() {
		return "잘못된 입력입니다.";
	}
	
	public String showApprove() {
		return "잘못된 입력입니다.";
	}


	public String showMenu() {
		String menu = "<<회원 관리 시스템>>" + "1. 신규 회원 등록" + "\n" + "2. 회원 목록 출력" + "\n" + "3. 회원 정보 수정" + "\n"
				+ "4. 회원 정보 삭제" + "\n" + "0. 시스템 출력";
		return menu;
	}
	public String showMemberInfo(ArrayList memberInfo) {
		String info = "";
		for(int i=0; i<member.size(); i++) {
			info = memberInfo.get(i).toString();
		}
		return info;
	}

}
