
package HandlingCalender;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class CalenderAssignment{
	public static void main(String[] args) {
	    String month = "January 2024";
	    String day = "15";

	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.makemytrip.com/");
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
	    driver.findElement(By.xpath("//label[@for='departure']")).click();

	    while (true) {
	        List<WebElement> dayElements = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']"));
	        
	        for (WebElement monthElement : dayElements) {
	            if (monthElement.getText().equalsIgnoreCase(month)) {
	                List<WebElement> dates = monthElement.findElements(By.xpath("../../..//div[@class='dateInnerCell']/p[1]"));
	                
	                for (WebElement date : dates) {
	                    if (date.getText().equalsIgnoreCase(day)) {
	                        date.click();
	                        return;
	                    }
	                }
	            }
	        }

	        driver.findElement(By.className("DayPicker-NavButton--next")).click();
	    }
	}

}
