package seleniumIntro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		
		//Using id, name and class name
		driver.findElement(By.id("inputUsername")).sendKeys("aswin");
		driver.findElement(By.name("inputPassword")).sendKeys("aswin");
		driver.findElement(By.className("signInBtn")).click();
				
		//CSS selector
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='error']")));
		String errorMsg = element.getText();
		System.out.println(errorMsg);
	
	}

}
