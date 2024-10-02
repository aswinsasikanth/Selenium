package seleniumRealTimeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUIAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String monthNumber = "6";
		String date = "15";
		String year = "2027";

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click on calendar
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();

		// Click once to open Months
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		// Click again to open Years
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		// Click on desired year
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		// click on desired month
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
				.get(Integer.parseInt(monthNumber) - 1).click();
		//Click on desired date
		driver.findElement(By.xpath("//abbr[text()="+date+"]")).click();

	}

}
