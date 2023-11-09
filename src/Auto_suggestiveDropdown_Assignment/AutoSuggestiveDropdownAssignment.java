package Auto_suggestiveDropdown_Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdownAssignment {

	static String country="India";
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys(country);
		
       List<WebElement>values =driver.findElements(By.cssSelector(".ui-menu-item"));

       for(WebElement ele:values) {
    	   
    	   if(ele.getText().equalsIgnoreCase(country)) {
    		   
    	   ele.click();
    	   System.out.println(driver.findElement(By.cssSelector("#autocomplete")).getAttribute("value"));
    	   }else
    	   {
    		   driver.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.DOWN);
    	   }
       }
	}

}
