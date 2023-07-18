package ui.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.DashboardPage;
import page.RegisterPage;
import testBase.DriverBase;
import testBase.WaitClass;

public class DashboardSteps {

	DashboardPage dp = new DashboardPage(DriverBase.driver);
	WaitClass wait = new WaitClass(DriverBase.driver);

	@When("User do successful Trade")
	public void user_do_successful_trade() {
		dp.doSuccessTrade();
	}

	@When("navigate to dashboard")
	public void navigate_to_dashboard() {
		dp.navigateToDashboard();
	}

	@Then("User view Updated Total Value")
	public void user_view_updated_total_value() {
		dp.isValueUpdated();
	}

}
