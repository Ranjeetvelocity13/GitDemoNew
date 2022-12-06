package Com.internetbaning.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import Com.internetbanking.BaseClass.BaseClass;
import Com.internetbanking.Pageobject.Internetbanking_LoginPage;
import Com.internetbanking.Utilities.XLUtils;


public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		logger.info("URL is opened");

		Internetbanking_LoginPage LP=new Internetbanking_LoginPage();

		LP.Setusername(username);
		logger.info("Enter username");

		LP.SetPassword(password);
		logger.info("Enter Passsword");

		LP.Clickbtn();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			System.out.println("Hello");
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			LP.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();			
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/9JulyTestData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
		
	return logindata;
	
	}
	
}
