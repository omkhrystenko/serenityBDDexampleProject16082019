package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WhenPageOpens;
import org.jbehave.core.annotations.BeforeStories;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

@At("https://www.linkedin.com/feed/")
public class HomePage extends PageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//*[@id='nav-settings__dropdown']")
    public WebElementFacade iconProfile;


    @WhenPageOpens
    public boolean getCurrentPage() {
        return getPages().isCurrentPageAt(HomePage.class);
    }

    @WhenPageOpens
    public boolean waitControlElementsAppear() {
        try {
            element(iconProfile).waitUntilVisible();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
