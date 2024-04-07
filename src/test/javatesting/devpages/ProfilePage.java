package devpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasicPage {

    @FindBy(id = "fname")
    private WebElement firstName;

    @FindBy(id = "lname")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;


    @FindBy(id = "consent-error")
    private WebElement errorMessage;

    @FindBy(css = "[value ='Създай профил']")
    private WebElement confirmCreate;


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void fillRegistration(String nameFirst, String nameLast, String mail, String pass) {
        firstName.sendKeys(nameFirst);
        lastName.sendKeys(nameLast);
        email.sendKeys(mail);
        password.sendKeys(pass);
        confirmCreate.click();
    }


    public String messageError() {
        return errorMessage.getText();
    }

    public boolean filledLastName() {
        return firstName.isEnabled();
    }

    public String colorEmailError() {
        return email.getCssValue("border");
    }
}
