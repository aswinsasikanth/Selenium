package seleniumIntro;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		//maximize a widnow
		driver.manage().window().maximize();
		driver.navigate().to("https://gmail.com");
		driver.navigate().back();
		driver.navigate().forward();

	}

}
