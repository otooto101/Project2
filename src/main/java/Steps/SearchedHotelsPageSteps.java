package Steps;

import Pages.SearchedHotelsPage;
import com.codeborne.selenide.ex.SoftAssertionError;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class SearchedHotelsPageSteps {
    SearchedHotelsPage searchedHotelsPage = new SearchedHotelsPage();
    SoftAssert softAssert = new SoftAssert();

    @Step("Validate prices of movies")
    public SearchedHotelsPageSteps validatePrices(int min, int max){
        for (var price : searchedHotelsPage.hotelPrices) {
            String priceWithSign = price.getText();
            int parsedPrice = Integer.parseInt(priceWithSign.substring(0, priceWithSign.length() - 1));
            if (parsedPrice > max || parsedPrice < min) softAssert.fail();
        }
        softAssert.assertAll();
        return this;
    }
}
