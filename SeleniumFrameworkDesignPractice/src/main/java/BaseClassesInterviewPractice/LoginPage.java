package BaseClassesInterviewPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstarctClass {
	WebDriver objWebdriver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.objWebdriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#email")
	WebElement weUserId;
	@FindBy(xpath = "//input[@name='login[password]']")
	WebElement wePassWord;
	@FindBy(css = ".action.login.primary")
	WebElement weSignIn;

	public LandingPage Login(String userID, String passWord) {
		weUserId.sendKeys(userID);
		wePassWord.sendKeys(passWord);
		weSignIn.click();
		return new LandingPage(objWebdriver);
	}
}
