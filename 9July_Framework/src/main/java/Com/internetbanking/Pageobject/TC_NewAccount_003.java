package Com.internetbanking.Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.internetbanking.BaseClass.BaseClass;

public class TC_NewAccount_003  extends BaseClass{

	//1
	public TC_NewAccount_003() {
		PageFactory.initElements(driver, this);
	}
	
	//2. 
	@FindBy(xpath = "//a[contains(text(),'New Account')]")
	WebElement NewAccount;
	
	@FindBy(name = "cusid")
	WebElement CustomerID;
	
	@FindBy(name = "inideposit")
	WebElement Deposit;
	
	@FindBy(name = "button2")
	WebElement Submitbutton;
	
	//3.
	
	public void Account() {
		NewAccount.click();
	}
	public void AccountNumber(String Number) {
		CustomerID.sendKeys(Number);
	}
	public void AccountDeposit(String Value) {
		Deposit.sendKeys(Value);
	}
	public void Submit() {
		Submitbutton.click();
	}
}
