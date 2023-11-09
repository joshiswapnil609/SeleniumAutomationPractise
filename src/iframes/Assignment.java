package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {


		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Nested Frames")).click();
		
		//if there are nested frames present , then first check how many main frames are there as below
		System.out.println(driver.findElements(By.xpath("//frame")).size());
		
		driver.switchTo().frame(0);
		
//		use same technique to know how many sub frames are there 
		System.out.println(driver.findElements(By.xpath("//frame")).size());
		
		driver.switchTo().frame(1);
		
		System.out.println(driver.findElement(By.id("content")).getText());	
	}
}
