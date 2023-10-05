package Steps;

import Data.Constants;
import Pages.SushiDetailsPage;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.switchTo;

public class SushiDetailsPageSteps {
    SushiDetailsPage sushiDetailsPage = new SushiDetailsPage();
    SoftAssert softAssert = new SoftAssert();

    @Step("Click to share button")
    public SushiDetailsPageSteps clickShareButton(){
        sushiDetailsPage.shareButton.click();
        return this;
    }

    @Step("validate that facebook login window appeared")
    public SushiDetailsPageSteps validateLoginPageAppeared(){
        softAssert.assertTrue(switchTo().window(1).getCurrentUrl().contains(Constants.FB_LOGIN_URL));
        softAssert.assertAll();
        return this;
    }
}
