package com.magier.tripservice.domain.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Dan on 25/06/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/cucumber",
        glue = {"com.magier.tripservice.domain.cucumber.steps"},
        format = {"json:target/cucumber/wikipedia.json", "html:target/cucumber/wikipedia.html", "pretty"}
)
public class BDDRunnerTest {
}
