package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void verify_account_registration()
	{
		logger.info("**** starting TC_001_AccountRegistrationTest  *****");
		
		logger.debug("application logs started......");
		
		try
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");
			
			hp.clickRegister();
			logger.info("Clicked on registration link");
			
			
			logger.info("Entering customer details.. ");
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
			regpage.setTelephone(randomeNumber());
			//Thread.sleep(5000);
			
			String password=randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setPrivacyPolicy();
			//Thread.sleep(10000);
			regpage.clickContinue();
			//Thread.sleep(10000);
			logger.info("clicked on continue..");
			
			String confmsg=regpage.getConfirmationMsg();
			
			logger.info("Validating expected message..");
			
			Assert.assertEquals(confmsg, "Your Account Has Been Created!","Account creation failed");		
					
		}
		catch(Exception e)
		{
			logger.error("test failed..");
			logger.debug("debug logs....");
			System.out.println("Here " + e.getMessage());
			Assert.fail();
		}
		
		logger.debug("application logs end.......");
		logger.info("**** finished TC_001_AccountRegistrationTest  *****");
		
	}
	
	
	
	
}








