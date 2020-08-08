package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);	
	}

	@FindBy(xpath="//div[@id='content']/form/div/table/tbody/tr/td[2]/a")
	public WebElement ProductName ;

	@FindBy(xpath="//div[@id='content']/form/div/table/tbody/tr/td[3]")
	public WebElement Model ;

	@FindBy(xpath="//input[@type='text']")
	List<WebElement> Quantity;

	@FindBy(xpath="//div[@id='content']/form/div/table/tbody/tr/td[5]")
	public WebElement UnitPrice;

	@FindBy(xpath="//div[@id='content']/form/div/table/tbody/tr/td[6]")
	public WebElement Total;

	@FindBy(xpath="//li[5]/a/span")
	public WebElement CheckOutButton ;

	public String ActualValueForQuantity() 
	{
		return Quantity.get(1).getAttribute("value");
	}
	public void ClickOnCheckOutButton() 
	{
		ClickButton(CheckOutButton);
	}
	
}
