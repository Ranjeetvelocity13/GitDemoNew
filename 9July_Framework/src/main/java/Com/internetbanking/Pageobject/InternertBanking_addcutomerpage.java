package Com.internetbanking.Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.internetbanking.BaseClass.BaseClass;

public class InternertBanking_addcutomerpage extends BaseClass {

	
	public InternertBanking_addcutomerpage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//2.
	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement AddNewcutomer;
	
	@FindBy(name = "name")
	WebElement CutomerName;
	
	@FindBy(name = "rad1")
	WebElement Gender;
	
	@FindBy(id = "dob")
	WebElement DOB;
	
	@FindBy(name = "addr")
	WebElement address;
	
	@FindBy(name = "city")
	WebElement TCity;
	
	@FindBy(name = "state")
	WebElement TState;
	
	@FindBy(name = "pinno")
	WebElement Pinno;
	
	@FindBy(css = "[name=\"telephoneno\"]")
	private WebElement MobileNo;
	
	@FindBy(css = "[name=\"emailid\"]")
	private WebElement Email;
	
	@FindBy(css = "[name=\"password\"]")
	private WebElement Password;
	
	@FindBy(css = "[name=\"sub\"]")
	private WebElement Submit;
	

	public void ClickaddNewCustomer() {
		AddNewcutomer.click();
	}
	
	public void Custname(String Cname) {
		CutomerName.sendKeys(Cname);
	}
	
	public void CustGender() {
	Gender.click();
	}
	public void Custdob(String DD,String MM,String yy) {
		DOB.sendKeys(DD);
		DOB.sendKeys(MM);
		DOB.sendKeys(yy);

	}
	public void CustAddress(String caddress) {
		address.sendKeys(caddress);
	}
	public void CustPinno(String Cpinno) {
		Pinno.sendKeys(Cpinno);
	}
	public void CustState(String Cstate) {
		TState.sendKeys(Cstate);
	}
	
	public void CustCity(String CCity) {
		TCity.sendKeys(CCity);
	}
	public void CustMobile(String Cmobileno) {
		MobileNo.sendKeys(Cmobileno);
	}
	public void CustEmail(String CEmail) {
		Email.sendKeys(CEmail);
	}	
	public void CustPassword(String CPassword) {
		Password.sendKeys(CPassword);
	}
	public void CustSubmit() {
		Submit.click();
	}
	
}
