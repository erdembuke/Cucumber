package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles"} ,
        glue = {"StepDefinitions"} ,
        dryRun = true // true oldugunda testi calistirmaz sadece
        // feature lara ait steplerin varligini kontrol eder
        // false oldugunda ise testi calistirir
)
public class _03_TestRunnerAll extends AbstractTestNGCucumberTests {

}
