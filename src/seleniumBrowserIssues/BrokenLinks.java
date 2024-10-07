package seleniumBrowserIssues;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']//a"));
		SoftAssert softAssert = new SoftAssert();

		for (int i = 0; i < links.size(); i++) {

			String urlString = links.get(i).getAttribute("href");
			// Create URI instance
			URI uri = new URI(urlString);
			// Convert URI to URL
			URL url = uri.toURL();
			// open connection
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// Set Req method to HEAD
			conn.setRequestMethod("HEAD");
			// Establish Connection
			conn.connect();
			// Fetch Response code
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			softAssert.assertTrue(respCode < 402,
					"The link with Text " + links.get(i).getText() + " is broken with response code " 
							+ respCode);
		}
		softAssert.assertAll();
		driver.close();
	}
}
