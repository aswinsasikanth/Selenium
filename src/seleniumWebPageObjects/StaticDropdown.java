package seleniumWebPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//When there is select tag, we can use Select Class to access the dropdown.
		//First get the address of dropdown and pass it to Select class object
		
		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		//Create an object for Select class and pass the dropdown address
		Select select = new Select(dropdown);
		
		select.selectByVisibleText("INR");  //Select with visible text
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "INR"); //Should pass
		
		select.selectByIndex(3); //Select with Id value
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "USA"); //Should fail
		
		select.selectByValue("AED"); //Select with value
		System.out.println(select.getFirstSelectedOption().getText());
		Assert.assertEquals(select.getFirstSelectedOption(), "AED"); //Should pass
		driver.close();

	}

}
