package BaseClassesInterviewPractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstarctClass {

	WebDriver objWebdriver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.objWebdriver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".action.primary.checkout")
	WebElement wePlaceOrderbutton;
	@FindBy(xpath="//div[3]/div[1]/div[2]/p[1]/a[1]")
	WebElement weOrderID;
	@FindBy(xpath="//header/div[1]/div[1]/ul[1]/li[2]/span[1]/button[1]")
	WebElement weToggle;
	@FindBy(linkText="My Account")
	WebElement weMyAccountlink;
	
	//@FindBy(css=".action.primary.continue")
	//WebElement weContinueButton;
	public void PlaceOrder()
	{
		visibilityOf(wePlaceOrderbutton);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", wePlaceOrderbutton);
	}
	public String GetOrderID()
	{
		visibilityOf(weOrderID);
		return weOrderID.getText();
	}
	public MyOrdersPage GoToMyOrders()
	{
		visibilityOf(weToggle);
		weToggle.click();
		weMyAccountlink.click();
		return new MyOrdersPage(objWebdriver);
	}
}
