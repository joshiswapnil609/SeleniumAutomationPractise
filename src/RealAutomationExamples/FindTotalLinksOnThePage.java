package RealAutomationExamples;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FindTotalLinksOnThePage {

	public static void main(String[] args) {


		WebDriver driver =new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    
	    //find out the total no of links present on the page.
	   System.out.println(driver.findElements(By.tagName("a")).size()); 
	   
	   //find out the total no of links present in the footer section 
	   System.out.println(driver.findElements(By.xpath("//div[@id=\"gf-BIG\"] //a")).size());
	   
	   System.out.println(driver.findElements(By.xpath("//div[@id=\"gf-BIG\"] //tr/td[1] //a")).size());
	   
	   //check whether all links are working or not 
	   Actions a=new Actions(driver);
	   for(int i=1;i<driver.findElements(By.xpath("//div[@id=\"gf-BIG\"] //tr/td[1] //a")).size();i++){
		   
		WebElement element =driver.findElements(By.xpath("//div[@id=\"gf-BIG\"] //tr/td[1] //a")).get(i);
		a.moveToElement(element).keyDown(Keys.CONTROL).click().build().perform();
	   }
	   
	   Set<String>windows=driver.getWindowHandles();
	   
	  Iterator<String>it=windows.iterator();
	  while(it.hasNext())
	  {
		  System.out.println(driver.switchTo().window(it.next()).getTitle()); 
	  }
	   
	   
	   
	   driver.close();
		
	}

}
