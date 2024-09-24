package seleniumActionsAndFrames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		//Switch to Frame
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		driver.findElement(By.id("draggable")).click();
		
		//Drag and Drop with Actions
		Actions action = new Actions(driver);
		//Need source and target elements to drag and drop
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(source, target).build().perform();
		
		//Return to window from frame
		driver.switchTo().defaultContent();
		
		//Alternative way to switch frames
		//Get number of frames
		List<WebElement> count = driver.findElements(By.tagName("iframe"));
		System.out.println(count.size());
		driver.switchTo().frame(1);

	}

}
