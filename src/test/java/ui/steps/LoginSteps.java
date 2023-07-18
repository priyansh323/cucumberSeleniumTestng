package ui.steps;

import java.io.IOException; 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;
import testBase.DriverBase;
import testBase.WaitClass;

public class LoginSteps extends DriverBase {

	LoginPage lp = new LoginPage(DriverBase.driver);
	WaitClass wait = new WaitClass(DriverBase.driver);

	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		lp.isOnLoginPage();
	}

	@When("User Enters valid Credentials")
	public void user_enters_valid_credentials() throws IOException {
		lp.enterValidCredentials();
	}

	@When("clicks on Login")
	public void clicks_on_login() {
		lp.clickLogin();
	}

	@Then("User is logged in")
	public void user_is_logged_in() {
		lp.isLoggedIn();
		lp.clickLogout();
	}

	@When("User Enters Invalid Credentials")
	public void user_enters_invalid_credentials() {
		lp.enterinvalidCredentials();
	}
	
	@Then("User is not logged in")
	public void user_is_not_logged_in() {
		lp.isNotLoggedIn();
	}

}
