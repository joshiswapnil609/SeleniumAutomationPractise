package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parent_child_Locator {

	public static void main(String[] args) {
		
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//xpath traversing from parent to child
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]//following-sibling::button[1]")).getText());
	    
		//xpath traverssing from child to parent to grandparent to grandchild
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button/parent::div/parent::header/div/button[2]")).getText());
		driver.close();
		
	}
}
