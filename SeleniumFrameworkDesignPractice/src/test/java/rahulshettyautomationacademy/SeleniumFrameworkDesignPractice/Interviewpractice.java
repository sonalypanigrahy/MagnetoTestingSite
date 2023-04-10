package rahulshettyautomationacademy.SeleniumFrameworkDesignPractice;





import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Interviewpractice {
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://ui.cogmento.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String text=(String) js.executeScript("return document.title");
		System.out.println(text);
	}

}
