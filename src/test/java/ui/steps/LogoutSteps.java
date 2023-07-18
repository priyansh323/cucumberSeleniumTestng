package ui.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LogoutPage;
import page.RegisterPage;
import testBase.DriverBase;
import testBase.WaitClass;

public class LogoutSteps {
	
	LogoutPage lp = new LogoutPage(DriverBase.driver);
	WaitClass wait = new WaitClass(DriverBase.driver);

	
	@When("User clicks logout")
	public void user_clicks_logout() {
	    lp.clickLogout();
	}

	@Then("User is logged out successfully")
	public void user_is_logged_out_successfully() {
	    lp.isLoggedout();
	}

}
