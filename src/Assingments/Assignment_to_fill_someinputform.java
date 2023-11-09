package Assingments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment_to_fill_someinputform {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.className("form-control")).click();
		driver.findElement(By.className("form-control")).sendKeys("swapnil");
		
		driver.findElement(By.name("email")).sendKeys("swapniljoshi@gmail.com");
		
		driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("s@123");
		
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		
		WebElement gendropdown=driver.findElement(By.cssSelector("#exampleFormControlSelect1"));
		Select gen= new Select(gendropdown);
		gen.selectByVisibleText("Male");
		driver.findElement(By.xpath("//input[@id=\"inlineRadio1\"]")).click();
		driver.findElement(By.name("bday")).sendKeys("18/09/2023");
		driver.findElement(By.xpath("//input[@value=\"Submit\"]")).click();
		Thread.sleep(1000);
		
		String validationmgs=driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		System.out.println(validationmgs);
		
		Assert.assertTrue(validationmgs.contains(" The Form has been submitted successfully!."));
		Thread.sleep(1000);
		driver.close();
	}

}
