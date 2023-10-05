package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.nio.channels.Selector;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RecreationPage {
    public SelenideElement minPrice = $("div.category-filter-desk input#minprice"),
            maxPrice = $("div.category-filter-desk input#maxprice"),
            searchButton = $("div.category-filter-desk div.submit-button"),
            loadingElementSelector = $(By.cssSelector("#body[style*='unset']"));

}
