package seleniumWebPageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class End2EndTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// Create class object to call methods
		End2EndTesting fullTest = new End2EndTesting();

		fullTest.radioButton(driver);
		fullTest.cityNames(driver);
		fullTest.date(driver);
		fullTest.passengerCount(driver);
		fullTest.currencyType(driver);
		fullTest.passengerType(driver);
		fullTest.searchFlights(driver);
	}

	// Radio button to select type of trip
	public void radioButton(WebDriver driver) {
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click(); // Click One-way radio button
	}

	public void cityNames(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value = 'MAA']"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='HYD']"))).click();
	}

	public void date(WebDriver driver) {
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
	}

	public void passengerCount(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.id("divpaxinfo")).click();

		for (int i = 0; i < 4; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt"))).click();
		}
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult"); // Validation Step
		driver.findElement(By.id("btnclosepaxoption")).click();
	}

	public void currencyType(WebDriver driver) {
		// When there is select tag in HTML, we can use Select Class to access the
		// dropdown.
		// First get the address of drop-down and pass it to Select class object

		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		// Create an object for Select class and pass the drop-down address
		Select select = new Select(dropdown);
		select.selectByVisibleText("USD"); // Select with visible text
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "USD"); // Validation-Should pass
	}

	public void passengerType(WebDriver driver) {
		driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
	}

	public void searchFlights(WebDriver driver) {
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}
}
