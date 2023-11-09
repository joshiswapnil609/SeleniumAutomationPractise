package BrokenLinks;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {


		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert a=new SoftAssert();
		
	List<WebElement> links=	driver.findElements(By.cssSelector("li[class=\"gf-li\"] a"));
	
	
	for(WebElement ele:links) {
		
		String link=ele.getAttribute("href");
		
		HttpURLConnection con=((HttpURLConnection)new URL(link).openConnection());
		con.setRequestMethod("HEAD");
		con.connect();
		int code=con.getResponseCode();
		System.out.println(code);
		
		//this is called softassertion
		a.assertTrue(code<400, "The link is broken with the text "+ele.getText()+" with the status code "+code);
		
		
		
		
	}
	a.assertAll();
	
	}

}
