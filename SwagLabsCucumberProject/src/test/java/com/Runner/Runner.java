package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\SwagLabsFeatures",glue = {"com.stepDefination"},
monochrome = true,
plugin = {"html:Reports\\HTMLReports\\Cucumber.html", "json:Reports\\JSONReports\\Cucumber.json",
"junit:Reports\\JUnitReports\\Cucumber.xml"},
dryRun = false
)

public class Runner {

}
