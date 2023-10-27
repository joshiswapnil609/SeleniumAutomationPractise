package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumToLunchBrowser {

	public static void main(String[] args) {
		
		//Webdriver is interface and chromedriver , edgedriver ,firefox etc are its implementation classes . So we can get access to all the method of webdriver interface as well as chromedriver or edgedriver implementation class methods.
		

		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumWorkspace\\Automation\\Resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
		driver.close();
		//there is slight difference in close and quite method 
		//close :- will close current driver tab which is open due to automation 
		//quite :- will close all the driver tab which are opened due to automation.
		
		System.setProperty("webdriver.edge.driver", "D:\\SeleniumWorkspace\\Automation\\Resources\\msedgedriver.exe");
		WebDriver driver1=new EdgeDriver();
		driver1.get("https://www.saucedemo.com/v1/");
//		driver1.close();

		
		//similarlly we can use this line of code for the invoking the any browser using that browser specific driver exe. 
		
		
		
		
	}

}
