package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	public static WebDriver driver;
	@Parameters({"Browser"})
	@BeforeSuite
	public void startDriver(@Optional("chrome") String Browsername)
	{
	   if (Browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(Browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		///////////////////////////////////////////////////
		driver.navigate().to("http://tutorialsninja.com/demo/");
	}

	@AfterSuite
	public void stopDriver() {
		//driver.quit();
	}

}
