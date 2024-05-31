import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam01 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.naver.com");
		
		WebElement searchBox = driver.findElement(By.id("query"));
		System.out.println(searchBox);
		searchBox.sendKeys("오늘 날씨");
		
		List<WebElement> list = driver.findElements(By.className("btn_search"));
		System.out.println(list.size());
		
		WebElement buttonSearch = list.get(0);
		buttonSearch.click();
		
	}
}
