package junit;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartJunit {
	static WebDriver driver;
	static long starttime ;
	@BeforeClass
	public static void launchBrowser() {
		System.out.println("beforeclass");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void searchMobile1() throws InterruptedException {
		WebElement email=driver.findElement(By.xpath("(//input[@autocomplete='off'])[2]"));
		email.sendKeys("9566207738");
		WebElement pass=driver.findElement(By.xpath("(//input[@autocomplete='off'])[3]"));
		pass.sendKeys("Oct@123456");
		WebElement login=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		login.click();
		Thread.sleep(10000);
		WebElement search=driver.findElement(By.xpath("//input[@autocomplete='off']"));
		search.sendKeys("mobiles");
		Thread.sleep(3000);
		WebElement enter=driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		enter.click();
		Thread.sleep(10000);

	}
	@Test
	public void searchMobile2() throws InterruptedException {
		WebElement realme=driver.findElement(By.xpath("//div[@class='_4rR01T']"));
		   String r= realme.getText();
		   System.out.println(r);
		   
		  String parwin= driver.getWindowHandle();
		  System.out.println(parwin);
		  realme.click();
		  Thread.sleep(5000);
		 Set<String> allwin= driver.getWindowHandles();
		 for (String x : allwin) {
			 if(!parwin.equals(x)) {
				 driver.switchTo().window(x);
				 

	}
		 }
	
		      }
	
	@Ignore
	@Test
	public void searchMobile3() {
		WebElement spec=driver.findElement(By.xpath("//div[text()='Specifications']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",spec );
		

	}
	
	@AfterClass
	public static void close() throws IOException {
		System.out.println("hi");
		TakesScreenshot ss=(TakesScreenshot) driver;
		File sourse=ss.getScreenshotAs(OutputType.FILE);
		File Target=new File("C:\\Users\\hp\\eclipse-workspace\\junit\\target\\screenShot.png");
		FileUtils.copyFile(sourse, Target);
		System.out.println("Helo");

		//	driver.close();
	}
	@Before
	public void beforemethod() {
		System.out.println("beforemethod");
		 starttime = System.currentTimeMillis();

	}
	@After
	public void aftermethod() {
		System.out.println("aftermethod");
		long endtime = System.currentTimeMillis();
		long time=endtime-starttime;
		System.out.println(time);

	}	

}
