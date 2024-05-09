package Day_08_OO4_0405;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Product[] products = new Product[] {
				new Product(1001, "엘지그램", 1500, 12),
				new Product(1002, "삼성갤럭시북", 1500, 10),
				new Product(1003, "맥북", 200, 20)
		};
		
		for(Product i:products) {
			System.out.println("==========***=========");
			System.out.println("상품코드: "+i.getCode());
			System.out.println("이름: "+i.getName());
			System.out.println("가격: "+i.getPrice());
			System.out.println("재고: "+i.getAmount());
		}
		System.out.println("==========***========");
		
	}

}
