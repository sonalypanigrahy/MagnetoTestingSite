package rahulshettyautomationacademy.SeleniumFrameworkDesignPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends AbstractPage{	
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".form-group .input.txt.text-validated")
	WebElement countryselector;
	By countrynames=By.cssSelector(".ta-results");
	@FindBy(css=".ta-results button:last-of-type")
	WebElement finalcountry;
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement placeorderbutton;
	public void selectCountry(String countryname)
	{
		countryselector.sendKeys(countryname);
		visibilityOf(countrynames);
		finalcountry.click();
	}
	public ConfirmationPage submitOrder()
	{
		//placeorderbutton.click();
		elementclcikable(placeorderbutton);
		ConfirmationPage confirmpage=new ConfirmationPage(driver);
		return confirmpage;
	}
}
