package Steps;

import Pages.RecreationPage;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

public class RecreationPageSteps {
    RecreationPage recreationPage = new RecreationPage();

    @Step("Set minimal price")
    public RecreationPageSteps setMinPrice(String minPrice){
        recreationPage.minPrice.setValue(minPrice);
        return this;
    }

    @Step("Set maximal price")
    public RecreationPageSteps setMaxPrice(String maxPrice){
        recreationPage.maxPrice.setValue(maxPrice);
        return this;
    }

    @Step("Click find button")
    public RecreationPageSteps clickFind(){
        executeJavaScript("arguments[0].click()", recreationPage.searchButton);
        return this;
    }

    @Step("Wait to load Hotels")
    public RecreationPageSteps waitToLoad(){
        recreationPage.loadingElementSelector.shouldBe(Condition.visible);
        return this;
    }

}
