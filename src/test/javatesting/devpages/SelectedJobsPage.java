package devpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedJobsPage extends BasicPage {

    @FindBy(className = "open-filters")
    private WebElement filterOpen;

    @FindBy(css = "[data-value = 'varna']")
    private WebElement townVarna;

    @FindBy(css = "[data-value = 'remote']")
    private WebElement fullyRemote;

    @FindBy(className = "apply-filters")
    private WebElement filterApply;

    public SelectedJobsPage(WebDriver driver) {
        super(driver);
    }

    public void ApplyFilter() {
        filterOpen.click();
        townVarna.click();
        fullyRemote.click();
        filterApply.click();
    }

    public String FiltersButton() {
        return filterOpen.getAttribute("textContent");
    }

    public String CorrectTown() {
        return townVarna.getCssValue("border-radius");
    }


}
