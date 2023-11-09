package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class E1_StaticDropdown {

	public static void main(String[] args) {
		
//		WebDriver driver=new ChromeDriver();
		WebDriver driver =new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement staticdroptdown=driver.findElement(By.name("dropdown-class-example"));
		
		Select s=new Select(staticdroptdown);
		s.selectByIndex(1);
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByVisibleText("Option2");
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByValue("option3");
		System.out.println(s.getFirstSelectedOption().getText());
		
		driver.close();
		
		
		
	}
}
