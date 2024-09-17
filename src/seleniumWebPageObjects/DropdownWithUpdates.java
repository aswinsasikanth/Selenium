package seleniumWebPageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;


public class DropdownWithUpdates {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.id("divpaxinfo")).click();
		
//		Thread.sleep(1000);
		for (int i = 0; i<4;i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt"))).click();
//			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
//		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");  //Validation Step
		driver.findElement(By.id("btnclosepaxoption")).click();

	}

}
