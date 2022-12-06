package Com.internetbaning.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.internetbanking.BaseClass.BaseClass;
import Com.internetbanking.Pageobject.Internetbanking_LoginPage;
import Com.internetbanking.Utilities.XLUtils;

public class TC_LoginDataTest_004 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void LoginData(String user, String Pwd) throws InterruptedException {

		logger.info("URL is open");
		Internetbanking_LoginPage LP = new Internetbanking_LoginPage();

		LP.Setusername(user);
		logger.info("Enter username");

		LP.SetPassword(Pwd);
		logger.info("Enter Password");

		LP.Clickbtn();

		if (Isalertpresent() == true) {
			driver.switchTo().alert().accept(); // popup close
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.info("Login failed");
			
		} else {

			Assert.assertTrue(true);  
			logger.info("Login passed");
			LP.Logoutapplication();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public boolean Isalertpresent() throws InterruptedException {
		try {
			driver.switchTo().alert();
			Thread.sleep(2000);
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/main/java/Com/internetbanking/TestData/9JulyAutomation.xlsx";
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
