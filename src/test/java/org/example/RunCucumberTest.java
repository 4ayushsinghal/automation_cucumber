package org.example;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = "C:/Users/4ayus/cc/Web-Automation/fedex_cucumber/src/test/resources/helloCucumber/Home.feature",
        glue="org.example"
)
public class RunCucumberTest {
}