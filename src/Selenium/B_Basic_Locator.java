package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class B_Basic_Locator {
	 public static WebDriver driver;
	 
	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumWorkspace\\Automation\\Resources\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//By id locator
		driver.findElement(By.id("inputUsername")).sendKeys("abcdz"); 
		//xPath --> //tagname[@attribute='value'] -->  //input[@id='inputUsername']
		//css --> tagname#id --> input#inputUsername
		
		//By Name locator
		driver.findElement(By.name("inputPassword")).sendKeys("123456");
		
		//By Classname locator
		driver.findElement(By.className("signInBtn")).click();
		//Css --> tagname.classname --> button.signInBtn
		//xpath --> //tagname[@Class='value']--> //button[@Class='signInBtn']
		
		//By css selector with classname
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//By link text
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000);// this we have provided to overcome ElementClickInterceptedException
		
		//By Customized xpath 
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("swapnil");
		
		//By Customized Css 
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("swapnil.1@rpm.com");
		
		//By Customized xpath with index
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		//By Customized Css with index
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("swpanil.1@gmail.com");
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9865325601");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("swapnil");
		driver.findElement(By.cssSelector("input[name*='Pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.cssSelector("button[class*='sub']")).click();
		
		driver.close();
	
		
		
	}

}
