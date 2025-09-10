package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		
		logger.info("****** Starting TC001_AccountRegistrationTest ***** ");
		
	    HomePage hp=new HomePage(driver);
	    hp.clickMyAccount();
	    logger.info("Clicked on Myaccountlink");
	    hp.clickRegister();
	    logger.info("Clicked on Registerlink");
	    
	    
	    AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
	    
	    logger.info("Providing customer details...");
		regpage.setFirstName( randomeString().toUpperCase());
		regpage.setLastName( randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");//randomly generated email
		regpage.setTelephone( randomeNumber());
		
		
		String password= randomeAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivatePolicy();
		regpage.clickcontinue();
	    
		logger.info("****** Finished TC001_AccountRegistrationTest ****");
		
	    }
	
	
}
