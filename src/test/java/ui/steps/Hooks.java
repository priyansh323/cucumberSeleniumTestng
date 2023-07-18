package ui.steps;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import testBase.DriverBase;

public class Hooks {
	
	DriverBase dr;
	
	@Before
	public void initializeTest() throws IOException {
	   dr = new DriverBase();
	   dr.launch();
	   //log.info("Driver Initialized");
	}

	@After
	public void Stop() {
	  // log.info("Shutting down Driver ");
	   dr.shut();
	}
}
