package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;




public class HandlingToolTip {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com");
		Actions a=new Actions(driver) ;
		WebElement tooltipelement=driver.findElement(By.xpath("//div[@aria-label='Search by voice']"));
		a.moveToElement(tooltipelement).perform();
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Search by voice')]")).getText());
		

	}

}
