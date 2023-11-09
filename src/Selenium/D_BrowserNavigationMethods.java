package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D_BrowserNavigationMethods {

	public static void main(String[] args) {
		
//		WebDriverManager.chromedriver().setup();   this is option line to write with latest selenium dependency
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.google.com");  
		driver.navigate().to("http://www.flipkart.com");
	    driver.navigate().back();
	    driver.navigate().forward();
	    
	    driver.close();
	   
	}
}
