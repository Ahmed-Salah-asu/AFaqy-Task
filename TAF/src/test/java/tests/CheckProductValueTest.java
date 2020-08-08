package tests;


import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
/*
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
 */
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import data.Constants;

import org.testng.Assert;
import pages.AddItemToYourCardPage;
import pages.CheckOutPage;
import pages.ChecoutSucessPage;
import pages.HomePage;
import pages.ShoppingCartPage;
import pages.YourStorePage;




public class CheckProductValueTest extends TestBase{

	protected WebDriverWait wait;
	Random randomGenerator = new Random();  
	int randomInt = randomGenerator.nextInt(10000);
	Constants constantsobj=new Constants();
	CSVReader reader ;
	/*
	@DataProvider(name="TestDataDrivenD")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		TestDataDriven testDataDriven = new TestDataDriven();
		return testDataDriven.getExcelData();
	}
	 */
	@Test(priority=1,alwaysRun=true)
	public void Adding_items_to_cart() throws CsvValidationException, IOException, InterruptedException 
	{ 
		HomePage homeobject = new HomePage (driver);
		homeobject.Click_On_Show_All_Desktops_Link();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//First Way for Scrolling Using JavascriptExecutor
		JavascriptExecutor IJavascriptExecutor = (JavascriptExecutor) driver;
		IJavascriptExecutor.executeScript("window.scrollBy(0,2000)", "");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		//Second Way for scrolling Using Actions
		Actions action = new Actions(driver);
		WebElement Sony_VAIO=driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[12]/div/div[2]/div[1]/h4/a"));
		action.moveToElement(Sony_VAIO).build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 */
		YourStorePage yourStorePage=new YourStorePage(driver);
		yourStorePage.Click_On_SonyVAIO_Item();

		AddItemToYourCardPage AddItemtoCardobject=new AddItemToYourCardPage(driver);
		AddItemtoCardobject.AddQty();
		AddItemtoCardobject.ClickOnAddToCartButton();
		AddItemtoCardobject.ClickOnShoppingCartButton();

		ShoppingCartPage shoppingCartPage=new ShoppingCartPage(driver);
		Assert.assertTrue(shoppingCartPage.ProductName.getText().contains(constantsobj.ExpectedProductName));
		Assert.assertTrue(shoppingCartPage.Model.getText().contains(constantsobj.ExpectedModel));
		Assert.assertEquals(shoppingCartPage.ActualValueForQuantity(), constantsobj.ExpectedQuantity);
		Assert.assertTrue(shoppingCartPage.UnitPrice.getText().contains(constantsobj.ExpectedUnitPrice));
		Assert.assertTrue(shoppingCartPage.Total.getText().contains(constantsobj.ExpectedTotal));
		shoppingCartPage.ClickOnCheckOutButton();
		driver.findElement(By.id(constantsobj.ContinueButton)).click();
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		// get path of CSV file 
		reader = new CSVReader(new FileReader(constantsobj.CSV_file)); 
		String[] csvCell ; 
		while((csvCell = reader.readNext()) != null) 
		{
			String firstname = csvCell[0];
			String lastName = csvCell[1]; 
			String mail=randomInt+csvCell[2];
			String telephone=csvCell[3];
			String address1=csvCell[4];
			String city=csvCell[5];
			String country=csvCell[6];
			String Region=csvCell[7]; 
			String pass=csvCell[8];
			checkOutPage.userRegistration(firstname,lastName,mail,telephone,address1,city,country, Region, pass);
		}
		checkOutPage.WaitTillApppear();
		checkOutPage.ContinueCheckOutAndConfirmOrder();
		
		ChecoutSucessPage checoutSucessPageobj=new ChecoutSucessPage(driver);
		checoutSucessPageobj.ClickonContinuebutton();
	}
}
