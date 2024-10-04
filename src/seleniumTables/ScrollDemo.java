package seleniumTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		jse.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		// Sum of All elements in Columns 4 and get actualValue
		List<WebElement> values = driver.findElements(By.cssSelector("div.tableFixHead td:nth-child(4)"));

		int actualValue = 0;

		for (int i = 0; i < values.size(); i++) {
			int x = Integer.parseInt(values.get(i).getText());
			actualValue = actualValue + x;
		}
		System.out.println(actualValue);

		// Get the sum on web-page and compare with our output
		String sumValue = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
		int expectedValue = Integer.parseInt(sumValue);

		// Assert the sum and expected values
		Assert.assertEquals(actualValue, expectedValue);

	}

}
