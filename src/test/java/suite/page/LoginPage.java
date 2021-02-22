package suite.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class LoginPage extends PageBase {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * for getting page url of demo page
	 * 
	 * @param pageURL
	 * @return page url of the demo page
	 */
	public LoginPage getLoginPage(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
	}

	@FindBy(xpath = "*//input[@name='username']")
	private WebElement userNameTxtBox;

	@FindBy(id = "loginPage-password-input")
	private WebElement passwordTxtBox;

	@FindBy(id = "loginPage-signIn-button")
	private WebElement loginBtn;

	@FindBy(css = ".modal-body > div")
	private WebElement validationMessage;
	

	/**
	 * for entering the user name
	 * 
	 * @param username
	 * @return ob
	 */
	public LoginPage enterUserName(String username) {
		setText(userNameTxtBox, username);
		return this;
	}

	/**
	 * for entering the password
	 * 
	 * @param password
	 * @return object of current class 
	 */
	public LoginPage enterpassword(String password) {
		setText(passwordTxtBox, password);
		return this;
	}

	/**
	 * for clicking on login button
	 * 
	 * @return object of current class
	 */
	public LoginPage clickLoginBtn() {
		clickingElement(loginBtn);
		return this;

	}

	/**
	 * for getting the authentication validation message
	 * 
	 * @return validation message 
	 */
	public String getValidationMessage() {
		return getText(validationMessage);
	}
}
