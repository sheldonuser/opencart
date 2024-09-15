package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test
	public void registration()
	{
		try 
		{
		logger.info("Started executing TC001_AccountRegistrationTest");
		HomePage hp = new HomePage(driver);
		
		hp.myAccount();
		logger.info("Clicked on MyAccount button");
		hp.registration();
		logger.info("Clicked on Registration button");
		RegistrationPage rp=new RegistrationPage(driver);
		logger.info("Entering Customer Details");
		rp.firstname(randomString().toUpperCase());
		rp.lastname(randomString().toUpperCase());
		rp.email(randomString().toUpperCase()+"@gmail.com");
		rp.telephone(randomNumber());
		String pss=randomAlphaNumeric();
		rp.password(pss);
		rp.confirmpassword(pss);
		rp.agreechkbox();
		rp.continuebutton();
		logger.info("Registration completed");
		String conmessage=rp.successmsg();
		if(conmessage.equals("Your Account Has Been Created!"))
		{
			logger.info("Account created");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed...");
			logger.debug("debug logs");
			Assert.assertTrue(false);
		}
	    }
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
	
	
	
	
}
