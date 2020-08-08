package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id='menu']/div[2]/ul/li[1]/a")
	public WebElement Desktops_Link ; 
	
	@FindBy(xpath="//a[contains(text(),'Show All Desktops')]")
	public WebElement Show_All_Desktops_Link ; 
	
	 public void Click_On_Show_All_Desktops_Link ()
	 {
		 ClickButton(Desktops_Link);
		 ClickButton(Show_All_Desktops_Link);		
	 }
	
}
