package seleniumRealTimeExercises;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarUIAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String monthNumber = "6";
		String date = "15";
		String year = "2027";
		String[] expectedDate = {monthNumber, date, year};

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click on calendar
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();

		// Click once to open Months
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		// Click again to open Years
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		// Click on desired year
		
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		// click on desired month
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
				.get(Integer.parseInt(monthNumber) - 2).click();
		//Click on desired date
		driver.findElement(By.xpath("//abbr[text()="+date+"]")).click();
		
		//Assertions
		List<WebElement> actualDate =  driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
	    for(int i = 0; i<actualDate.size();i++) {
	    	String value = actualDate.get(i).getAttribute("value");
	    	System.out.println(value);
	    	Assert.assertEquals(value, expectedDate[i]);
	    	
	    }
	}

}
