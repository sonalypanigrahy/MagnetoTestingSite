package Interview;

import static Helpers.Constants.EMAIL;
import static Helpers.Constants.JACKETS;
import static Helpers.Constants.JACKETSQTY;
import static Helpers.Constants.PANTS;
import static Helpers.Constants.PANTSQTY;
import static Helpers.Constants.PASSWORD;
import java.io.IOException;
import java.text.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClassesInterviewPractice.CheckOutCartPage;
import BaseClassesInterviewPractice.ProductCatalogue;

public class CartCheckoutTest extends BaseTest {

	@BeforeTest
	public void Log() {
		objLandingPage = objLandingPage.GoToSignIn().Login(EMAIL, PASSWORD);
	}

	@Test
	public void VerifyOrderSummary() throws ParseException, InterruptedException, IOException {
		ProductCatalogue objProductCatalougue = new ProductCatalogue(objWebDriver);
		objProductCatalougue.SelectMenTops(JACKETS, JACKETSQTY);
		objProductCatalougue.SelectMenBottoms(PANTS, PANTSQTY);
		CheckOutCartPage objCheckOutCartPage = objProductCatalougue.ViewCartItems();
		objProductCatalougue.ItemsDisplayed();
		Assert.assertTrue(objCheckOutCartPage.IsSubTotalValid());
		Assert.assertTrue(objCheckOutCartPage.IsSummarySubTotalValid());
		Assert.assertTrue(objCheckOutCartPage.IsTotalAmountValid());
		String[] totalItemNames = objCheckOutCartPage.GetTotalItemNames();
		Double totalAmount = objCheckOutCartPage.GetTotalAmount();
		TakeScreenshot("CartCheckout");
	}

	@AfterTest
	public void Cleanup() {
		objWebDriver.close();
	}
}
