package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
  features = {"src/test/java/FeatureFiles/_01_Login.feature"} ,
        // buraya feature files in path (content root) i yaziliyor.

  glue = {"StepDefinitions"}
        // steplerin oldugu package'in name'i yaziliyor
)
public class _01_TestRunner extends AbstractTestNGCucumberTests {


}
