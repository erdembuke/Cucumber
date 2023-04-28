package Runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Regression or @SmokeTest" ,
        /* or kullanmamızın sebebi verilen etiketlerin herhangi
         birine sahip olan senaryo çalışıyor
         ve koyarsak verilen etiketlerin hepsine birden sahip
         olan etiketler çalıyor
         */
        features = {"src/test/java/FeatureFiles"} ,
        glue = {"StepDefinitions"}
)
public class _05_TestRunnerRegression {
}
