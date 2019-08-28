package step.steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.HomePage;
import page.LandingPage;
import page.LoginPage;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

public class UserSteps extends ScenarioSteps {

    @Managed(driver = "chrome")
    public WebDriver driver;

    @BeforeStory
    public void setupDriver() throws MalformedURLException {
        //Для локального запуска эта строка нужна WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().setup();
    }




    Logger logger = LoggerFactory.getLogger(this.getClass().getName()); //org.slf4j.Logger;

    LandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;



    @Step
    public UserSteps openLandingPage() {
        landingPage.open();
        logger.info("Landing page is opened");
        return this;
    }

    @Step
    public UserSteps verifyLandingPageControllElementAppear(){
        assertTrue(landingPage.waitControllElementsAppear());
        logger.info("Landing page control element is loaded");
        return this;
    }

    @Step
    public UserSteps clickOnButton(String buttonText){
        landingPage.clickOnButtonWithText(buttonText);
        logger.info("Click on Enter button on Landing page was successful");
        return this;
    }

    @Step
    public UserSteps verifyLoginPageUrlLoaded(){
        assertTrue(loginPage.getCurrentPage());
        logger.info("Login page URL is right");
        return this;
    }

    @Step
    public UserSteps verifyLoginPageControllElementAppear(){
        assertTrue(loginPage.waitControllElementsAppear());
        logger.info("Login page control element is loaded");
        return this;
    }

    @Step
    public UserSteps submitAuthenticationData(String login, String password){
        loginPage.submitAuthentificationData(login, password);
        logger.info("Login page authentication fields successfully submited");
        return this;
    }

    @Step
    public UserSteps verifyHomePageUrlLoaded(){
        assertTrue(homePage.getCurrentPage());
        logger.info("Home page URL is right");
        return this;
    }

    @Step
    public UserSteps verifyHomePageControlElementAppear(){
        assertTrue(homePage.waitControlElementsAppear());
        logger.info("Home page control element is loaded");
        return this;
    }
}
