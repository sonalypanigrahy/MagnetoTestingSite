package rahulshettyautomationacademy.SeleniumFrameworkDesignPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractPage{	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@formcontrolname='userEmail']")
	WebElement user;
	@FindBy(id="userPassword")
	WebElement passwordd;
	@FindBy(name="login")
	WebElement loginbutton;
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	public ProductCatalogue login(String email,String password)
	{
		user.sendKeys(email);
		passwordd.sendKeys(password);
		loginbutton.click();
		ProductCatalogue prodcata=new ProductCatalogue(driver);
		return prodcata;
	}
}
