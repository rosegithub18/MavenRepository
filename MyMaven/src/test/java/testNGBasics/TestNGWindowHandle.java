package testNGBasics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestNGWindowHandle {
	WebDriver driver;

	@BeforeClass 

	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDrivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@BeforeMethod
	public void beforeMethod() {

		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
	}

	@Test
	public void windowHandle() {
		String parentWindow = driver.getWindowHandle();
		WebElement newTab = driver.findElement(By.xpath("//*[@id='tabButton']"));
		newTab.click();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> toIterate = allWindows.iterator();
		while(toIterate.hasNext())
		{
			String childWindows = toIterate.next();
			if(!parentWindow.equalsIgnoreCase(childWindows))
			{
				driver.switchTo().window(childWindows);
				WebElement message = driver.findElement(By.id("sampleHeading"));
				System.out.println(message.getText()); 

			}
		}

		driver.switchTo().window(parentWindow);

	}



	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}
}


