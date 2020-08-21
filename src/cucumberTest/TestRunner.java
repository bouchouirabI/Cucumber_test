package cucumberTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( glue = {"steps"},
		          features= "features")
public class TestRunner {

	@BeforeClass
	public static void setUp(){
		//Application.getInstance().setWindowSize(1920, 1080);
	}

	@AfterClass
	public static void tearDown(){
		//Application.getInstance().closeBrowser();
	}

}
