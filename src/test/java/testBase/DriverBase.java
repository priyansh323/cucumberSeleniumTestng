package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverBase {

	public static WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void driverInitializer(String browser, String url) {
	      switch (browser) {
	      case "chrome":
	    	  ChromeOptions Options = new ChromeOptions();
	          Options.addArguments("--start-maximized");
	          Options.addArguments("--remote-allow-origins=*");
	    	  System.setProperty("webdriver.chrome.driver",
						"E:\\New folder\\papercoinAutomation\\src\\main\\resources\\drivers\\chromedriver.exe");
	         driver = new ChromeDriver(Options);
	         driver.get(url);
	         driver.manage().window().maximize();
	         // driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
	         break;
	      case "firefox":
	    	  System.setProperty("webdriver.gecko.driver",
						"E:\\New folder\\papercoinAutomation\\src\\main\\resources\\drivers\\geckodriver.exe");
	         driver = new FirefoxDriver();
	         driver.get(url);
	         driver.manage().window().maximize();
	         break;
	      }
	   }

	   public WebDriver launch() throws IOException {
	      FileReader read = new FileReader("E:\\New folder\\papercoinAutomation\\src\\test\\resources\\config.properties");
	      Properties p = new Properties();
	      p.load(read);
	      String browser = p.getProperty("browser");
	      String url = p.getProperty("loginUrl");
	      driverInitializer(browser, url);

	      return driver;
	   }

	   public void shut() {
	      driver.quit();
	   }
	

}
