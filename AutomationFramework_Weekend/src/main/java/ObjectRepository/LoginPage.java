package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="Email")
	private WebElement emailTxtfield;
	
	@FindBy(id="Password")
	private WebElement passwordTxtfield;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement loginBtn;
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailTxtfield() {
		return emailTxtfield;
	}

	public WebElement getPasswordTxtfield() {
		return passwordTxtfield;
	}
	
	

}
