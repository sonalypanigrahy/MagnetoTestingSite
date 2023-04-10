package BaseClassesInterviewPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstarctClass{
	WebDriver objWebdriver;
    public LandingPage(WebDriver driver) {

		// TODO Auto-generated constructor stub
    	super(driver);
		this.objWebdriver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(partialLinkText="Sign In")
	WebElement signinbutton;
	public void GetURL(String url) 
	{
		objWebdriver.get(url);
		
	}
	public LoginPage GoToSignIn()
	{
		signinbutton.click();
		return new LoginPage(objWebdriver);
	}
}
