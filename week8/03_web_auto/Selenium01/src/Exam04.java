import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam04 {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5500/week8/03_web_auto/Selenium01/src/selenium01.html");
//		
		driver.findElement(By.id("pop")).click();
		
		String defaultContent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		
		for(String window : windows) {
			if(!window.equals(defaultContent)) {
				//디폴트 컨텐츠가 윈도우 같지않을때
				driver.switchTo().window(window);
			}
		}
		driver.findElement(By.id("txt")).sendKeys("테스트 확인");
		
//		driver.getWindowHandle(); //브라우저 창의 핸들주소
//		System.out.println(driver.getWindowHandles().size());
		
		Thread.sleep(5000);
		driver.quit();
	}

}
