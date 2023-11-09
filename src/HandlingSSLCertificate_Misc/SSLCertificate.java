package HandlingSSLCertificate_Misc;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCertificate {

	public static void main(String[] args) {


		//An SSL (Secure Sockets Layer) certificate is a digital certificate that provides security for websites by encrypting the data transmitted between a user's web browser and a web server.
		//Automation involves data tranmission and to do it securily , we need to handled those SSL certification.
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://expired.badssl.com/");
		
		// like wise we will have other browser options as well to handle this situation
		
		//we can delete the all browser cookies  also 
		driver.manage().deleteAllCookies();
		
		//we can delete specific coockies also 
	    driver.manage().deleteCookieNamed("session key");
	    
	    //we can block the popup for any websites
	    ChromeOptions options = new ChromeOptions();

	    options.setExperimentalOption("excludeSwitches",

	         Arrays.asList("disable-popup-blocking"));
	    
	    
	    
		
		

	}

}
