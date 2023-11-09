package HandlingScollingUsingJs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {


        WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,700)");
		
	
	    List<WebElement> values =driver.findElements(By.cssSelector(".table-display tr td:nth-child(3)"));
		
		int sum=0;
	    for(int i=0;i<values.size();i++) {
	    	
	          sum=sum+Integer.parseInt(values.get(i).getText()); 
	          System.out.println(values.get(i).getText());
	    }

	    System.out.println("Total No. of Records: "+sum);
	    System.out.println("NO. of Rows : "+driver.findElements(By.cssSelector(".table-display tr")).size());
	    System.out.println("No. of Colums : "+driver.findElements(By.cssSelector(".table-display th")).size());
	    System.out.println("Content of Second Row is : "+driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
	    
	    Thread.sleep(2000);
	    driver.close();
	}
	
	
    
}
