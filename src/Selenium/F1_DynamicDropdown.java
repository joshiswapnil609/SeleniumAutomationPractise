package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F1_DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[text()='From']/parent::div")).click();
		driver.findElement(By.xpath("//div[text()='Aurangabad']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Jaipur']")).click();
//		Thread.sleep(2000);
		driver.close();
		

	}

}
