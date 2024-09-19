package seleniumEcomGreenkart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testing {
    public static void main(String[] args) {
        String[] veg = { "Cucumber", "Beans", "Musk Melon", "Carrot", "Mango" };

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Adding an explicit wait

        // Opening URL
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        for (String vegetable : veg) {
            // Wait until the element is clickable before attempting to click
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h4[contains(text(),'" + vegetable + "')]/following-sibling::div[2]/button")
            ));
            button.click();
        }
    }
}


/*
 * package seleniumEcomGreenkart;
 * 
 * import java.time.Duration; import java.util.Arrays; import java.util.List;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.support.ui.ExpectedCondition; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * public class GreenKart {
 * 
 * public static void main(String[] args) throws InterruptedException { // TODO
 * Auto-generated method stub
 * 
 * WebDriver driver = new ChromeDriver();
 * driver.get("https://rahulshettyacademy.com/seleniumPractise"); WebDriverWait
 * wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 * 
 * driver.findElements(By.cssSelector("h4.product-name"));
 * 
 * String[] productName = {"Musk", "Cucumber","Brocolli","Beetroot"}; List
 * productList = Arrays.asList(productName);
 * 
 * for(int i = 0; i<productList.size(); i++) { Thread.sleep(5000); WebElement
 * addProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//h4[contains(text(),'"+ productList.get(i)
 * +"')]/following-sibling::div[@class='product-action']/button")));
 * addProduct.click(); } }
 * 
 * }
 */
