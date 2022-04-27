package testNGBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGIframe {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDrivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test()
	public void switchToiFrame() throws InterruptedException {
		WebElement iFrame = driver.findElement(By.id("a077aa5e"));
		driver.switchTo().frame(iFrame);
		WebElement image = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
		image.click();
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
	}


	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
