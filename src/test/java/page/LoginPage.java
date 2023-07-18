package page;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.WaitClass;
import org.testng.Assert;
import constants.Constants;

public class LoginPage {
	private WebDriver driver ;
	
	WaitClass wait;
	
	@FindBy(xpath = "//input[@placeholder=\"Username\"]")
	public WebElement userNameField;
	
	@FindBy(xpath = "//input[@placeholder=\"Password\"]")
	public WebElement passwordField;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	public WebElement loginButton;

	@FindBy(xpath = "//a[@class=\"nav-link\"]")
	public WebElement registrationLink;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/h1")
	public WebElement welcomeHeading;
	
	@FindBy(xpath = "//div//h3[@class=\"text-center mt-3 mb-2 pb-0\"]")
    public WebElement totalValueHeading;
	
	@FindBy(xpath = "//button[@class=\"w-15 btn btn-primary\"]")
	public WebElement logoutButton;
	
	@FindBy(xpath = "//div[@class=\"fade alert alert-danger show\"]")
	public WebElement loginErrorAlert;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		wait = new WaitClass(driver);
	}
	
	public void isOnLoginPage() {
		wait.waitForElement(welcomeHeading, Constants.wait);
		String actualText = welcomeHeading.getText();
		String expectText = "Welcome";
		Assert.assertEquals(actualText, expectText);
	}
	
	public void enterValidCredentials() throws IOException {
		String loginData[]= dataReader();
		String userName = loginData[0];
		String password = loginData[1];
		wait.waitForElement(userNameField, Constants.wait);
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		
	}
	
	public String[] dataReader() throws IOException {
		FileReader fr = new FileReader("E:\\New folder\\papercoinAutomation\\src\\test\\resources\\testData\\loginData.txt");
		BufferedReader br = new BufferedReader(fr);
		String data = br.readLine();
		String loginData[] = data.split(",");
		br.close();
		return loginData ;
	}
	
	public void clickLogin() {
		wait.waitForElement(loginButton, Constants.wait);
		loginButton.click();
	}
	
	public void enterinvalidCredentials() {
		wait.waitForElement(userNameField, Constants.wait);
		userNameField.sendKeys(Constants.invalidUsername);
		passwordField.sendKeys(Constants.invalidpassword);
	}
	
	public void isLoggedIn() {
		wait.waitForElement(totalValueHeading, Constants.wait);
		String actualText = totalValueHeading.getText();
		String expectText = "Total Value: $";
		Assert.assertEquals(actualText, expectText);
	}
	
	public void clickLogout() {
		logoutButton.click();
	}
	
	public void isNotLoggedIn() {
		wait.waitForElement(loginErrorAlert, Constants.wait);
		String actualText = loginErrorAlert.getText();
		String expectText = "User Not found.";
		Assert.assertEquals(actualText, expectText);
	}
	
	

}
