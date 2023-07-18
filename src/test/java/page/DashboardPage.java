package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import constants.Constants;
import testBase.WaitClass;

public class DashboardPage {

	private WebDriver driver;

	WaitClass wait;
	TradePage tp;

	@FindBy(xpath = "//a[@href=\"./dashboard\"]")
	WebElement dashboardButton;

	@FindBy(xpath = "//h3[@class=\"text-center mt-3 mb-2 pb-0\"]")
	WebElement totalValueHeading;

	@FindBy(xpath = "//a[@href=\"./about\"]")
	WebElement aboutButton;

	@FindBy(xpath = "//a[@data-rr-ui-event-key=\"/usdt\"]")
	WebElement balanceHeading;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitClass(driver);
	}

	String totalvalue = this.totalValueHeading.getText();

	public void doSuccessTrade() {
		tp.clickCoin();
		tp.enterAmount();
		tp.clickBuy();
		tp.closePopup.click();
	}

	public void navigateToDashboard() {
		this.dashboardButton.click();
	}

	public void isValueUpdated() {
		wait.waitForElement(this.totalValueHeading, Constants.wait);
		String actualText = totalValueHeading.getText();
		Assert.assertEquals(actualText, totalvalue);
	}
}
