package BaseClassesInterviewPractice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCartPage extends AbstarctClass {
	WebDriver objWebdriver;
	Locale locale=Locale.US;
	public CheckOutCartPage(WebDriver driver) {
		super(driver);
		this.objWebdriver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".item-info")
	List<WebElement> listTotalProducts;
	@FindBy(css=".price .cart-price .price")
	List<WebElement> listProductPrice;
	@FindBy(css=".input-text.qty")
	List<WebElement> listProductQuantity;
	@FindBy(css=".subtotal .cart-price .price")
	List<WebElement> listCartProductSubtotal;
	@FindBy(css="span[data-th='Subtotal']")
	WebElement weCartSummarySubtotal;
	@FindBy(css=".action.delete")
	List<WebElement> listDeleteButtons;
	@FindBy(css=".grand .price")
	WebElement weCartOrderTotal;
	//@FindBy(xpath="//tbody/tr[3]/td[1]/strong/span")
	//WebElement weCartOrderTotal;
	//By weCartOrderTotal1=By.xpath("//tbody/tr[3]/td[1]/strong/span");
	
	@FindBy(css=".col.item .product-item-details .product-item-name a")
	List<WebElement> listCartProductItems;
	@FindBy(css=".action.primary.checkout span")
	WebElement weCheckOutButton;
	@FindBy(xpath="//span[@data-th='Shipping']")
	List<WebElement> listCartSummaryShippingRate;
	@FindBy(xpath="//td[@data-th='Discount']/span")
	List<WebElement> listDiscount;
	public int GetCartItemQuantity()
	{
		int cartItmQty=0;
		for(WebElement productquantity:listProductQuantity)
		{
			cartItmQty+=Integer.parseInt(productquantity.getAttribute("value"));
		}
		return cartItmQty;
	}
	
	public boolean IsSubTotalValid() throws ParseException
	{
		for(int j=0;j<listTotalProducts.size();j++)
		{
			WebElement productprice=listProductPrice.get(j);
			double eachprodprice=priceConversion(productprice.getText());
			WebElement eachproductquantity=listProductQuantity.get(j);
			double quantityamount=Integer.parseInt(eachproductquantity.getAttribute("value"));
			WebElement productsubtotal=listCartProductSubtotal.get(j);
			double eachproductsubtotal=priceConversion(productsubtotal.getText());
			if(eachprodprice*quantityamount==eachproductsubtotal)
			{
				return true;
			}

		}
		return false;
	}
	public boolean IsSummarySubTotalValid() throws ParseException
	{	
		long cartProductSubTotalValue=0;
		for(WebElement cartProductSubTotal:listCartProductSubtotal)
		{
			cartProductSubTotalValue+=priceConversion(cartProductSubTotal.getText());
		}
		visibilityOf(weCartSummarySubtotal);
		return cartProductSubTotalValue==priceConversion(weCartSummarySubtotal.getText());
	}
	
	public boolean IsTotalAmountValid() throws ParseException, InterruptedException
	{	
		//visibilityOf(weCheckOutButton);
		
		double totalValue=priceConversion((weCartOrderTotal).getText());
		System.out.println(totalValue);
		double subTotal= priceConversion(weCartSummarySubtotal.getText());
		double discount = 0,shippingrate=0;
		if(! listDiscount.isEmpty())
		{
			 discount=priceConversion(listDiscount.get(0).getText());
		}
		if(! listCartSummaryShippingRate.isEmpty())
		{
			shippingrate=priceConversion(listCartSummaryShippingRate.get(0).getText());
		}
		return subTotal+shippingrate+discount ==totalValue;
	}
	public CheckOutShipping CheckOut() throws InterruptedException
	{
		visibilityOf(weCheckOutButton);
		weCheckOutButton.click();
		return new CheckOutShipping(objWebdriver);
	}
	public double GetTotalAmount() throws ParseException, InterruptedException
	{
		return priceConversion(weCartOrderTotal.getText()); 
	}
	public String[] GetTotalItemNames()
	{
		String[] totalItems= {};
		ArrayList<String> arrayList = new ArrayList<String>();  
		for(int i=0;i<listCartProductItems.size();i++)
		{
			arrayList.add(listCartProductItems.get(i).getText());
		}
		return arrayList.toArray(totalItems);
	}
	public void RemoveItems() throws InterruptedException
	{
		ProductCatalogue objProductCatalogue=new ProductCatalogue(objWebdriver);
		objProductCatalogue.ViewCartItems();
		//Thread.sleep(4000);
		visibilityOfElements(listTotalProducts);
		for(int j=0;j<listTotalProducts.size();j++)
		{
			listDeleteButtons.get(j).click();
		}
	}
}
