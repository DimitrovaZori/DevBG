import devpages.HeaderComponent;
import devpages.HomeJobPage;
import devpages.SelectedJobsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SelectJobTest extends MainDriver {

    HomeJobPage homeJobPage;
    HeaderComponent headerComponent;
    SelectedJobsPage selectedJobsPage;

    @Test
    public void selectJob() {
        headerComponent = new HeaderComponent(driver);
        headerComponent.clickCookies();
        homeJobPage = new HomeJobPage(driver);
        homeJobPage.selectAutomationQA();
        selectedJobsPage = new SelectedJobsPage(driver);

        selectedJobsPage.ApplyFilter();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("open-filters")));

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(selectedJobsPage.FiltersButton(), " Филтри  ");
        soft.assertEquals(selectedJobsPage.CorrectTown(), "5px");
        soft.assertAll();
    }
}
