package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class J_Enable_orNot {

	public static void main(String[] args) throws InterruptedException {


		//Here we are checking whether webelement is enable or not based on the some condition 
		//without using isenable() method as is some times not working .
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));
		
		// here we have taken one attribute value which is made deleberately to change once webelement turn to enable.
		
		if(driver.findElement(By.cssSelector("#Div1")).getAttribute("style").contains("1")) {
			
			System.out.println("its enabled");
			Assert.assertTrue(true);
		}
		else {
			
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);
		driver.close();
	}

}
