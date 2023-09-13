package ExcelFileDataprovide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelFileDataprovide {

	
	public String baseUrl = "https://www.saucedemo.com/";
	public WebDriver driver ;
	
	@BeforeMethod
	public void LaunchBrowser() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    this.driver = new ChromeDriver(); 
		this.driver.manage().window().maximize();
		this.driver.get(baseUrl);
		Thread.sleep(2000);
	}
	
	
	 @AfterMethod
     public void tearDown() throws InterruptedException {
         Thread.sleep(2000);
         this.driver.quit();
     }
	
	
	
	@Test(dataProvider="LoginTestData", dataProviderClass = ExcelDataSupplier.class)
	public void TestLogin (String username, String password) throws Exception  {

		
		WebElement UserName = driver.findElement(By.xpath("//input[@id='user-name']"));
		UserName.sendKeys(username);
		Thread.sleep(2000);

		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		Password.sendKeys(password);
		Thread.sleep(2000);
		

		WebElement LoginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		LoginButton.click();
		Thread.sleep(3000);
	}
	
	

	
	
	 
	 
}
