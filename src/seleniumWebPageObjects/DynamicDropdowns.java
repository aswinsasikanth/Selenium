package seleniumWebPageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicDropdowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		DynamicDropdowns run = new DynamicDropdowns();
		run.anotherWay(driver);
//		run.oneWay(driver);

	}

	public void oneWay(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value = 'MAA']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@value = 'BLR'])[2]"))).click();
	}
	
	//Another way without using IDs. Traverse from Parent-Child
	public void anotherWay(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value = 'MAA']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='HYD']"))).click();
	}
	

}
