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

		// Using id, name and class name
		driver.findElement(By.id("inputUsername")).sendKeys("aswin");
		driver.findElement(By.name("inputPassword")).sendKeys("aswin");
		driver.findElement(By.className("signInBtn")).click();

		// Using CSS selector
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='error']")));
		System.out.println(element.getText());

		// Using Linked text. Use it only with anchor tag
		driver.findElement(By.linkText("Forgot your password?")).click();

		// Using xpath + with index
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Aswin");
		driver.findElement(By.xpath("//input[@type = 'text'][2]")).sendKeys("sasikanthh@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9052509996");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".reset-pwd-btn"))).click();
		
		//Extracting password text
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		//Login again with password
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys("aswin");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		Thread.sleep(1000);
		driver.findElement(By.id("chkboxOne")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();


		//		driver.close();

	}

}
