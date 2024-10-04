package seleniumBrowserIssues;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://google.com");
		
		//Capture screenshot and store in file object
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Extract and save it in our local machine using funtion calls FileUtils
		//From maven, copy and update pom file with common io fileutils dependencies
		FileUtils.copyFile(src, new File("D://Screenshots/screenshot1.png"));
		

	}

}
