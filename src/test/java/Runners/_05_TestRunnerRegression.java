package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Regression or @SmokeTest" ,
        /* or kullanmamızın sebebi verilen etiketlerin herhangi
         birine sahip olan senaryo çalışıyor
         ve koyarsak verilen etiketlerin hepsine birden sahip
         olan etiketler çalıyor
         */
        features = {"src/test/java/FeatureFiles"} ,
        glue = {"StepDefinitions"},
        plugin= {"json:target/cucumber/cucumber.json"}
)
public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}
