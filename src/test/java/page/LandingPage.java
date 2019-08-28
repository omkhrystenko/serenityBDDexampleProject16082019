package page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.linkedin.com")
public class LandingPage extends PageObject {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="/html/body/nav/a[3]")
    public WebElementFacade buttonEnterForAuthentification;

    @WhenPageOpens
    public boolean waitControllElementsAppear() {//Конструкция проверяет прогрузился ли элемент на странице
        try {
            element(buttonEnterForAuthentification).waitUntilVisible();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void clickOnButtonWithText(String buttonText){// Это ломает структуру пейдж обджект, но дает возможность искать элементы по названию
        WebElement button = getDriver().findElement(By.xpath(String.format("//a[text()='%s']", buttonText)));
        button.click();
    }



}
