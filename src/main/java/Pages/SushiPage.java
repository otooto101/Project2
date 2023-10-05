package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import org.testng.asserts.SoftAssert;


public class SushiPage {
    public ElementsCollection allSushi = $$(".special-offer");
    public SelenideElement registrationElement = $(".authorization"),
            sortOptions = $("#sort"),
            loadingElement = $(By.cssSelector("#body[style*='unset']"));
    public String sortDescending = "ფასით კლებადი";
    public By favoritesButton = By.cssSelector(".deal-basket-wishlist"),
            vouchersSoldPercentage = By.cssSelector(".voucher-limit"),
            sushiPrice = By.cssSelector("div.discounted-prices p:nth-child(1)");
}
