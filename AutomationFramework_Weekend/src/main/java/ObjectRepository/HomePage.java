package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	
	@FindBy(partialLinkText = "Books")
	private WebElement ClickOnBooks;
	
	@FindBy(partialLinkText = "Computers")
	private WebElement ClickOnComputers;
	
	@FindBy(partialLinkText = "Electronics")
	private WebElement ClickOnElectronics;
	
		public WebElement getClickOnElectronics() {
		return ClickOnElectronics;
	}

	public WebElement getClickOnComputers() {
		return ClickOnComputers;
	}

	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getClickOnBooks() {
		return ClickOnBooks;
	}
	
	

}
