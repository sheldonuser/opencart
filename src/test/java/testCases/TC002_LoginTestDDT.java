package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC002_LoginTestDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void registration(String email, String pwd, String exp) throws InterruptedException
	{
		try 
		{
		logger.info("*** Started executing TC002_LoginTestDDT ***");
		HomePage hp = new HomePage(driver);
		
		hp.myAccount();
		logger.info("Clicked on MyAccount button");
		hp.login();
		logger.info("Clicked on Login button");
		LoginPage lp =new LoginPage(driver);
		logger.info("Entering email address");
		lp.emailid(email);
		logger.info("Entering password");
		lp.password(pwd);
		logger.info("clicking on login");
		lp.login();
		logger.info("login");
		MyAccountPage maccp =new MyAccountPage(driver);
		
		boolean displayed=maccp.myAccountdisplayed();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(displayed == true)
			{
			logger.info("login successfull");
			maccp.logout();
			Assert.assertTrue(true);
			}else
				{
			logger.error("Login failed...");
			logger.debug("debug logs");
			
			Assert.assertTrue(false);
				}
		}
		
	 if(exp.equalsIgnoreCase("Invalid"))
		{
			if(displayed == true)
			{
			logger.info("login successfull");
			maccp.logout();
			Assert.assertTrue(false);
			}else
			{
			logger.error("Login failed...");
			logger.debug("debug logs");
			Assert.assertTrue(true);
			}	
		}
	  
		}catch(Exception e)
		  {
			Assert.fail();
		  }
		Thread.sleep(5000);
		logger.info("*** Finished TC002_LoginTestDDT ***");
	}
	
	
	
	
	
}
