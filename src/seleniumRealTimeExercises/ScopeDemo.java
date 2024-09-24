package seleniumRealTimeExercises;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Get count of URLs within Webpage
		List<WebElement> urlsCount =  driver.findElements(By.tagName("a"));
		System.out.println(urlsCount.size());
		
		//Get count of urls/links in footer-section only
		WebElement footerDriver =  driver.findElement(By.cssSelector("#gf-BIG"));
		//Create a local driver for footer section
		List<WebElement> footerUrlsCount =  footerDriver.findElements(By.tagName("a"));
		System.out.println(footerUrlsCount.size());

	}

}
