package testRunner;

//import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		//features=".//Features/", // to run all the feature files present in features folder
		//features=".//Features/LoginFeature.feature",// here we provide feature file's location
		features={".//Features/AddCustomer.feature",".//Features/LoginFeature.feature"}, // if we have mutiple feature files and we want to run only 2 out of all we specify in this way
		
		// Similarly we can define specific step definition files here
		glue="StepDefinition",// here we provide name of step definition package
		
		tags="@Sanity", // Scenarios under @regression tag will only executed
		
		// We will set dryRun as false for actual execution. 
		dryRun=false, // If dry run is set true, it will check all the features mentioned in feature file are implemented or not in step definition file
		monochrome=true,// the console o/p will be unreadable if it is set as false. It should be true to make console readable
		//plugin = {"pretty","html:target/cucumber-reports/reports2.html"}// This is used to generate html report with name "reports1.html" under target folder inside that cucumber-reports
		 //plugin = {"pretty","json:target/cucumber-reports/report_json.json"}// command to generate report in json format
		 //plugin = {"pretty","junit:target/cucumber-reports/report_xml.xml"}// command to generate report in json format
		
		// command to print report in all three formats
		//plugin = {"pretty","junit:target/cucumber-reports/report_xml.xml","json:target/cucumber-reports/report_json.json","html:target/cucumber-reports/reports1.html"}	
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

//use with TESTNG
public class RunSearchEmail extends AbstractTestNGCucumberTests {
// This should be empty
}

//use with Junit

//public class RunSearchEmail{
	
	// This should be empty

	
//}