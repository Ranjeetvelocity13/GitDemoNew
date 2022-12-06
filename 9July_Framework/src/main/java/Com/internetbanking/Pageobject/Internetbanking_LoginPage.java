package Com.internetbanking.Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.internetbanking.BaseClass.BaseClass;

public class Internetbanking_LoginPage extends BaseClass{

	
  //1.
  public Internetbanking_LoginPage() {
	  
	  PageFactory.initElements(driver,this);
  }
  
  //2.
  @FindBy(name = "uid")
  public WebElement Username;
  
  @FindBy(xpath = "//input[@name=\"password\"]")
  public WebElement Password;
  
  @FindBy(name = "btnLogin")
  public WebElement LoginBtn;
  
  @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
  
  //3.
  public void Setusername(String Uname) {
	  Username.sendKeys(Uname);
  }
  
  public void SetPassword(String Pwd) {
	  
	  Password.sendKeys(Pwd);
  }
  
  public void Clickbtn() {
	  LoginBtn.click();
	  
  }
	public void clickLogout()
	{
		lnkLogout.click();
	}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
