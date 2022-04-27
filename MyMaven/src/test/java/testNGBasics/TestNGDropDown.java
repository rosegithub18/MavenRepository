package testNGBasics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class TestNGDropDown {
	WebDriver driver;

	@Test(priority=0)
	public void noOfPassengers() {
		WebElement passengerDrop = driver.findElement(By.name("passCount"));
		passengerDrop.click();
		Select select = new Select(passengerDrop);
		//select.selectByIndex(2); //By index
		//select.selectByValue("3"); //by value
		select.selectByVisibleText("2"); //by visible text
	}
	@Test(enabled=false)//doesnt execute if false
	public void departFrom() {
		WebElement departDrop = driver.findElement(By.name("fromPort"));
		departDrop.click();
		Select sel = new Select(departDrop);
		sel.selectByValue("London");
	}
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDrivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/reservation.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
