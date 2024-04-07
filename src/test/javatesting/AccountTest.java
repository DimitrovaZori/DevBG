import devpages.HeaderComponent;
import devpages.ProfilePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class AccountTest extends MainDriver {
    HeaderComponent headerComponent;
    ProfilePage profilePage;

    @Test
    public void newAccount() {
        SoftAssert softAssert = new SoftAssert();
        headerComponent = new HeaderComponent(driver);
        headerComponent.createProfile();
        softAssert.assertEquals(headerComponent.sizeButtonAccountCreate(), "14px");

        profilePage = new ProfilePage(driver);
        profilePage.fillRegistration("Zori", "Dimitrova", "@", " ");

        softAssert.assertTrue(profilePage.filledLastName());
        softAssert.assertEquals(profilePage.messageError(), "Трябва да се съгласите с условията, преди да се регистрирате");
        softAssert.assertAll();
    }

    @Test
    public void newAccountEmptyDetails() {
        headerComponent = new HeaderComponent(driver);
        headerComponent.createProfile();
        profilePage = new ProfilePage(driver);
        profilePage.fillRegistration(" ", " ", " ", " ");

        assertEquals(profilePage.colorEmailError(), "1px solid rgb(255, 0, 0)");

    }


}
