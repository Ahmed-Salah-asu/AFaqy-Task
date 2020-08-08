package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PageBase {
	protected WebDriver driver;

	public PageBase (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	protected static void ClickButton(WebElement Button)
	{
		Button.click();	
	}
	protected static void ClearElementText(WebElement textElement)
	{
		textElement.clear();	
	}
	protected static void SetElementText(WebElement textElement,String Value)
	{
		textElement.sendKeys(Value);
	}
	
	
	
	
}
