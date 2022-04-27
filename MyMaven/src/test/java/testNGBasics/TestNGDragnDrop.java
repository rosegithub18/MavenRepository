package testNGBasics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class TestNGDragnDrop {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDrivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test
	public void dragAndDrop() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Actions action = new Actions(driver);
		WebElement accntDrag = driver.findElement(By.xpath("(//*[@class='button button-orange'])[5]"));
		WebElement accntDrop = driver.findElement(By.xpath("(//*[@class='placeholder'])[1]"));
		action.dragAndDrop(accntDrag, accntDrop).build().perform();
		Thread.sleep(5000);
		//js.executeScript("window.scrollBy(0,-500)");
		WebElement amtDrag = driver.findElement(By.xpath("(//*[@class='button button-orange'])[2]"));
		WebElement amtDrop= driver.findElement(By.xpath("(//*[@class='placeholder'])[2]"));
		action.dragAndDrop(amtDrag, amtDrop).build().perform();
		Thread.sleep(5000);
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
		
	}

}
