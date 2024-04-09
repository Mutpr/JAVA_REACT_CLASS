package week3_0409_Melon;

import java.util.ArrayList;
import java.util.Scanner;

public class MelonMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MelonManager manager = new MelonManager();
		ArrayList<Melon> musicList = new ArrayList<Melon>();
		int id = manager.idSetting();
		;

		MelonView view = new MelonView();
		while (true) {
			System.out.print(view.showMenu());
			String menu = sc.nextLine();
			try {
				int menuSelect = Integer.parseInt(menu);
				if (menuSelect == 1) {

					System.out.println(id);
					insertion: while (true) {
						System.out.println("제목을 입력해주세요.");
						String title = sc.nextLine();
						System.out.println("가수를 입력해주세요.");
						String singer = sc.nextLine();
						System.out.println("작곡가를 입력해주세요.");
						String author = sc.nextLine();
						manager.createMusicList(new Melon(id, title, singer, author));
						System.out.println("입력을 계속하시려면 1번을, 종료하려면 0번을 눌러주세요.");
						String overSignal = sc.nextLine();
						try {
							int over = Integer.parseInt(overSignal);
							if (over == 1) {
								continue insertion;
							} else if (over == 0) {
								break insertion;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				if (menuSelect == 2) {
					manager.getMusicList();
				}
				if (menuSelect == 3) {
					System.out.println("제목을 입력해주세요.");
					String title = sc.nextLine();
					Melon foundMelon = manager.getMusicAsTitle(title);
					System.out.println("멜론멜론멜론: "+foundMelon.getTitle());
					System.out.println("멜론멜론멜론: "+foundMelon.getSinger());
				}
				if (menuSelect == 4) {
					String selectMusicId = sc.nextLine();
					try {
						int musicId = Integer.parseInt(selectMusicId);
						manager.deleteMusicInfo(musicId);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("숫자로 입력해주세요.");
					}

				}
				if (menuSelect == 5) {
					String musicIdInput = sc.nextLine();
					try {
						int musicId = Integer.parseInt(musicIdInput);
						System.out.println("제목을 입력해주세요.");
						String title = sc.nextLine();
						System.out.println("가수를 입력해주세요.");
						String singer = sc.nextLine();
						System.out.println("작곡가를 입력해주세요.");
						String author = sc.nextLine();
						manager.updateMusicInfo(new Melon(id, title, singer, author), musicId);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("숫자로 입력해주세요.");
					}
				}
				if (menuSelect == 0) {
					System.out.println("종료합니다.");
					System.exit(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("숫자로 입력해주세요.");
			}

		}

	}

}
