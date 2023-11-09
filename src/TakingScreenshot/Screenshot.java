package TakingScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException, InterruptedException {


		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("D:\\SeleniumWorkspace\\Automation\\screenshot\\google.png"));
		
		Thread.sleep(2000);
		driver.close();
		

	}

}
