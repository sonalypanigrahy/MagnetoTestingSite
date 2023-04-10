package rahulshettyautomationacademy.SeleniumFrameworkDesignPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractPage{	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1[contains(text(),'Thankyou for the order.')]")
	
	WebElement message;
	public String getMessage()
	{
		
		visibilityOfElement(message);
		return message.getText();
	}
}
