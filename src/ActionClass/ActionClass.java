package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionClass {

	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumWorkspace\\Automation\\Resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		//move to the specific element 
		Actions a= new Actions(driver);
		WebElement element=driver.findElement(By.cssSelector("a#nav-link-accountList"));
		a.moveToElement(element).build().perform();
		
		//type in capital case
        element =driver.findElement(By.id("twotabsearchtextbox"));
        a.moveToElement(element).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
        
        //double click 
        a.moveToElement(element).doubleClick().build().perform();
        
        //right click
        element=driver.findElement(By.cssSelector("#nav-orders"));
        a.moveToElement(element).contextClick().build().perform();
        
        
		

	}

}
