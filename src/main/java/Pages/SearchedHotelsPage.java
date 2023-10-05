package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class SearchedHotelsPage {
    public ElementsCollection hotelPrices = $$("#partialid div.discounted-prices p:nth-child(1)");
}
