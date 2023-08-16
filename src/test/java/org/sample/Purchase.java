package org.sample;

import java.util.concurrent.TimeUnit;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Purchase {
	
	static WebDriver driver;
	@BeforeClass
	public static void browserlanched(){
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-popups");
		options.addArguments("--remote-allow-origins");
		options.addArguments("--disable-notifications");
		options.addArguments("--no-sendbox");
		options.addArguments("--disable-dev-sim-usage");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://www.flipkart.com/");
	}
	
	@Before
	public void before() {
		System.out.println("Before Method");
	}
	
	@After
	public void after() {
		System.out.println("After Method");
	}
	
	@Test
	public void login() {
		try {
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//button[text()='✕']")).click();
		}
		catch(Exception e) {
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//span[text()='Appliances']")).click();
		}
//		finally {
//			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//			driver.findElement(By.xpath("//span[text()='Appliances']")).click();
//		}
	}
	@Test
	public void searchProducts() {
		try {
		driver.findElement(By.name("q")).sendKeys("watches");
		driver.findElement(By.className("L0Z3Pu")).click();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
		
	@Test
	public void productsDetails() {
		try {
		List<WebElement> watches = driver.findElements(By.xpath("(//div[@class='_2B099V'])[1]"));
		for(int i=0;i<watches.size();i++) {
			WebElement watch = watches.get(i);
			String text=watch.getText();
			
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
	@AfterClass
	public static void closebrowser() {
		driver.quit();
	}	

}
