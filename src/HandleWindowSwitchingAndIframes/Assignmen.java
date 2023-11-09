package HandleWindowSwitchingAndIframes;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignmen {

	public static void main(String[] args) {

		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//li/a[contains(text(),'Multiple Windows')]")).click();
		driver.findElement(By.xpath("//div[@class=\"example\"]/a")).click();
		Set<String>windows=driver.getWindowHandles();
		
		Iterator <String>it=windows.iterator();
		
		String parentwin_id=it.next();
		String childwin_id=it.next();
		
		driver.switchTo().window(childwin_id);
		String childwind_text=driver.findElement(By.xpath("//h3")).getText();
		System.out.println("ChildWindowText="+childwind_text);
//		driver.close();
		driver.switchTo().window(parentwin_id);
		String parentwin_text=driver.findElement(By.xpath("//h3")).getText();
		System.out.println("ParentWindowText="+parentwin_text);
		driver.quit();
		
		
		

	}

}
