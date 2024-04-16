package week3_0409_Melon;

import java.util.ArrayList;

//제목으로 검색, id로 삭제
public class MelonManager {
//데이터 저장을 위한 컬렉션 하나 필요
//crud (dao에서 검색을 수행하고 남은 결과만 메인으로!)
	int index = 0;
	ArrayList<Melon> musicList = new ArrayList<Melon>();

	public int idSetting() {
		return index;
	}

	public void createMusicList(Melon musicInfo) {
		System.out.println("인덱스: " + index);
		musicInfo.setId(index);
		System.out.println(musicInfo.getSinger());
		musicList.add(index++, musicInfo);
	}

	public void getMusicList() {
	    for (Melon melon : musicList) {
	        System.out.println(melon.getId());
	        System.out.println(melon.getTitle());
	        System.out.println(melon.getSinger());
	        System.out.println(melon.getAuthor());
	    }
	}

	
	public Melon getMusicAsTitle(String title) {
		for(Melon melon: musicList) {
			if(melon.getTitle().contains(title)) {
				return melon;
			}
		}return null;
	}

	public void deleteMusicInfo(int id) {
		for (int i = 0; i < musicList.size(); i++) {
			if (musicList.get(i).getId() == id) {
				musicList.remove(i);
				return; //지울때 기준점이 아이디라서 브레이크로 나가주는게 좋음
				//remove에서 object를 넣어도 됨!(ex) musicList.remove(dto)
				//boolean을 리턴함
			} else {
				System.out.println("찾으시는 음악이 없습니다. 다시 확인해주세요.");
			}
		}

	}

	public Melon searchMusicList(String title) {
	    for (Melon melon : musicList) {
	        if (melon.getTitle().equalsIgnoreCase(title.trim())) {
	        	System.out.println(""+melon.getSinger());
	            return melon;
	        }
	    }
	    System.out.println("찾으시는 음악이 없습니다.");
	    return null;
	}

	public void updateMusicInfo(Melon melon, int index) {
		musicList.set(index, melon);
	}

	public boolean musicInfoValidation(ArrayList<Melon> musicList) {
		for (Melon melon : musicList) {
			for (int j = 0; j < musicList.size(); j++) {
				if (!melon.getTitle().equals(musicList.get(j).getTitle())) {
					return false;
				} else {
					return true;
				}

			}
		}
		return false;
	}
}
