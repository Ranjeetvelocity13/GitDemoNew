package Com.internetbaning.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.internetbanking.BaseClass.BaseClass;
import Com.internetbanking.Pageobject.InternertBanking_addcutomerpage;
import Com.internetbanking.Pageobject.Internetbanking_LoginPage;
import net.bytebuddy.utility.RandomString;

public class NewCutomerTest extends BaseClass{

@Test
	public void AddnewCutomer() throws InterruptedException, IOException {
     	logger.info("URL is opened");

		Internetbanking_LoginPage LP=new Internetbanking_LoginPage();
		//
		LP.Setusername(username);
		logger.info("Enter username");

		LP.SetPassword(password);
		logger.info("Enter Passsword");

		LP.Clickbtn();
		
		Thread.sleep(3000);
		
		InternertBanking_addcutomerpage Addcust =new InternertBanking_addcutomerpage();
		
		Addcust.ClickaddNewCustomer();
		logger.info("Clcik on addnew customer tab");

		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		
		Addcust.ClickaddNewCustomer();
		logger.info("Clcik on addnew customer tab");

		Addcust.Custname("Tom");
		logger.info("Enter customer name");

		Addcust.CustGender();
		logger.info("Select gender");

		Addcust.Custdob("12", "05", "1999");
		logger.info("Select DOB");

		Thread.sleep(2000);

		Addcust.CustAddress("snheahomes");
		logger.info("Enter Address");

		Addcust.CustCity("Pune");
		logger.info("Select city");

		Addcust.CustState("MH");
		logger.info("Select State");

		Addcust.CustPinno("411018");
		logger.info("Select Pinno");

		Addcust.CustMobile("23456789");	
		logger.info("Enter mobile number");

		String Random = RandomString.make(6);

		String email =Random+"@gmail.com";
		Addcust.CustEmail(email);
		logger.info("Enter email address");


		Addcust.CustPassword("QWERTYU");
		logger.info("Enter password");
		Thread.sleep(2000);

		Addcust.CustSubmit();
		logger.info("Click on submit button");

		Thread.sleep(2000);

		boolean Test=driver.findElement(By.xpath("//p[contains(text(),'Customer Registered Successfully!!!')]")).isDisplayed();
		
		if(Test=true) {
			logger.info("User created");
			AssertJUnit.assertTrue(true);	
		
		}
		else {					
			logger.info("USer creation failed");
			getScreenshotAs("Addcustomer");
			AssertJUnit.assertTrue(false);
		}
		
	}
}
