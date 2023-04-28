package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_Login.feature" ,
        "src/test/java/FeatureFiles/_02_CountryAdd.feature"} ,
        glue = {"StepDefinitions"}

)
public class _02_TestRunnerSpecifiedFeatures extends AbstractTestNGCucumberTests {

}
