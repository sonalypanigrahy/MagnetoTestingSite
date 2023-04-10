package rahulshettyautomationacademy.SeleniumFrameworkDesignPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EcommerceApplicationCopied {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.xpath("//input[@formcontrolname='userEmail']")).sendKeys("sonalypanigrahy14@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Sonaly@1996");
		driver.findElement(By.name("login")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> productslist=driver.findElements(By.cssSelector(".mb-3"));
		WebElement finalelement=productslist.stream().filter(product->product.findElement(By.tagName("b")).getText().equalsIgnoreCase("ADIDAS ORIGINAL")).findAny().orElse(null);
		finalelement.findElement(By.cssSelector("div button:last-of-type")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".subtotal .totalRow button")).click();
		driver.findElement(By.cssSelector(".form-group .input.txt.text-validated")).sendKeys("India");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-results button:last-of-type")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		String Text=driver.findElement(By.xpath("//td/h1")).getText();
		System.out.println(Text);
	}

}
