package JavaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSorting {
	
	
	public static void main(String args[]) {
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		List<WebElement>unsorted_elements=driver.findElements(By.cssSelector("table.table.table-bordered tr td:nth-child(1)"));
		
		List<String>ExpectedSortedList=unsorted_elements.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
		System.out.println("Expected Sorted List :-"+ExpectedSortedList);


		
		driver.findElement(By.cssSelector("table.table.table-bordered thead th:nth-child(1)")).click();
		
		List<WebElement>sorted_elements=driver.findElements(By.cssSelector("table.table.table-bordered tr td:nth-child(1)"));
		
		List<String>ActualSortedList=sorted_elements.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println("Actual Sorted List :-"+ActualSortedList);
		
		Assert.assertEquals(ActualSortedList, ExpectedSortedList);
	}

}
