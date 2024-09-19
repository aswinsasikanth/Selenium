package seleniumEcomGreenkart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String[] itemNeeded = { "Cucumber", "Beans", "Musk Melon", "Carrot", "Mango" };
		int count = 0;
		// Get all the product names and store in a list
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));

		// Extract each product and add matched product to cart
		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText().split("-")[0].trim();
		//Check whether name you extracted in present in array or not
		//Convert array to array list
			List itemsNeededList = Arrays.asList(itemNeeded);
			if(itemsNeededList.contains(name)) {
				// Add to the cart
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				count++;
				if(count==itemsNeededList.size()) break;
			}
		}

	}

}
