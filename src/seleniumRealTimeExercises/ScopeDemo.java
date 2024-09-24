package seleniumRealTimeExercises;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScopeDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Get count of URLs within Webpage
		List<WebElement> urlsCount = driver.findElements(By.tagName("a"));
		System.out.println(urlsCount.size());

		// Get count of urls/links in footer-section only
		WebElement footerDriver = driver.findElement(By.cssSelector("#gf-BIG"));
		// Create a local driver for footer section
		List<WebElement> footerUrlsCount = footerDriver.findElements(By.tagName("a"));
		System.out.println(footerUrlsCount.size());

		// Get the links from Column1 in footer
		WebElement column1Driver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> column1UrlCount = column1Driver.findElements(By.tagName("a"));
		System.out.println(column1UrlCount.size());

		// Open each link
		for (int i = 1; i < column1UrlCount.size(); i++) {

			// For keyboard actions, use Keys.Chord to hold control button and click on each
			// link
			WebElement link = wait.until(ExpectedConditions.elementToBeClickable(column1UrlCount.get(i)));
			link.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
		}
		
		//Print page Titles
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			String title = driver.switchTo().window(it.next()).getTitle();
			System.out.println(title);
			driver.close();

		}

	}

}
