package week4_review01_cafe;

import java.util.ArrayList;

public class CafeDAO {
	ArrayList<CafeDTO> menuList = new ArrayList<>();
	
	//추가
	public ArrayList<CafeDTO> addList(CafeDTO menu) {
		menuList.add(menu);
		return menuList;
	}
	
	//삭제
	public void deleteMenu(int menuIndex) {
		menuList.remove(menuIndex);
	}
	
	public ArrayList<CafeDTO> updateMenu(int menuIndex, CafeDTO menu) {
		menuList.set(menuIndex, menu);
		return menuList;
	}
	//업데이트
	
	public ArrayList<CafeDTO> readAllMenu(){
		return menuList;
	}
	
	public CafeDTO readOneMenu(String menuName) {
		for(int i=0; i<menuList.size(); i++){
			if(menuList.get(i).getMenu().equals(menuName)) {
				return menuList.get(i);
			}
		}return null;
	}
	//읽기
}
