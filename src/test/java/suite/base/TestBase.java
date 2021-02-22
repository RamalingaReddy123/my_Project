package suite.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import suite.init.SessionInit;
import suite.listener.WebDriverListener;

/**
 * This is Test Base class for automation framework contains all the common test
 * prerequisites for automation
 * 
 * @author arth
 *
 */
public class TestBase extends EnvBase {

	private WebDriver driver;
	private WebDriverWait wait;
	private EventFiringWebDriver eventHandler;
	private WebDriverListener ecapture;
	private String browserLang;

	/**
	 * Initiate the enviroment url
	 * 
	 * @param env
	 */
	@Parameters({ "env" })
	@BeforeClass
	public void setUpEnv(@Optional("qa") String env) {
		setEnv(env);
	}

	/**
	 * Setting the browser
	 * 
	 * @param browser
	 */
	@Parameters({ "browser" })
	@BeforeMethod
	public void setDriver(@Optional("chrome") String browser) {

		SessionInit.getDriverSession().initiateBrowserSession(browser);
		this.driver = SessionInit.getDriverSession().getBrowserSession();

		this.eventHandler = new EventFiringWebDriver(driver);
		this.ecapture = new WebDriverListener();
		this.eventHandler.register(ecapture);
		this.browserLang = browser;
	}

	/**
	 * for closing the browser
	 */
	@AfterMethod
	public void tearDown() {
		this.eventHandler.unregister(ecapture);
		SessionInit.getDriverSession().terminateBrowserSession(driver);
	}

	/**
	 * Loading browser instance
	 * 
	 * @return
	 */
	public EventFiringWebDriver getDriver() {
		return this.eventHandler;
	}

	@Override
	public String getEnv() {
		return super.getEnv();
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public String getBrowserLang() {
		return browserLang;
	}
}
