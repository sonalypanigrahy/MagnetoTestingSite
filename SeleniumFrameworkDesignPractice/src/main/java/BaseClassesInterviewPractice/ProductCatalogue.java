package BaseClassesInterviewPractice;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue extends AbstarctClass {
	WebDriver objWebdriver;
	 Random rnd = new Random();
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.objWebdriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.level-top")
	List<WebElement> listCategories;

	@FindBy(css = ".parent .category-item a")
	List<WebElement> listSubCategories;
	
	@FindBy(xpath = "//span[text()='Men']")
	WebElement weHeaderMen;
	@FindBy(xpath = "//nav/ul/li[3]/ul/li[1]")
	WebElement weHeaderMenTops;
	@FindBy(xpath = "//nav/ul/li[3]/ul/li[2]")
	WebElement weHeaderMenBottoms;
	@FindBy(xpath = "//nav/ul/li[3]/ul/li[1]/ul/li")
	List<WebElement> listItemsUnderMenTops;
	@FindBy(xpath = "//nav/ul/li[3]/ul/li[2]/ul/li")
	List<WebElement> listItemsUnderMenBottoms;
	@FindBy(css = ".product-items .item.product.product-item")
	List<WebElement> listItemsUnderJackets;
	@FindBy(xpath = "//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li")
	List<WebElement> listItemsUnderPants;
	@FindBy(css = ".swatch-option.text")
	List<WebElement> listSizeOptions;
	@FindBy(css = ".swatch-option.color")
	List<WebElement> listColorOptions;
	@FindBy(css = "#qty")
	WebElement weQty;
	@FindBy(css = ".tocart")
	WebElement weAddToCartButton;
	@FindBy(xpath = "//div[@class='messages']/div")
	WebElement weMessage;
	@FindBy(css=".action.showcart")
	WebElement weCartButton;
	@FindBy(id="top-cart-btn-checkout")
	WebElement weCheckOutButton;
	@FindBy(xpath="//span[contains(text(),'View and Edit Cart')]")
	WebElement weViewCartButton;
	@FindBy(css=".minicart-items")
	WebElement items;
	@FindBy(id="#top-cart-btn-checkout")
	WebElement weCheckoutButton;
	
	public void SelectRandomSize() {

		int sizeselectedindex = rnd.nextInt(listSizeOptions.size() - 1);
		listSizeOptions.get(sizeselectedindex).click();
	}

	public void SelectRandomColor() {

		int colorselectedindex = rnd.nextInt(listColorOptions.size() - 1);
		listColorOptions.get(colorselectedindex).click();
	}

	public void SelectQuantity(int quantity) {
		weQty.clear();
		weQty.sendKeys(Integer.toString(quantity));
	}

	public void SelectMenTops(String menTopType, int quantity) {

		action(weHeaderMen);
		action(weHeaderMenTops);
		WebElement weHeaderJackets = listItemsUnderMenTops.stream()
				.filter(option -> option.getText().equalsIgnoreCase(menTopType)).findAny().orElse(null);
		weHeaderJackets.click();
		visibilityOfElements(listItemsUnderJackets);
		int jacketsSelectedIndex = rnd.nextInt(listItemsUnderJackets.size() - 1);
		listItemsUnderJackets.get(jacketsSelectedIndex).click();
		visibilityOfElements(listSizeOptions);
		SelectRandomSize();
		visibilityOfElements(listColorOptions);
		SelectRandomColor();
		SelectQuantity(quantity);
		weAddToCartButton.click();
		visibilityOf(weMessage);
	}

	public void SelectMenBottoms(String menBottomType, int quantity) {
		action(weHeaderMen);
		action(weHeaderMenBottoms);
		WebElement weHeaderPants = listItemsUnderMenBottoms.stream()
				.filter(option -> option.getText().equalsIgnoreCase(menBottomType)).findAny().orElse(null);
		weHeaderPants.click();
		visibilityOfElements(listItemsUnderPants);
		int pantselectedindex = rnd.nextInt(listItemsUnderPants.size()-1);
		listItemsUnderPants.get(pantselectedindex).click();
		visibilityOfElements(listSizeOptions);
		SelectRandomSize();
		visibilityOfElements(listColorOptions);
		SelectRandomColor();
		SelectQuantity(quantity);
		weAddToCartButton.click();
		visibilityOf(weMessage);
	}
	public CheckOutCartPage ViewCartItems() throws InterruptedException
	{
		ItemsDisplayed();
		visibilityOf(items);
		visibilityOf(weViewCartButton);
		weViewCartButton.click();
		return new CheckOutCartPage(objWebdriver);
	}
	public void ItemsDisplayed() throws InterruptedException
	{
		Thread.sleep(4000);
		weCartButton.click();
	}
	public CheckOutShipping GoForCheckOut() throws InterruptedException
	{
		ItemsDisplayed();
		weCheckoutButton.click();
		return new CheckOutShipping(objWebdriver);
	}
}

