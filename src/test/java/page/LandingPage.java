package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.linkedin.com")
public class LandingPage extends PageObject {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="/html/body/nav/a[3]")
    public WebElementFacade buttonEnterForAuthentification;

    @WhenPageOpens
    public boolean waitControllElementsAppear() {
        try {
            element(buttonEnterForAuthentification).waitUntilVisible();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void clickEnterToLoginPage(){
        buttonEnterForAuthentification.click();
    }



}
