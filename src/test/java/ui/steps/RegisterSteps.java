package ui.steps;

import java.io.IOException;

import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.RegisterPage;
import testBase.DriverBase;
import testBase.WaitClass;

public class RegisterSteps extends DriverBase{
	
	RegisterPage rp = new RegisterPage(DriverBase.driver);
	WaitClass wait = new WaitClass(DriverBase.driver);

	
	@Given("User is on register Page")
	public void user_is_on_register_page() {
		rp.isOnRegisterPage();
	}

	@When("User Enters valid Details")
	public void user_enters_valid_details() throws IOException, InterruptedException {
		rp.enterValidDetails();
	}

	@When("clicks on register")
	public void clicks_on_register() {
		rp.clickRegister();
	}

	@Then("User is registered")
	public void user_is_registered() {
		rp.isRegistered();
	}
	
	@When("User Enters Invalid {string} and {string}")
	public void user_enters_invalid_and(String username, String email) {
	    rp.enterInvalidDetails(username, email,Constants.validpassword);
	}

	@Then("User is not registered")
	public void user_is_not_registered() {
		rp.isNotRegistered();
	}
	
	@Then("User is registered and got dollars")
	public void user_is_registered_and_got_dollars() {
	  rp.isDollarsAvailable();
	}


}
