package com.fruitshop.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"html:target/cucumber-report2.html" ,
        "json:target/cucumber.json",
        "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/fruitshop/step_definitions" ,
        dryRun = false,
        tags = "@test"
)

public class CukesRunner {
}
