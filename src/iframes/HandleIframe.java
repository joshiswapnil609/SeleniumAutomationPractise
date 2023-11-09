package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleIframe {

	public static void main(String[] args) {


		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		// switching to the iframe by passing webelement to identify locator
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class=\"demo-frame\"]")));
		
		//implementing drag and drop method using actions class
		WebElement source=driver.findElement(By.cssSelector("#draggable"));
		WebElement target=driver.findElement(By.cssSelector("#droppable"));
		Actions a=new Actions(driver);
		
		//here passing source and target webelement to perform drag and drop
		a.dragAndDrop(source, target).build().perform();
		
		// this is important steps to come out of the iframe and continue rest of automation
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Download']")).click();
		
		
		
		
	}

}
