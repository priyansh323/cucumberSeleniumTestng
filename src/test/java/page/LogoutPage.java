package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.WaitClass;

public class LogoutPage {
	private WebDriver driver ;

	LoginPage lp;
	WaitClass wait;
	
	@FindBy(xpath = "//*[@id=\"navbar\"]/div/a[2]")
    WebElement logoutButton;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		wait = new WaitClass(driver);
	}

	public void clickLogout() {
		this.logoutButton.click();
	}
	
	public void isLoggedout() {
		lp.isOnLoginPage();
	}
}
