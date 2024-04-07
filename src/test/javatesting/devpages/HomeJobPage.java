package devpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeJobPage extends BasicPage {

    @FindBy(partialLinkText = "Automation QA")
    private WebElement automationQA;

    public HomeJobPage(WebDriver driver) {
        super(driver);
    }

    public void selectAutomationQA() {
        automationQA.click();
    }

}
