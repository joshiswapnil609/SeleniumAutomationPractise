package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class E2_StaticDropdown2 {

	public static void main(String[] args) {


		WebDriver driver =new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://spicejet.com");
		driver.findElement(By.xpath("//div[text()='Passengers']/parent::div")).click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Passengers']/parent::div/div[2]/div[1]")).getText());
		for(int i=1;i<5;i++) {
		driver.findElement(By.xpath("//div[text()='Adult']/parent::div/following-sibling::div/div[3]")).click();
		}
		driver.findElement(By.xpath("//div[text()='Done']/parent::div")).click();
		Assert.assertEquals("5 Adults", driver.findElement(By.xpath("//div[text()='Passengers']/parent::div/div[2]/div[1]")).getText());
	    System.out.println(driver.findElement(By.xpath("//div[text()='Passengers']/parent::div/div[2]/div[1]")).getText());
	    driver.close();
	}
	

}
