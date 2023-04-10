package Interview;

import static Helpers.Constants.JACKETS;
import static Helpers.Constants.JACKETSQTY;
import static Helpers.Constants.PANTS;
import static Helpers.Constants.PANTSQTY;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClassesInterviewPractice.ProductCatalogue;
import static Helpers.Constants.EMAIL;
import static Helpers.Constants.PASSWORD;

import java.io.IOException;

public class PurchaseProductsTest extends BaseTest {
	@BeforeTest
	public void LogInDetails() {
		objLandingPage = objLandingPage.GoToSignIn().Login(EMAIL, PASSWORD);
	}

	@Test
	public void ProductSelection() throws IOException, InterruptedException {
		int cartQuantity = 0;
		ProductCatalogue objProductCatalougue = new ProductCatalogue(objWebDriver);
		objProductCatalougue.SelectMenTops(JACKETS, JACKETSQTY);
		cartQuantity += JACKETSQTY;
		objProductCatalougue.SelectMenBottoms(PANTS, PANTSQTY);
		cartQuantity += PANTSQTY;
		objProductCatalougue.ItemsDisplayed();
		Thread.sleep(3000);
		TakeScreenshot("CartItemsList");
	}

	/*
	 * @Test public void RemoveProductsFromCart() throws InterruptedException {
	 * CheckOutCartPage objCheckOutCartPage = new CheckOutCartPage(objWebDriver);
	 * objCheckOutCartPage.RemoveItems();}
	 */

	@AfterClass
	public void CleanUp() {
		objWebDriver.close();
	}

}
