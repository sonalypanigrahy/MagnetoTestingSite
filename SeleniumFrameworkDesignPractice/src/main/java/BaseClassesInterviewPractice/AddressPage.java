package BaseClassesInterviewPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Helpers.AddressDetails;

public class AddressPage extends AbstarctClass {
	WebDriver objWebdriver;
	 
	public AddressPage(WebDriver driver) {
		super(driver);
		this.objWebdriver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="street_1")
	WebElement weStreetAddress;
	@FindBy(xpath="//input[@name='city']")
	WebElement weCity;
	@FindBy(name="region")
	WebElement weProvince;
	By name=By.name("region");		
	@FindBy(name="postcode")
	WebElement wePostalcode;
	@FindBy(name="country_id")
	WebElement weCountry;
	@FindBy(name="telephone")
	WebElement weTelephonenumber;
	@FindBy(css=".action.primary.action-save-address span")
	WebElement weShipHereButton;
	@FindBy(xpath="//header/div[1]/div[1]/ul[1]/li[2]/div[1]/ul[1]/li[1]/a[1]")
	WebElement weMyAccountlink;
	By weship=By.cssSelector(".action.primary.action-save-address span");
	@FindBy(linkText="Address Book")
	WebElement weMyAddsressButton;
	@FindBy(xpath="//button[@role='add-address']/span")
	WebElement weAddAddressButton;
	@FindBy(css=".action.save.primary")
	WebElement weSaveAddressButton;
	@FindBy(className="logged-in")
	WebElement welogINMessage;
	@FindBy(className="switch")
	WebElement dropdown;
	@FindBy(id="primary_billing")
	WebElement webuttonBillingAddress;
	@FindBy(id="primary_shipping")
	WebElement webuttonShippingAddress;
	@FindBy(css=".message-success.success.message div")
	WebElement weConfirmationMessageAddress;
	public void AddAddressforDelivery(AddressDetails objAddressDetails ) throws InterruptedException
	{
		objAddressDetails.FillAddress();
		//visibilityOf(weStreetAddress);
		weStreetAddress.sendKeys(objAddressDetails.getStreetAddress());
		weCity.sendKeys(objAddressDetails.getCity());
		weCountry.click();
		actionforDropdown(weCountry,objAddressDetails.getCountry());
		Thread.sleep(4000);
		VerifyVisibilityOfElementLocated(name);
		weProvince.sendKeys(objAddressDetails.getState());
		wePostalcode.sendKeys(objAddressDetails.getPostalCode());
		weTelephonenumber.sendKeys(objAddressDetails.getPhoneNumber());
		
	}
	public void GoToAddress() throws InterruptedException
	{
		Thread.sleep(4000);
		visibilityOf(welogINMessage);
		dropdown.click();
		weMyAccountlink.click();
		visibilityOf(weMyAddsressButton);
		weMyAddsressButton.click();
		weAddAddressButton.click();
		AddAddressforDelivery(new AddressDetails());	
	}
	public String SelectDefaultAddress()
	{
		webuttonBillingAddress.click();
		webuttonShippingAddress.click();
		weSaveAddressButton.click();
		visibilityOf(weConfirmationMessageAddress);
		return weConfirmationMessageAddress.getText();
	}
	
}
