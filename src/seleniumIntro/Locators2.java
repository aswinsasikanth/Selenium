package seleniumIntro;

import java.security.PublicKey;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		Locators2 login = new Locators2();
		String password = login.getPassword(driver, wait);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		

		String name = "aswin";
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		Thread.sleep(1000);
		Thread.sleep(1000);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		String text = driver.findElement(By.tagName("p")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + name + ",");

		driver.findElement(By.cssSelector(".logout-btn")).click();

	}

	public String getPassword(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.linkText("Forgot your password?")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".reset-pwd-btn"))).click();
		Thread.sleep(2000);
		String passwordMsg = driver.findElement(By.cssSelector("form p")).getText();
		String[] passArray = passwordMsg.split("'");
		String password = passArray[1].split("'")[0];
		System.out.println(password);
		return password;
	}

}
