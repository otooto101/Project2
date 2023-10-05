package Pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public SelenideElement recreationButton = $(byLinkText("დასვენება")),
                categoriesButton = $("div.NewCategories.newcat p"),
                foodsButton = $("div.LeftSideCategories").$(byText("კვება")),
                sushiButton = $("div.LeftSideCategories").$(byText("სუში")),
                loginButton = $(byText("შესვლა"));

}
