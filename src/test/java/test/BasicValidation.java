package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicValidation {
	//webdriver declaration
	public static WebDriver driver;
	String url="https://www.facebook.com";
	
	//pre-activity
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get(url);
	}
	//post-activity
	@AfterTest
	public void teardown() {
		//Close browser at end of test
		driver.quit();
		
	}
	
	@Test
	public void WelcomeMessageValidation(){
		String expectedResult ="Facebook helps you connect and share with the people in your life.";
		String actualResult=driver.findElement(By.xpath("//h2[@class='_8eso']")).getText();
		Reporter.log("Expected Result=" + expectedResult);
		Reporter.log("Actual Result="+actualResult);
		
		//compare results
		assertTrue(actualResult.equals(expectedResult),"Mismatch in welcome message,");
		
		
	}
	
	private void assertTrue(boolean equals, String string) {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void emailTextBoxPlaceholderValidation() {
		String expectedResult = "Email address or phone number";
		String actualResult = driver.findElement(By.id("email")).getDomAttribute("placeholder");
		
		Reporter.log("Expected Result =  " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		//compare the results
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the email placeholder,");
	}
	
	@Test
	public void passwordTextBoxPlaceholderValidation() {
		String expectedResult = "Password";
		String actualResult = driver.findElement(By.id("pass")).getDomAttribute("placeholder");
		
		Reporter.log("Expected Result =  " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		//compare the results
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the password placeholder,");
	}
		
		
	}


