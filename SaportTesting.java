package FirstProject;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaportTesting {

	public static String browser = "chrome";
	public static WebDriver driver;
	@Test
	public  void Sport() throws Exception {
		ScreenRecorderUtil.startRecord("main");
		Reporter.log("testing recorder is start and open browser");
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		} 
		else if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		
        JavascriptExecutor js = (JavascriptExecutor)driver;		
		driver.get("https://discover.sportsengineplay.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"se-primary-navigation\"]/li[1]/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"se-primary-navigation\"]/li[1]/div/ul/li[1]/ul/li[2]/a/div/div")).click();
		js.executeScript("window.scrollBy(0,1500)");
		driver.findElement(By.xpath("//*[@id=\"block-sportsengine-content\"]/article/div/div[2]/div[4]/div/div/div/div[2]/div/div/div[1]/div/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-vulcan-v2-42\"]/div[1]/div[3]/div/div[2]/img")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1000)");
		driver.navigate().to("https://discover.sportsengineplay.com/baseball/new-to-baseball");
		driver.findElement(By.xpath("//*[@id=\"block-sportsengine-content\"]/article/div[3]/div/div/div[1]/article/div/div/div/div[1]/div/p[8]/a")).click();
		js.executeScript("window.scrollBy(0,3700)");
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(".//screenshotproject/new.png"));
		Reporter.log("testing take picture inside folder");
		Thread.sleep(1000);
		driver.close();
		ScreenRecorderUtil.stopRecord();
	
		Reporter.log("testing recorder is done and close browser");
		
	}

}
