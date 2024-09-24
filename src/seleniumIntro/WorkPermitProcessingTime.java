package seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WorkPermitProcessingTime {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.canada.ca/en/immigration-refugees-citizenship/services/application/check-processing-times.html");
		
		WebElement dropdown1 = driver.findElement(By.id("wb-auto-24"));
		Select select1 = new Select(dropdown1);
		select1.selectByVisibleText("Temporary residence (visiting, studying, working)");
		
		Thread.sleep(2000);
		WebElement dropdown2 = driver.findElement(By.id("wb-auto-48"));
		Select select2 = new Select(dropdown2);
		select2.selectByVisibleText("Work permit from inside Canada (initial and extension)");
		
		driver.findElement(By.cssSelector(".btn.btn-call-to-action.btn-lg.mrgn-bttm-md.btn-submit")).click();

	}

}
