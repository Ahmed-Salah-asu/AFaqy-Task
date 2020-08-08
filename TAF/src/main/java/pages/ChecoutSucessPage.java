package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChecoutSucessPage extends PageBase {

	public ChecoutSucessPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[contains(text(),'Continue')]")
    public WebElement  ContinueButton ;
	public void ClickonContinuebutton()
	{
		ClickButton(ContinueButton);
	}

}
