package HandlingScollingUsingJs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleScolling {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//scroll down windows
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector(\'.tableFixHead\').scrollTop=4000");
		
		List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead tr td:nth-child(4)"));
		int sum=0;
		for(WebElement ele:values) {
			sum=sum+Integer.parseInt(ele.getText());
			
		}
		int total=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, total);

	}

}
