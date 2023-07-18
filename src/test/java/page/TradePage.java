package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import constants.Constants;
import testBase.WaitClass;

public class TradePage {
private WebDriver driver ;
	
	WaitClass wait;
	
	@FindBy(xpath = "")
	public WebElement usdtCoin;
	
	@FindBy(xpath = "")
	public WebElement btcCoin;
	
	@FindBy(xpath = "")
	public WebElement randomCoin;
	
	@FindBy(xpath = "")
	public WebElement amountUsdField;
	
	@FindBy(xpath = "")
	public WebElement amountCoinField;
	
	@FindBy(xpath = "")
	public WebElement buyButton;
	
	@FindBy(xpath = "")
	public WebElement sellButton;
	
	@FindBy(xpath = "")
	public WebElement successPopup;
	
	@FindBy(xpath = "")
	public WebElement failPopup;
	
	@FindBy(xpath = "")
	public WebElement currentPriceValue;
	
	@FindBy(xpath = "")
	public WebElement closePopup;
	
	
	public TradePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		wait = new WaitClass(driver);
	}
	
	public void clickCoin() {
		wait.waitForElement(this.usdtCoin, Constants.wait);
		this.usdtCoin.click();
	}
	
	public void clickBtcCoin() {
		wait.waitForElement(this.btcCoin, Constants.wait);
		this.usdtCoin.click();
	}
	
	public void clickRandomCoin() {
		wait.waitForElement(this.randomCoin, Constants.wait);
		this.randomCoin.click();
	}
	
	public void enterAmount() {
		wait.waitForElement(this.amountCoinField, Constants.wait);
		this.amountCoinField.sendKeys(Constants.amount);
	}
	
	public void clickSell() {
		wait.waitForElement(this.sellButton, Constants.wait);
		this.buyButton.click();
	}
	
	public void clickBuy() {
		wait.waitForElement(this.buyButton, Constants.wait);
		this.buyButton.click();
	}
	
	public void isTradeSuccess() {
		wait.waitForElement(this.successPopup, Constants.wait);
		String actualText = this.successPopup.getText();
		String expectText = "";
		Assert.assertEquals(actualText, expectText);
	}
	
	public void isTradeFail() {
		wait.waitForElement(this.failPopup, Constants.wait);
		String actualText = this.failPopup.getText();
		String expectText = "";
		Assert.assertEquals(actualText, expectText);
	}
	
	public void enterAmount(String amount) {
		wait.waitForElement(this.amountCoinField, Constants.wait);
		this.amountCoinField.sendKeys(amount);
	}
	
	public void isConvertedRateCorrect() {
		wait.waitForElement(this.currentPriceValue, Constants.wait);
		String currVal = this.currentPriceValue.getText();
		int curVal = Integer.parseInt(currVal);
		this.amountCoinField.sendKeys("1");
		if(this.amountUsdField!=null) {
			String actualVal = this.amountUsdField.getText();
			int acVal = Integer.parseInt(actualVal);
			int expectedVal = curVal*1;
			Assert.assertEquals(acVal, expectedVal);
		}
		
	}
}
