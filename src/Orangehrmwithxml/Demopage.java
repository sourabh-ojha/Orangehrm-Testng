package Orangehrmwithxml;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demopage {
	
	WebDriver driver;
	
	@Parameters({"url", "fullname", "businessemail", "phonenumber"})
	@Test
	void getUrl(String url, String fullname , String businessemail , String phonenumber) throws InterruptedException {
		
		int sleeptime = 2000;
		driver = new ChromeDriver();
		
		driver.get(url);
		
		Thread.sleep(sleeptime);
		driver.manage().window().maximize();
		
		Thread.sleep(sleeptime);
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/ul/li[1]/a")).click();
		
		Thread.sleep(sleeptime);
		driver.findElement(By.id("Form_getForm_FullName")).sendKeys(fullname);

		Thread.sleep(sleeptime);
		driver.findElement(By.id("Form_getForm_Email")).sendKeys(businessemail);

		Thread.sleep(sleeptime);
		driver.findElement(By.xpath("//*[@id=\"Form_getForm_Country\"]")).click();

		Thread.sleep(sleeptime);
//		driver.findElement(By.xpath("//*[@id=\"Form_getForm_Country\"]")).click();
		driver.findElement(By.id("Form_getForm_Country")).click();

		WebElement el = driver.findElement(By.id("Form_getForm_Country"));
		Select obj = new Select(el);
		obj.selectByVisibleText("United States");
		
		Thread.sleep(sleeptime);
		driver.findElement(By.id("Form_getForm_Contact")).sendKeys(phonenumber);

//		Thread.sleep(sleeptime);
//		driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).isSelected();

		Thread.sleep(sleeptime);
		driver.findElement(By.xpath("//*[@id=\"Form_getForm_action_submitForm\"]")).click();

		Thread.sleep(sleeptime);
		driver.close();
		
	}

}
