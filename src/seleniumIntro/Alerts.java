package seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		driver.findElement(By.id("name")).sendKeys("Aswin");
		driver.findElement(By.id("alertbtn")).click();
		
		//Handling alerts
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().accept(); //Clicks on positivity button
		
		driver.findElement(By.id("name")).sendKeys("Aswin");
		driver.findElement(By.id("confirmbtn")).click();
		String alertMessage1 = driver.switchTo().alert().getText();
		System.out.println(alertMessage1);
		driver.switchTo().alert().dismiss(); //Clicks on negativity button

	}

}
