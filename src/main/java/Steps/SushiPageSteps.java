package Steps;

import Pages.SushiPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$$;

public class SushiPageSteps {
    SushiPage sushiPage = new SushiPage();
    SelenideElement firstValidSushi;
    SoftAssert softAssert = new SoftAssert();

    @Step
    public SushiPageSteps addToFavorites(){
        firstValidSushi.$(sushiPage.favoritesButton).click();
        return this;
    }

    @Step
    public SushiPageSteps checkLoginPageAppear(){
        sushiPage.registrationElement.should(Condition.appear);
        return this;
    }

    @Step("add sushi to favorites")
    public SushiPageSteps makeSortDescending(){
        sushiPage.sortOptions.selectOption(sushiPage.sortDescending);
        return this;
    }

    @Step("wait to load page")
    public SushiPageSteps waitToLoad(){
        sushiPage.loadingElement.shouldBe(Condition.visible);
        return this;
    }

    @Step("validate that sushis are sorted according price")
    public SushiPageSteps validateSorting(){
        SelenideElement firstSushi = sushiPage.allSushi.get(0);
        SelenideElement secondSushi = sushiPage.allSushi.get(1);

        int firstSushiPrice = Integer.parseInt(firstSushi.$(sushiPage.sushiPrice).getText().trim().split("₾")[0]);
        int secondSushiPrice = Integer.parseInt(secondSushi.$(sushiPage.sushiPrice).getText().trim().split("₾")[0]);
        softAssert.assertTrue(firstSushiPrice >= secondSushiPrice);
        softAssert.assertAll();
        return this;
    }

    @Step("select first Sushi")
    public SushiPageSteps clickToFirstSushi(){
        sushiPage.allSushi.get(0).click();
        return this;
    }

    @Step("Check selling quantity of sushi")
    public SushiPageSteps checkPercentage(){
        for(var sushi : sushiPage.allSushi){
            if(!sushi.$(sushiPage.vouchersSoldPercentage).getAttribute("style").contains("100")){
                firstValidSushi = sushi;
                return this;
            }
        }
        softAssert.fail();
        softAssert.assertAll();
        return this;
    }
}
