package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="input-payment-firstname")
	WebElement FirstName ; 

	@FindBy(id="input-payment-lastname")
	WebElement LastName; 

	@FindBy(id="input-payment-email")
	WebElement E_mail ; 

	@FindBy(id="input-payment-telephone")
	WebElement TeleTextBox ; 

	@FindBy(id="input-payment-address-1")
	WebElement Addr1TextBox ;

	@FindBy(id="input-payment-city")
	WebElement CityTextBox ;


	@FindBy(id="input-payment-country")
	WebElement Country_Text ;
	Select Select2 = new Select(Country_Text);

	@FindBy(id="input-payment-zone")
	WebElement RegionSelected ;
	Select select = new Select(RegionSelected);


	@FindBy(id="input-payment-password")
	WebElement PassTextBox ; 

	@FindBy(id="input-payment-confirm")
	WebElement ConfirmPassTextBox ; 

	@FindBy(name="agree")
	WebElement PrivacyPilicycheckBox ; 

	@FindBy(id="button-register")
	WebElement ContinueregisterBtn ; 
	@FindBy(id="button-shipping-address")
	public WebElement ContinueButtonInDeliveryDetails ;

	@FindBy(id="button-shipping-method")
	public WebElement ContinueButtonInDeliveryMethods ;

	@FindBy(name="agree")
	public WebElement AcceptTermsAndConditions ;


	@FindBy(id="button-payment-method")
	public WebElement ContinueButtonInPaymentMethod ;


	@FindBy(xpath="//*[@id='button-confirm']")
	public WebElement ConfirmOrderButton ;
	
	public void userRegistration(String firstName , String lastName , String mail , String Telephone,
			String Address1,String City,String Country, String Region , String password) throws InterruptedException 
	{
		SetElementText(FirstName,firstName);
		SetElementText(LastName,lastName);
		SetElementText(E_mail,mail);
		SetElementText(TeleTextBox, Telephone);
		SetElementText(Addr1TextBox, Address1);
		SetElementText(CityTextBox, City);
		ClickButton(Country_Text);
		SetElementText(Country_Text, Country);
		ClickButton(RegionSelected);
		SetElementText(RegionSelected, Region);
		SetElementText(PassTextBox, password);
		ClickButton(PrivacyPilicycheckBox);
		SetElementText(ConfirmPassTextBox, password);
		ClickButton(ContinueregisterBtn);
	}	
	public void ContinueCheckOutAndConfirmOrder() throws InterruptedException {

		ClickButton(ContinueButtonInDeliveryDetails);
		ClickButton(ContinueButtonInDeliveryMethods);
		WaitTillApppear();
		ClickButton(AcceptTermsAndConditions);
		ClickButton(ContinueButtonInPaymentMethod);
		ClickButton(ConfirmOrderButton);
	}
	public void WaitTillApppear() throws InterruptedException
	{
		Thread.sleep(2000);
	}
}
