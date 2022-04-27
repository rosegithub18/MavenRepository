package testNGBasics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestNGAlerts {
	WebDriver driver;

	@BeforeMethod//execute beforeMethod for each Test cases
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDrivers\\chromedriver_win32 (1)\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
		driver.manage().window().maximize();

	}
	@Test(priority=0)
	public void simpleAlert() throws InterruptedException {

		WebElement clickMeButton = driver.findElement(By.xpath("//*[@class='btn btn-success']"));
		clickMeButton.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	}

	@Test(priority=1)
	public void scollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");

	}

	@Test(priority=2)
	public void textAlert() throws InterruptedException {

		WebElement promptBoxElement = driver.findElement(By.xpath("//*[@class='btn btn-danger']"));
		promptBoxElement.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys("Rose");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}




	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
