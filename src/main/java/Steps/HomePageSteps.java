package Steps;

import Pages.HomePage;
import io.qameta.allure.Step;

public class HomePageSteps {
    HomePage homePage = new HomePage();

    @Step("Enter to recreation page")
    public HomePageSteps clickRecreationButton(){
        homePage.recreationButton.click();
        return this;
    }

    @Step("Click to categories button")
    public HomePageSteps clickToCategoriesButton(){
        homePage.categoriesButton.click();
        return this;
    }

    @Step("Hover to foods button")
    public HomePageSteps hoverFoodsButton(){
        homePage.foodsButton.hover();
        return this;
    }

    @Step("Navigate to Login window")
    public HomePageSteps clickToLogin(){
        homePage.loginButton.click();
        return this;
    }

    @Step("navigate to Sushi Page")
    public HomePageSteps clickToSushiButton(){
        homePage.sushiButton.click();
        return this;
    }
}
