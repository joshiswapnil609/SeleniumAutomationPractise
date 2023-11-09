package Assingments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment {

	public static void main(String[] args)  {


		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("(//*[@type='checkbox'])[3]")).click();
		String var=driver.findElement(By.xpath("//div[@id=\"checkbox-example\"] //label[3]")).getText();
		System.out.println(var);
		Select s=new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(var);
		driver.findElement(By.name("enter-name")).sendKeys(var);
		driver.findElement(By.id("alertbtn")).click();
//		Thread.sleep(1000);
		String alertmgs= driver.switchTo().alert().getText();
		if(alertmgs.contains(var)) {
			System.out.println("Alert Message display correctly");
		}else{
			System.out.println("Alert Message is incorrect");
		}
//		driver.switchTo().alert().accept();
//		driver.close();
	}

}
