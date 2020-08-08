package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourStorePage extends PageBase {

	public YourStorePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//*[@id=\"content\"]/div[4]/div[12]/div/div[2]/div[1]/h4/a")
	WebElement SonyVAIO_Item ; 
	
	public void Click_On_SonyVAIO_Item() {
		SonyVAIO_Item.click();
		
	}
}
