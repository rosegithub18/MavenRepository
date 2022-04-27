package testNGBasics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNGRadioButton {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDrivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/reservation.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test
	public void radioButton() {
		WebElement onewayRadio = driver.findElement(By.xpath("//*[@value='oneway']"));
		//System.out.println(onewayRadio.isDisplayed());//to check element is displayed or not

		onewayRadio.click();
		System.out.println(onewayRadio.isSelected());//element is selected or not


		WebElement agileProjectLink = driver.findElement(By.xpath("//*[contains(text(),'Agile')]"));
		System.out.println(agileProjectLink.isDisplayed());
	}


	@AfterMethod
	public void afterMethod() {
	}

}
