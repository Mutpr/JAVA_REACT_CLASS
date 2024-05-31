import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam03 {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5500/week8/03_web_auto/Selenium01/src/selenium01.html");
		
		driver.findElement(By.id("pop")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("txt")).sendKeys("ABC");
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

}
