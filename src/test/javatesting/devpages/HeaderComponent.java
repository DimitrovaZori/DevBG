package devpages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderComponent extends BasicPage {

    @FindBy(id = "menuToggle")
    private WebElement menu;

    @FindBy(className = "cmplz-buttons")
    private WebElement cookies;

    @FindBy(linkText = "Създай профил")
    private WebElement accountCreate;


    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void clickMenu() {
        menu.click();
    }

    public void clickCookies() {
        cookies.click();
    }

    public void createProfile() {
        menu.click();
        cookies.click();
        accountCreate.click();

    }

    public String sizeButtonAccountCreate() {
        return accountCreate.getCssValue("font-size");
    }


}


