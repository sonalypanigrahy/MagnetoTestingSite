package BaseClassesInterviewPractice;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstarctClass {
		WebDriver driver;
		public AbstarctClass(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public void action(WebElement ele)
		{
			Actions action=new Actions(driver);
			action.moveToElement(ele).build().perform();
		}
		public void visibilityOf(WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		public void visibilityOfElements(List<WebElement> element)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
		}
		public void VerifyElementClickable(WebElement ele)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele);
		}
		public void VerifyVisibilityOfElementLocated(By ele)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
		}
		public void actionforDropdown(WebElement ele,String text)
		{
			Actions action=new Actions(driver);
			action.moveToElement(ele).sendKeys(Keys.chord(Keys.LEFT,text)).click().build().perform();
		}
		public  double priceConversion(String text) throws ParseException
		{
			return Double.parseDouble(DecimalFormat.getCurrencyInstance(Locale.US).parse(text).toString());	
		}
}
