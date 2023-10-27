package Selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitAssingment {

	
	public static void main(String[] args) {
		
		String [] phonelist= {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//Here after driver initilization we need to provide implicitly wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//label[text()='Password:']/following-sibling::input")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value=\"user\"]/following-sibling::span")).click();
		
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		WebElement ele=driver.findElement(By.cssSelector("select.form-control"));
		Select s=new Select(ele);
		s.selectByVisibleText("Consultant");
		
		driver.findElement(By.cssSelector("#terms")).click();
		
		driver.findElement(By.id("signInBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"ProtoCommerce Home\"]")));
		
		List<WebElement> actualphonelist=driver.findElements(By.xpath("//app-card //h4/a"));
        List<String>expectedphonelist=Arrays.asList(phonelist);
		int j=0;
		for(int i=0;i<=actualphonelist.size();i++) {
			
			String phonename=actualphonelist.get(i).getText();
			if(expectedphonelist.contains(phonename)) {
				driver.findElements(By.xpath("//button[@class=\"btn btn-info\"]")).get(i).click();
				j++;
				if(j==expectedphonelist.size()) {
					break;
				}
			}
			
		}
		driver.findElement(By.xpath("//div[@id=\"navbarResponsive\"] //a")).click();
		driver.close();
		
		
	}
}
