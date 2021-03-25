package testCases;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass{

	@Test(groups= {"regression","master"})
	public void test_account_Registration()
	{
		logger.info("Starting TC_001_AccountRegistration ");
		
		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("HomePage Displayed");
			
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			
			hp.clickMyAccount();
			logger.info("Clicked On My Account");
			
			hp.clickRegister();
			logger.info("Clicked On Register");
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			
			regpage.setFirstName("John");
			logger.info("Provided FirstName");
			
			regpage.setLastName("Canedy");
			logger.info("Provided LastName");
			
			regpage.setEmail(randomestring()+"@gmail.com");
			logger.info("Provided Email");
			
			regpage.setTelephone("65656565");
			logger.info("Provided Telephone");
			
			regpage.setPassword("abcxyz");
			logger.info("Provided Password");
			
			regpage.setConfirmPassword("abcxyz");
			logger.info("Provided Confirmed Password");
			
			regpage.setPrivacyPolicy();
			logger.info("Set Privacy Policy");
			
			regpage.clickContinue();
			logger.info("Clicked On Continue");
			
			String confmsg=regpage.getConfirmationMsg();
			
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				logger.info("Account Registration Success");
				Assert.assertTrue(true);
			}
			else
			{
				captureScreen(driver,"test_account_Registration");
				logger.error("Account Registration Failed");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			logger.fatal("Account Registration Failed");
		    Assert.fail();
		}	
		logger.info("Finished TC_001_AccountRegistration");
	}
	
	
}
