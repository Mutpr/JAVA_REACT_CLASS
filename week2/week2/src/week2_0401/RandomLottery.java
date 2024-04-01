package week2_0401;

import java.util.Arrays;

public class RandomLottery {

	public static void main(String[] args) {
		int tmp = 0;
		int [] LotteryArray = new int [45];
		
		for(int i=0; i<LotteryArray.length; i++) {
			for(int j=0; j<i; j++) {
				LotteryArray[i] = (int) (Math.random()*45)+1;
				LotteryArray[j] = (int) (Math.random()*45)+1;
				if(LotteryArray[i] == LotteryArray[j]) {
					tmp = LotteryArray[i];
					LotteryArray[i] = LotteryArray[j];
					LotteryArray[j] = tmp;
				}
			}
		}
		for(int i = 0; i<7; i++) {
			System.out.println(LotteryArray[i]);
		}
	}

}
