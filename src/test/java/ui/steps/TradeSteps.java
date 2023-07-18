package ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.TradePage;
import testBase.DriverBase;
import testBase.WaitClass;

public class TradeSteps {
	
	TradePage tp = new TradePage(DriverBase.driver);
	WaitClass wait = new WaitClass(DriverBase.driver);

	
	@Given("clicks on coin")
	public void clicks_on_coin() {
	    tp.clickCoin();
	}

	@When("User enter amount")
	public void user_enter_amount() {
	   tp.enterAmount();
	}

	@When("clicks on buy or sell")
	public void clicks_on_buy_or_sell() {
	    tp.clickBuy();
	}

	@Then("Trade is successful")
	public void trade_is_successful() {
	    tp.isTradeSuccess();
	}

	@Given("clicks on BTC coin")
	public void clicks_on_btc_coin() {
	    tp.clickBtcCoin();
	}

	@When("clicks on buy")
	public void clicks_on_buy() {
	    tp.clickBuy();
	}

	@Then("Pop up with Insufficient Funds comes")
	public void pop_up_with_insufficient_funds_comes() {
	    tp.isTradeFail();
	}

	@When("clicks on sell")
	public void clicks_on_sell() {
	    tp.clickSell();
	}

	@Then("Pop up with Nice Try comes")
	public void pop_up_with_nice_try_comes() {
	    tp.isTradeFail();
	}

	@Then("converted rate is correct")
	public void converted_rate_is_correct() {
	    tp.isConvertedRateCorrect();
	}
	
	@Given("clicks on  random coin")
	public void clicks_on_random_coin() {
	    tp.clickRandomCoin();
	}

	@When("User enter {string}")
	public void user_enter(String amount) {
	    tp.enterAmount(amount);
	}



}
