package Selenium;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class C_Xpath_Css_Locators {

	public static void main(String[] args) throws InterruptedException {

		String name = "swapnil";

		//		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumWorkspace\\Automation\\Resources\\chromedriver.exe");

		//	    Execute on Chrome browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//		Execute on Edge browser
		//		WebDriverManager.edgedriver().setup();
		//		WebDriver  driver = new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);

		driver.findElement(By.name("inputPassword")).sendKeys(getPassword(driver));
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		//        System.out.println(driver.findElement(By.xpath("//p")).getText());
		//        System.out.println(driver.findElement(By.cssSelector("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + name + ",");

		//                                             By.xpath(//div[@class='login-container']/h2)
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();

	}

	public static String getPassword(WebDriver driver) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='forgot-pwd-btn-conainer']/button[text()='Reset Login']")).click();
		String password = driver.findElement(By.cssSelector("form p")).getText();
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(10000);

		String[] passwordarray = password.split("'");
		return passwordarray[1].split("'")[0];
	}
}
