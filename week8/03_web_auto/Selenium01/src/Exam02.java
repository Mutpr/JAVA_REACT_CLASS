import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exam02 {

	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https://www.naver.com/");
		WebElement inputId = driver.findElement(By.id("id"));
		js.executeScript("arguments[0].value=arguments[1]", inputId, Statics.NAVER_ID);
		WebElement inputPW = driver.findElement(By.id("pw"));
		js.executeScript("arguments[0].value=arguments[1]", inputPW, Statics.NAVER_PW);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement buttonLogin = driver.findElement(By.id("id, login"));
		buttonLogin.click();
		
		driver.get("https://mail.naver.com/v/folders/0/all");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("button_write_to_me")));
		
		WebElement inputTitle = driver.findElement(By.id("subject_title"));
		inputTitle.sendKeys("제목 확인");
		
		driver.switchTo().frame(5);
		
		Thread.sleep(2000);
		
		List<WebElement> list = driver.findElements(By.className("button_write_to_me"));
		System.out.println(list.size());
	}

}
