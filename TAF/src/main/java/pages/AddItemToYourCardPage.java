package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddItemToYourCardPage extends PageBase 
{
	public AddItemToYourCardPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(id="input-quantity")
	WebElement QtyTextBox ;

	@FindBy(id="button-cart")
	WebElement AddToCartButton ;

	@FindBy(xpath="//a[contains(text(),'shopping cart')]")
	WebElement ShoppingCartButton ;

	public void AddQty() {
		ClearElementText(QtyTextBox);
		SetElementText(QtyTextBox,"2");
	}
	public void ClickOnAddToCartButton() 
	{
		ClickButton(AddToCartButton);
	}
	public void ClickOnShoppingCartButton() 
	{
		ClickButton(ShoppingCartButton);
	}
}
