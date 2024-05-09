package week3_0409_Melon;
//시각적 효과만 담당. 데이터는 절대xxxxxxxxxxxx
public class MelonView {
	
	public String showMenu() {
			String menuPrint = "* Melon 관리 시스템\n"
					+ "1. 신규 음악 등록\n"
					+ "2. 음악 목록 출력\n"
					+ "3. 음악 검색 ( 제목으로 검색 )\n"
					+ "4. 항목 삭제 ( ID로 삭제 )\n"
					+ "5. 항목 수정 ( ID로 수정 / ID를 제외한 전체 항목 수정 )\n"
					+ "0. 시스템 종료\n";
			return menuPrint;
		}
	
	public String showInfo(Melon melon) {
		String musicInfo = 
			"아이디 \t 제목 \t 가수 \t 작곡가 \t 날짜"+"\n"+
			melon.getId()+"\t"+melon.getTitle()+"\t"+melon.getSinger()+"\t"+melon.getAuthor()+"\t";
		return musicInfo;
		
		
	}
	
	
}
