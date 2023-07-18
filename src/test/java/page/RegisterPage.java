package page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import constants.Constants;
import testBase.WaitClass;

public class RegisterPage {
private WebDriver driver ;

	LoginPage lp;
	WaitClass wait;
	
	@FindBy(xpath = "//input[@placeholder=\"Username\"]")
	public WebElement userNameField;
	
	@FindBy(xpath = "//div//a[@class=\"nav-link disabled\"]")
	public WebElement registrationHeading ;
	
	@FindBy(xpath = "//input[@placeholder=\"Password\"]")
	public WebElement passwordField;
	
	@FindBy(xpath = "//input[@placeholder=\"Email\"]")
	public WebElement emailField;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	public WebElement registrationButton;
	
	@FindBy(xpath = "//a[@class=\"nav-link\"]")
	public WebElement loginLink;
	
	@FindBy(xpath = "//div//h3[@class=\"text-center mt-3 mb-2 pb-0\"]")
    public WebElement totalValueHeading;
	
	@FindBy(xpath = "//a[@class=\"nav-link\"]")
	public WebElement registrationLink;

	@FindBy(xpath = "//*[@id=\"navbar\"]/span[2]/text()[2]")
	public WebElement balanceValue;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		wait = new WaitClass(driver);
	}
	
	public void isOnRegisterPage() {
		this.registrationLink.click();
		wait.waitForElement(registrationHeading, Constants.wait);
		String actualText = registrationHeading.getText();
		String expectText = "Must be between 5 and 20 characters";
		Assert.assertEquals(actualText, expectText);
	}
	
	public void enterValidDetails() throws IOException, InterruptedException {
		FileInputStream file = new FileInputStream("E:\\New folder\\papercoinAutomation\\src\\test\\resources\\testData\\registrationData.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook(file);
		  XSSFSheet sheet = workbook.getSheet("Sheet1");
		  for(int i=1; i<=sheet.getLastRowNum(); i++) {
			  XSSFRow row = sheet.getRow(i);
			  XSSFCell cell1 = row.getCell(0);
			  String userName = cell1.getStringCellValue();
			  userNameField.sendKeys(userName);
			  Thread.sleep(2000);
			  
			  XSSFCell cell2 = row.getCell(1);
			  String email = cell2.getStringCellValue();
			  emailField.sendKeys(email);
			  Thread.sleep(2000);
			  
			  XSSFCell cell3 = row.getCell(2);
			  String pass = cell3.getStringCellValue();
			  passwordField.sendKeys(pass);
			  Thread.sleep(2000);
			  workbook.close();
		
	 }
	}
	
	public void clickRegister() {
		wait.waitForElement(registrationButton, Constants.wait);
		this.registrationButton.click();
	}
	
	public void isRegistered() {
		wait.waitForElement(this.totalValueHeading, Constants.wait);
		String actualText = totalValueHeading.getText();
		String expectText = "Total Value: $";
		Assert.assertEquals(actualText, expectText);
	}
	
	public void isNotRegistered() {
		wait.waitForElement(this.totalValueHeading, Constants.wait);
		String actualText = this.registrationHeading.getText();
		String expectText = "Total Value: $";
		Assert.assertNotEquals(actualText, expectText);
	}
	
	public void isDollarsAvailable() {
		wait.waitForElement(this.balanceValue, Constants.wait);
		String actualText = this.balanceValue.getText();
		Assert.assertTrue(actualText != null);
	}
	
	public void enterInvalidDetails(String username, String email, String password){
		userNameField.clear();
		userNameField.sendKeys(username);
		
		emailField.clear();
		emailField.sendKeys(username);
		
		passwordField.clear();
		passwordField.sendKeys(username);
		
		registrationButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
