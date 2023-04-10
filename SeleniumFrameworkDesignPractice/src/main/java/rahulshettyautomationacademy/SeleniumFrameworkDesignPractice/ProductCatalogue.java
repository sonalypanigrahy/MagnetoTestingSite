package rahulshettyautomationacademy.SeleniumFrameworkDesignPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue extends AbstractPage{	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	By elementpresence=By.cssSelector(".mb-3");
	@FindBy(css=".mb-3")
	List<WebElement> totalproducts;
	By elechoose=By.tagName("b");
	By addtocartbutton=By.cssSelector("div button:last-of-type");
	public WebElement findElement(String productnameinList)
	{
		visibilityOf(elementpresence);
		WebElement finalelement=totalproducts.stream().filter(product->product.findElement(elechoose).getText().equalsIgnoreCase(productnameinList)).findAny().orElse(null);
		return finalelement;
	}
	public void addProducttoCart(String productnameinList)
	{
		WebElement prod= findElement(productnameinList);
		prod.findElement(addtocartbutton).click();
	}
}
