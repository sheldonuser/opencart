package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test
	public void registration()
	{
		try 
		{
		logger.info("Started executing TC002_LoginTest");
		HomePage hp = new HomePage(driver);
		
		hp.myAccount();
		logger.info("Clicked on MyAccount button");
		hp.login();
		logger.info("Clicked on Login button");
		LoginPage lp =new LoginPage(driver);
		logger.info("Entering email address");
		lp.emailid(pr.getProperty("email"));
		logger.info("Entering password");
		lp.password(pr.getProperty("password"));
		logger.info("clicking on login");
		lp.login();
		logger.info("login");
		MyAccountPage maccp =new MyAccountPage(driver);
		
		boolean displayed=maccp.myAccountdisplayed();
		if(displayed == true)
		{
			logger.info("login successfull");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Login failed...");
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
