package ui.steps;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.BalancePage;
import page.RegisterPage;
import testBase.DriverBase;
import testBase.WaitClass;

public class BalanceSteps {
	
	BalancePage bp = new BalancePage(DriverBase.driver);
	WaitClass wait = new WaitClass(DriverBase.driver);

	
	@Given("User is on Dashboard")
	public void user_is_on_dashboard() throws IOException {
	    bp.isOnDashBoard();
	}

	@Then("User can view Account Balance")
	public void user_can_view_account_balance() {
	   bp.viewBalance();
	}

	@When("User do successful trade")
	public void user_do_successful_trade() {
		bp.doSuccessTrade();
	    
	}

	@Then("User can view updated Balance")
	public void user_can_view_updated_balance() {
	   bp.isBalanceUpdated();
	}
}
