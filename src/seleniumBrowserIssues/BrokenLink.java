package seleniumBrowserIssues;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		  WebElement urlString1 = driver.findElement(By.xpath("//a[contains(text(),'Appium')]"));
		  String urlString = urlString1.getAttribute("href");
		// Create a URI instance
        URI uri = new URI(urlString);
        // Convert URI to URL
        URL url = uri.toURL();
        
        // Open connection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        //set Request method HEAD
        conn.setRequestMethod("HEAD");
        
        //Establish connection
        conn.connect();
        
        //Fetch Response
        int respCode = conn.getResponseCode();
        System.out.println("This link with text "+ urlString1.getText() + " response code is " + respCode);
        
        driver.close();
	}

}
