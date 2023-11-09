package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F2_dynamicdrop2 {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		Thread.sleep(2000);
		// now selecting value from first dropdown 
		//here xpath use is parent window xpath follwed by child value xpath 
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='AMD']")).click();
		driver.findElement(By.xpath(" //*[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value='ATQ']")).click();
//		driver.close();
		
	}
}
