package suite.page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import suite.base.PageBase;

public class ChromeMobilePage extends PageBase {

	private WebDriver driver;

	public ChromeMobilePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements (driver, this);
	}

	@FindBy(xpath = "//android.widget.Button[@text='ACCEPT & CONTINUE']")
	private WebElement acceptBtn;

	@FindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private WebElement nextBtn;

	@FindBy(xpath = "//android.widget.Button[@index='0']")
	private WebElement noThanksBtn;

	@FindBy(xpath = "//android.widget.Button[@text='ALLOW']")
	private WebElement allowBtn;

	@FindBy(xpath = "//android.widget.EditText[@index='0']")
	private WebElement chromeSearchBox;

	@FindBy(xpath = "//android.widget.EditText[@text='Search or type web address']")
	private WebElement chromeSearchBoxUrl;

	public ChromeMobilePage clkAcceptBtn() {
		clickingElement(acceptBtn);
		return this;
	}

	public ChromeMobilePage clkNextBtn() {
		clickingElement(nextBtn);
		return this;
	}
	
	public ChromeMobilePage clkNoThanksBtn() {
		clickingElement(noThanksBtn);
		return this;
	}

	public ChromeMobilePage clkAllowBtn() {
		try {
			clickingElement(allowBtn);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this; //Need to handle 
	}

	public ChromeMobilePage clkChromeSearchBox() {
		clickingElement(chromeSearchBox);
		return this;
	}

	public ChromeMobilePage enterChromeSearchBoxUrl(String chromeUrl) {
		setText(chromeSearchBoxUrl, chromeUrl + "\\n");
		return this;
	}

}
