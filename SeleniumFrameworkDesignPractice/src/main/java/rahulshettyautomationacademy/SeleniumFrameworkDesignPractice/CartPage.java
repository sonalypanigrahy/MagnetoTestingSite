package rahulshettyautomationacademy.SeleniumFrameworkDesignPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractPage{	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".subtotal .totalRow button")
	WebElement checkoutbutton;
	public CheckOutPage goToCheckout()
	{
		checkoutbutton.click();
		return new CheckOutPage(driver);
	}
}
