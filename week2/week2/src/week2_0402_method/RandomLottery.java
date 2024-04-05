package week2_0402_method;

import java.util.Arrays;

public class RandomLottery {

	public static void main(String[] args) {
		int tryCount = 0;
		int tmp = 0;
		int tmp2 = 0;
		int[] lotteryArray = new int[45];
		int[] matchLotteryArray = new int[45];
		for (int i = 0; i < lotteryArray.length; i++) {
			for (int j = 0; j < i; j++) {
				matchLotteryArray[i] = (int) ((Math.random() * 45) + 1);
				matchLotteryArray[j] = (int) ((Math.random() * 45) + 1);
				if (matchLotteryArray[i] == matchLotteryArray[j]) {
					tmp2 = matchLotteryArray[i];
					matchLotteryArray[i] = matchLotteryArray[j];
					matchLotteryArray[j] = tmp2;
				}
			}
			
		}
		while (true) {

			for (int i = 0; i < lotteryArray.length; i++) {
				for (int j = 0; j < i; j++) {
					lotteryArray[i] = (int) (Math.random() * 45) + 1;
					lotteryArray[j] = (int) (Math.random() * 45) + 1;
					if (lotteryArray[i] == lotteryArray[j]) {
						tmp = lotteryArray[i];
						lotteryArray[i] = lotteryArray[j];
						lotteryArray[j] = tmp;
					}
				}
			}
			System.out.println(tryCount + " 번째 도전: ");
			for (int i = 0; i < 4; i++) {
				System.out.print("(" + lotteryArray[i] + ")");
				
			}

			System.out.println();
			tryCount++;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (lotteryArray[j] == matchLotteryArray[i]) {
					System.out.print("(" + matchLotteryArray[i] + ")");
					break;
				}
			}
		}

	}
		
	}
	}
