package page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import constants.Constants;
import testBase.WaitClass;

public class BalancePage {
	private WebDriver driver;

	WaitClass wait;
	LoginPage lp;
	TradePage tp;

	@FindBy(xpath = "//div//h3[@class=\"text-center mt-3 mb-2 pb-0\"]")
	public WebElement totalValueHeading;

	@FindBy(xpath = "//*[@id=\"navbar\"]/span[2]/text()[2]")
	public WebElement balanceValue;

	@FindBy(xpath = "//a[@href=\"./dashboard\"]")
	WebElement dashboardButton;

	public BalancePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitClass(driver);
	}

	String balance = this.balanceValue.getText();

	public void isOnDashBoard() throws IOException {
		lp.enterValidCredentials();
		lp.clickLogin();
		wait.waitForElement(this.totalValueHeading, Constants.wait);
		String actualText = totalValueHeading.getText();
		String expectText = "Total Value: $";
		Assert.assertEquals(actualText, expectText);
	}

	public void viewBalance() {
		wait.waitForElement(this.balanceValue, Constants.wait);
		String actualText = this.balanceValue.getText();
		Assert.assertTrue(actualText != null);
	}

	public void doSuccessTrade() {
		tp.clickCoin();
		tp.enterAmount();
		tp.clickBuy();
		tp.closePopup.click();
		this.dashboardButton.click();
	}

	public void isBalanceUpdated() {
		wait.waitForElement(this.balanceValue, Constants.wait);
		String actualText = this.balanceValue.getText();
		Assert.assertNotEquals(actualText, balance);
	}
}
