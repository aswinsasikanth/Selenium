package seleniumActionsAndFrames;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		
		String data = driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(data);
		String splitByAt = data.split("@")[1];
		String password = splitByAt.split("\\.")[0].trim();
		
		driver.switchTo().window(parentID);
		driver.findElement(By.cssSelector("#username")).sendKeys(password);

	}

}
