package seleniumActionsAndFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector(".H6-NpN._3N4_BX"))).build().perform();

	}

}
