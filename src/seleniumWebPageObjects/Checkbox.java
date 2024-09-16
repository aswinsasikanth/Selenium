package seleniumWebPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement checkbox = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));//xapth = //input[contains(@id, 'SeniorCitizenDiscount')]
		//System.out.println(checkbox.isSelected());
		Assert.assertFalse(checkbox.isSelected());
		checkbox.click();
		//System.out.println(checkbox.isSelected());
		Assert.assertFalse(checkbox.isSelected());
		
		System.out.println(driver.findElements(By.xpath("//*[@type='checkbox']")).size());
		

	}

}
