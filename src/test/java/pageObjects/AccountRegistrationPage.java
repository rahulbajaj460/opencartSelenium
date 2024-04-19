package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	

	@FindBy(xpath="//input[@id='input-firstname']") 
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']") 
	WebElement txtLasttname;
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtPasswordConfirm;
	
	@FindBy(xpath="//input[@name='agree']") 
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;


	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	
	}

	public void setLastName(String lname) {
		txtLasttname.sendKeys(lname);
	
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	
	}
	
	public void setTelephone(String number) {
		txtTelephone.sendKeys(number);	
		
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
		txtPasswordConfirm.sendKeys(pwd);
		
	}
	
	
	public void setPrivacyPolicy() {
		//chkdPolicy.click();
		
		Actions act=new Actions(driver);
		act.moveToElement(chkdPolicy).click().perform();
		
	}
	
	public void clickContinue() {
		//sol1 
		btnContinue.click();
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click;", btnContinue);
		
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
	
		}
	
	}
}
