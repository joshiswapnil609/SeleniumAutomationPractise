package Assingments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public final class I2_CheckBoxAssignment {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		System.out.println(driver.findElement(By.cssSelector("input[id=\"checkBoxOption1\"]")).isSelected());
		                            //or
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id=\"checkBoxOption1\"]")).isSelected());
		
		driver.findElement(By.cssSelector("input[id=\"checkBoxOption1\"]")).click();
		
		System.out.println(driver.findElement(By.cssSelector("input[id=\"checkBoxOption1\"]")).isSelected());
		                              //or
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id=\"checkBoxOption1\"]")).isSelected());
		
		List<WebElement>checkboxes=driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println(checkboxes.size());
		
		Thread.sleep(5000);
		driver.close();
	}
	
}
