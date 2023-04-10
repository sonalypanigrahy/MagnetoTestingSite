package Interview;

import static Helpers.Constants.EMAIL;
import static Helpers.Constants.JACKETS;
import static Helpers.Constants.JACKETSQTY;
import static Helpers.Constants.PANTS;
import static Helpers.Constants.PASSWORD;
import static Helpers.Constants.PANTSQTY;

import java.io.IOException;
import java.text.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import BaseClassesInterviewPractice.CheckOutCartPage;
import BaseClassesInterviewPractice.CheckOutShipping;
import BaseClassesInterviewPractice.CheckoutPage;
import BaseClassesInterviewPractice.MyOrdersPage;
import BaseClassesInterviewPractice.ProductCatalogue;

public class PlaceOrderTest extends BaseTest {
	@BeforeTest
	public void LogInDetails()
	{
		objLandingPage = objLandingPage.GoToSignIn().Login(EMAIL, PASSWORD);
	}	
	@Test
	public void PlaceOrder() throws InterruptedException, ParseException, IOException
	{
		ProductCatalogue objProductCatalogue=new ProductCatalogue(objWebDriver);
		objProductCatalogue.SelectMenTops(JACKETS,JACKETSQTY);
		objProductCatalogue.SelectMenBottoms(PANTS, PANTSQTY);
		CheckOutCartPage objCheckOutCartPage=objProductCatalogue.ViewCartItems();
		String[] totalItemNames=objCheckOutCartPage.GetTotalItemNames();
		Thread.sleep(3000);
		double totalAmount=objCheckOutCartPage.GetTotalAmount();
		CheckOutShipping objCheckOutShipping=objCheckOutCartPage.CheckOut();
		Thread.sleep(3000);
		CheckoutPage objCheckoutPage=objCheckOutShipping.ClickNext();
		Thread.sleep(5000);
		TakeScreenshot("CheckOutPaymentPage");
		objCheckoutPage.PlaceOrder();
		//Thread.sleep(3000);
		String currentOrderID= objCheckoutPage.GetOrderID();
		TakeScreenshot("OrderConfirmationPage");
		MyOrdersPage objMyOrdersPage=objCheckoutPage.GoToMyOrders();
		Boolean isOrderVerified=objMyOrdersPage.VerifyOrder(currentOrderID,totalItemNames,totalAmount);
		Assert.assertTrue(isOrderVerified);
	}		
	@AfterTest
	public void CleanUp()
	{
		objWebDriver.close();
	}
}
