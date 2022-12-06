package Com.internetbaning.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.internetbanking.BaseClass.BaseClass;
import Com.internetbanking.Pageobject.Internetbanking_LoginPage;
import Com.internetbanking.Pageobject.TC_NewAccount_003;

public class TC_AccountCreation_003 extends BaseClass{

	@Test
public void AddNewAccount() throws InterruptedException, IOException {
	logger.info("URL is opened");

	Internetbanking_LoginPage LP=new Internetbanking_LoginPage();

	LP.Setusername(username);
	logger.info("Enter username");

	LP.SetPassword(password);
	logger.info("Enter Passsword");

	LP.Clickbtn();
	
	TC_NewAccount_003 NewAcount = new TC_NewAccount_003();
	
	NewAcount.Account();
	Thread.sleep(2000);
	logger.info("Click on NewAccount tab");

	driver.navigate().refresh();
	NewAcount.Account();
     
	
	NewAcount.AccountNumber("41986");
	logger.info("Enter Customer nuuber");

	Thread.sleep(2000);
	
	NewAcount.AccountDeposit("3000");
	logger.info("Enter deposit value");
	NewAcount.Submit();
	logger.info("Clcik on subit button");
	
	boolean Test=driver.findElement(By.xpath("//p[@class=\"heading3\"]")).isDisplayed();

	if(Test==true) {
		
		logger.info("Accoutn created");

		Assert.assertTrue(true);
	}
	else {
		getScreenshotAs("NewAccount");
		logger.info("Accoutn creatation failed");
		Assert.assertTrue(false);

	}
}
}
