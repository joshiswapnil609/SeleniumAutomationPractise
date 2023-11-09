package Selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class N_ExplicitWait {
	
	 
	public static void main(String[] args) throws InterruptedException {

		
		String[] veggies = { "Brocolli", "Cucumber", "Carrot" };
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//Here after driver initilization we need to provide implicitly wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		driver.manage().window().maximize();
		
		//Now no need to use thread.sleep as implicitly wait is applicable globally
		//Thread.sleep(2000);
		addToCart(driver,veggies);
		driver.findElement(By.cssSelector("img[alt=\"Cart\"]")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		//Here after redirecting page selenium will try to share element quickly but it's actually need some time to load on the page and in between selenium fails to identify the element and send the text.
		//Hence we need to provide implicity wait to wait for some time to load the element and then continue
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
        System.out.println("Hi coupon code pasted");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        
        //Here we are targeting to this specific element with the explicit wait
        WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        
        
        driver.close();

	}

	public static void addToCart(WebDriver driver, String[] veggies) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		List<String> itemAddToCard = Arrays.asList(veggies);
		int j = 0;
		for (int i = 0; i <= products.size(); i++) {
			String name = products.get(i).getText().split("-")[0].trim();
			if (itemAddToCard.contains(name)) {
				driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();
				System.out.println("Product has been added to Cart !");
				j++;
				if (itemAddToCard.size() == j) {
					break;
				}
			}

		}

	}

}
