package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "C:\\Users\\rudi\\IdeaProjects\\CucumberTestNG\\resources\\CourseWork.feature"},
        glue = {"StepDefinitions"}
        )
public class Run extends AbstractTestNGCucumberTests {
}
