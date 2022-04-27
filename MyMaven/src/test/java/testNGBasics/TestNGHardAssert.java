package testNGBasics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNGHardAssert {
	WebDriver driver;
	@Test(priority=0)
	public void verifyTheCurrentURLOfThePage() {
		String expectedURL = "https://qalegend.com/restaurant/login";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL,expectedURL);

	}
	@Test(priority=1)
	public void verifyThePageTitle()
	{
		String expectedTitle = "POS Login";

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);

	}
	@Test(priority=2)
	public void verifyTheUSerNameAfterSuccessfulLogin() {
		WebElement userName = driver.findElement(By.xpath("//*[@placeholder='Username']"));
		userName.sendKeys("admin");
		WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
		password.sendKeys("password");
		WebElement loginBtn = driver.findElement(By.name("submit"));
		loginBtn.click();
		WebElement name = driver.findElement(By.xpath("//span[contains(text(),'admin Doe')]"));  
		String expectedName = "  admin Doe";
		String actualName = name.getText();
		Assert.assertEquals(actualName, expectedName);
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDrivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://qalegend.com/restaurant/login");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
