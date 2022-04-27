package testNGBasics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNGFileUploadRobotClass {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDrivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://resume.naukri.com/resume-quality-score");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void fileUpload() throws AWTException, InterruptedException {

		WebElement browser = driver.findElement(By.xpath("//span[@class='browse']"));
		browser.click();

		Robot rb = new Robot();
		//get the file path
		StringSelection filepath = new StringSelection("F:\\Selenium notes\\Actions and window handle.docx");
		// copy path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		//press cntrl+v for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_V);
		//release keys
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		rb.keyRelease(KeyEvent.VK_V);
		//press enter key
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		//release enter key
		rb.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("File Uploaded");

		Thread.sleep(3000);	

	}



	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
