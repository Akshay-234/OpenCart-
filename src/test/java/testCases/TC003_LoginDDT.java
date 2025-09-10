package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void Verify_LoginDDT(String email,String pwd,String exp)
	{
		
       try
       {
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		 boolean  targetpage=macc.isMyAccountPageExists();
     
		 
		 if(exp.equalsIgnoreCase("Valid"))
		 {
			 if(targetpage==true)
			 {
				 macc.ClickLogout();
				 Assert.assertTrue(true);
			 }
			 else
			 {
				 Assert.assertTrue(false);
				 
				 
			 }
			 
			 if(exp.equalsIgnoreCase("Invalid"))
			 {
				 if(targetpage==true)
				 {
					 macc.ClickLogout();
					 Assert.assertTrue(false);
				 }
				 else  
				 {
					 Assert.assertTrue(true);  
				 }
				 
			 }
			 
		 }}
       catch(Exception e)
       {
    	   Assert.fail();
       }
	}
	
}
