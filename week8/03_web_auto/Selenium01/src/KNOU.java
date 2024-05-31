import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KNOU {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://ep.knou.ac.kr/main.do");
		WebElement closeButton = driver.findElement(By.id("btn_conf"));
		closeButton.click();
		
		WebElement idInput = driver.findElement(By.id("username"));
		js.executeScript("arguments[0].value=arguments[1]", idInput, Statics.KNOU_ID);
		WebElement pwInput = driver.findElement(By.id("password"));
		js.executeScript("arguments[0].value=arguments[1]", pwInput, Statics.KNOU_PW);
		
		Thread.sleep(1000);
		
		WebElement loginBtn = driver.findElement(By.id("btn_login"));
		loginBtn.click();
		
		Thread.sleep(3000);
		
		//내 수강정보 찾기
        WebElement myInfo = driver.findElement(By.cssSelector("#menu > li.p27w113 > a > span"));
        System.out.println(myInfo.getText());
        Actions actions = new Actions(driver);
        actions.moveToElement(myInfo).perform();
        
        WebElement myClass = driver.findElement(By.className("mgT20"));
        myClass.click();
        
        Thread.sleep(3000);
        WebElement topnavi = driver.findElement(By.className("topnavi"));
        actions.moveToElement(topnavi).perform();
        //개설교과목 정보 조회
        Thread.sleep(3000);
        
        WebElement element = driver.findElement(By.xpath("//a[text()='개설교과목정보조회']"));
        element.click();
	}

}
