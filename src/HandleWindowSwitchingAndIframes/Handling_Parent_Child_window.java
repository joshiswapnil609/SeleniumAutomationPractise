package HandleWindowSwitchingAndIframes;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Parent_Child_window {

	public static void main(String[] args) {


		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		// getWindowHandles --> this method is used to get id's of all open window or tab and store it into Set.
		Set<String>windows=driver.getWindowHandles();
		
		//with "Iterator" interface we can get set value extracted
		Iterator<String>it =windows.iterator();
		String parentwindow_id=it.next();
		String childwindow_id=it.next();
		
		//switching to the child window 
		driver.switchTo().window(childwindow_id);
		String username=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(username);
		
		//once we done with child window , closing child window 
		driver.close();
		
		//switching back to the parent window 
		driver.switchTo().window(parentwindow_id);
		driver.findElement(By.id("username")).sendKeys(username);
		
		//closing parent window 
		driver.close();
		
		
		
		
	}

}
