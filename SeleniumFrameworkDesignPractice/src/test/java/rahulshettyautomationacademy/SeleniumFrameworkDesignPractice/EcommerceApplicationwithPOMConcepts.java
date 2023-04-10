package rahulshettyautomationacademy.SeleniumFrameworkDesignPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EcommerceApplicationwithPOMConcepts  {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(option);
		String productName="ADIDAS ORIGINAL";
		String countryname="India";
		driver.manage().window().maximize();
		LandingPage landpage=new LandingPage(driver);
		landpage.goTo();
		ProductCatalogue prodcata=landpage.login("sonalypanigrahy14@gmail.com", "Sonaly@1996");
		prodcata.findElement(productName);
		prodcata.addProducttoCart(productName);
		Thread.sleep(2000);
		CartPage cartpage=prodcata.goToCartPage();
		Thread.sleep(2000);
		CheckOutPage checkoutpage=cartpage.goToCheckout();
		checkoutpage.selectCountry(countryname);
		Thread.sleep(2000);
		checkoutpage.submitOrder();
		ConfirmationPage confirmpage=new ConfirmationPage(driver);
		//Thread.sleep(3000);
		String text=confirmpage.getMessage();
		System.out.println(text);
		Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}

}
