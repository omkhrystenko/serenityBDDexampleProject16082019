package step.definition;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import step.steps.UserSteps;

public class CommonStepDefinition {//Class that describes .story files



    @Steps
    private UserSteps userSteps;

    @Given("I open Landing page")
    public void openLandingPage(){
        userSteps.openLandingPage()
                .verifyLandingPageControllElementAppear()
                .goToLoginPage();
    }

    @Given("I go to Login page")
    public void goToLoginPage(){
        userSteps.verifyLoginPageUrlLoaded()
                .verifyLoginPageControllElementAppear();
    }

    @When("I submit authentication data ($login, $password")
    public void submitAuthenticationData(String login, String password){
        userSteps.submitAuthenticationData(login, password);

    }

    @Then("Home page is loaded")
    public void verifyHomePageIsLoaded(){
        userSteps.verifyHomePageUrlLoaded()
                .verifyHomePageControlElementAppear();
    }

}
