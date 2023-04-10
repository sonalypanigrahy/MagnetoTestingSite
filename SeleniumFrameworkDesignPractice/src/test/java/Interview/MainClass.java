package Interview;

import java.text.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import BaseClassesInterviewPractice.CheckOutCartPage;
import BaseClassesInterviewPractice.CheckOutShipping;
import BaseClassesInterviewPractice.CheckoutPage;
import BaseClassesInterviewPractice.LandingPage;
import BaseClassesInterviewPractice.LoginPage;
import BaseClassesInterviewPractice.MyOrdersPage;
import BaseClassesInterviewPractice.ProductCatalogue;
import WebDriver.WebDriverSetup;
import static Helpers.Constants.EMAIL;
import static Helpers.Constants.PASSWORD;
import static Helpers.Constants.URL;
import static Helpers.Constants.JACKETS;
import static Helpers.Constants.JACKETSQTY;
import static Helpers.Constants.PANTS;
import static Helpers.Constants.PANTSQTY;

public class MainClass  {

	public static void main(String[] args) throws InterruptedException, ParseException  {

		//Setup Chrome WebDriver
		WebDriver objWebDriver=WebDriverSetup.SetupWebDriver();
		
		//Go to URL and click on Sign In button
		LandingPage objLandingPage=new LandingPage(objWebDriver);
		objLandingPage.GetURL(URL);
		objLandingPage.GoToSignIn();
		
		//Sign In 
		LoginPage objLoginPage = new LoginPage(objWebDriver);
		objLoginPage.Login(EMAIL, PASSWORD);
		
		//Select Jackets and pants
		int cartQuantity=0;
		ProductCatalogue objProductCatalougue=new ProductCatalogue(objWebDriver);
		objProductCatalougue.SelectMenTops(JACKETS,JACKETSQTY);
		cartQuantity+=JACKETSQTY;
		objProductCatalougue.SelectMenBottoms(PANTS,PANTSQTY);
		cartQuantity+=PANTSQTY;
		objProductCatalougue.ViewCartItems();
		
		//Verify Product and Price
		CheckOutCartPage objCheckOutCartPage=new CheckOutCartPage(objWebDriver);
		objCheckOutCartPage.IsSubTotalValid();
		objCheckOutCartPage.IsSummarySubTotalValid();
		objCheckOutCartPage.IsTotalAmountValid();
		String[] totalItemNames=objCheckOutCartPage.GetTotalItemNames();
		Double totalAmount=objCheckOutCartPage.GetTotalAmount();
		objCheckOutCartPage.CheckOut();
		
		
		//Fill the address for delivery and click Next
		CheckOutShipping objCheckOutShipping=new CheckOutShipping(objWebDriver);
		objCheckOutShipping.AddNewAddress();
		objCheckOutShipping.ClickNext();
		
		//Go for CheckOut and Get the order ID
		CheckoutPage objCheckoutPage=new CheckoutPage(objWebDriver);
		objCheckoutPage.PlaceOrder();
		String currentOrderID=objCheckoutPage.GetOrderID();
		objCheckoutPage.GoToMyOrders();
		
		//Verify Order in My Orders
		MyOrdersPage objMyOrdersPage=new MyOrdersPage(objWebDriver);
		Boolean isOrderVerified=objMyOrdersPage.VerifyOrder(currentOrderID,totalItemNames,totalAmount);
		Assert.assertEquals(isOrderVerified, true);
	}

}