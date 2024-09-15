package seleniumIntro;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingJStoSendkeys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		
		String name = "aswin";
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.getElementById('inputUsername').value='" + name + "';");
		js.executeScript("document.getElementById('inputUsername').value='aswin.k';");

	}

}
