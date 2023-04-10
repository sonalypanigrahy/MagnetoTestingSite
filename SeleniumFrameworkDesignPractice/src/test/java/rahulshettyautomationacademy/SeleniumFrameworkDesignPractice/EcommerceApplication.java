package rahulshettyautomationacademy.SeleniumFrameworkDesignPractice;

import java.io.IOException;

import org.testng.annotations.Test;

import sonaly.testpractice.BaseTest;

public class EcommerceApplication  extends BaseTest{
		@Test
		public void submitOrder() throws InterruptedException, IOException
		{
		String productName="ADIDAS ORIGINAL";
		String countryname="India";
		ProductCatalogue prodcata=landPage.login("sonalypanigrahy14@gmail.com", "Sonaly@1996");
		prodcata.findElement(productName);
		prodcata.addProducttoCart(productName);
		Thread.sleep(2000);
		CartPage cartpage=prodcata.goToCartPage();
		Thread.sleep(2000);
		CheckOutPage checkoutpage=cartpage.goToCheckout();
		checkoutpage.selectCountry(countryname);
		Thread.sleep(2000);
		ConfirmationPage confirmpage=checkoutpage.submitOrder();
		//String text=confirmpage.getMessage();
		//System.out.println(text);
		//Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}

}
