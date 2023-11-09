package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H_AutoSuggestingDropDown {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//type into the autosuggestive dropdown
		driver.findElement(By.cssSelector("#autosuggest")).sendKeys("ind");
		
		Thread.sleep(2000);
	  //write generic xpath to find out all the element suggested in the list
		List<WebElement>options=driver.findElements(By.xpath("//li[@ class=\"ui-menu-item\"]"));
		
		 //iterate through all the to check desired option text
		for(WebElement option:options) {
			
			if(option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}
	}
}
