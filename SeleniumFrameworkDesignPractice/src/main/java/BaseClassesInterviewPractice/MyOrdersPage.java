package BaseClassesInterviewPractice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrdersPage extends AbstarctClass {
	WebDriver objWebdriver;
	 
	public MyOrdersPage(WebDriver driver) {
		super(driver);
		this.objWebdriver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(text(),'My Orders')]")
	WebElement weMyOrderslink;
	@FindBy(xpath="//tbody/tr/td[@data-th='Order #']")
	List<WebElement> listOrderIDs;
	@FindBy(css=".col.actions .action.view span")
	List<WebElement> listViewOrderlink;
	@FindBy(css=".col.name .product-item-name")
	List<WebElement> listProductItems;
	@FindBy(css=".amount strong .price")
	List<WebElement> listGrandTotal;
	public boolean VerifyOrder(String orderId, String[] names,double totalAmount) throws ParseException, InterruptedException
	{
		//visibilityOf(weMyOrderslink);
		weMyOrderslink.click();
		Boolean isAmountMatched=false;
		Boolean isItemsArrayMatched=false;
		String[] orderItems= {};
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(orderItems));  
		Thread.sleep(4000);
		for(int n=0;n<listOrderIDs.size();n++)
		{
			//System.out.println(listOrderIDs.get(n).getText());
			//System.out.println(orderId);
			if(listOrderIDs.get(n).getText().equals(orderId))
			{
				listViewOrderlink.get(n).click();
				isAmountMatched= totalAmount==priceConversion(listGrandTotal.get(n).getText());
				
				for(int k=0;k<listProductItems.size();k++)
				{
					arrayList.add(listProductItems.get(k).getText());
				}
				orderItems = arrayList.toArray(orderItems);  
				isItemsArrayMatched=Arrays.equals(names, orderItems);
				if((isItemsArrayMatched==true)&&(isAmountMatched==true))
					return true;
				else
					return false;
			}
		}
		return false;
		
	}
	
}
