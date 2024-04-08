package week2_0405_contactMVC;

public class ContactView {
	public ContactView() {
		super();
	}
	
	public String menuPrint() {
		String menu = "메뉴를 입력하세요."+"\n"+
				"1. 신규 연락처 등록"+"\n"
				+"2. 연락처 목록 출력"+"\n"
				+"3. 연락처 검색"+"\n"
				+"4. 연락처 삭제"+"\n"
				+"0. 종료";
		return menu;
	}public String searchMenuPrint() {
		String searchMenuPrint = "찾으시려는 분의 이름 또는 전화번호를 입력해주세요.";
		return searchMenuPrint;
	}
	
	
}
