package BaseClassesInterviewPractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.AddressDetails;

public class CheckOutShipping extends AbstarctClass {
	WebDriver objWebdriver;
	 
	public CheckOutShipping(WebDriver driver) {
		super(driver);
		this.objWebdriver = driver;
		PageFactory.initElements(driver, this);
	} 
	@FindBy(css=".new-address-popup button span")
	WebElement weNewAddressButton;
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement weNextbutton;
	public void AddNewAddress() throws InterruptedException
	{
		visibilityOf(weNewAddressButton);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", weNewAddressButton);
		AddressPage addressPage=new AddressPage(objWebdriver);
		addressPage.AddAddressforDelivery(new AddressDetails());
	}
	public CheckoutPage ClickNext() throws InterruptedException
	{
		Thread.sleep(3000);
		weNextbutton.click();
		return new CheckoutPage(objWebdriver);
	}
}
