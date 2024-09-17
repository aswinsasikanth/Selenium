package seleniumWebPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RadioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement attribute = driver.findElement(By.id("Div1"));

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click(); // Click One-way radio button
		System.out.println(attribute.getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); // Click Two-way radio button
		System.out.println(attribute.getAttribute("style"));

		if (attribute.getAttribute("style").contains("1")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		driver.close();
	}

}
