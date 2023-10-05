import Data.Constants;
import Steps.*;
import Utils.AllureScreenshotListener;
import Utils.DatabaseUtils.DbUsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners(AllureScreenshotListener.class)
@Epic("steps for user on swoop.ge site")
public class TestClass extends Config{

    @Test(description = "check price range of hotels", groups = {"Regression 1"})
    @Feature("Filter Hotels")
    @Severity(SeverityLevel.NORMAL)
    @Description("enter to resorts list and select prices in range 200 and 230")
    @Story("person enters price range. checking that every suggested hotel's price is in range.")
    public void myTest1(){
        homePageSteps.clickRecreationButton();
        recreationPageSteps.setMinPrice(Constants.MIN_PRICE.toString());
        recreationPageSteps.setMaxPrice(Constants.MAX_PRICE.toString());
        recreationPageSteps.clickFind();
        recreationPageSteps.waitToLoad();
        searchedHotelsPageSteps.validatePrices(Constants.MIN_PRICE, Constants.MAX_PRICE);
    }

    @Test(description = "add first valid sushi to favorites", groups = {"Regression 1"})
    @Story("enter to sushi page and check first validate sushi and add to favorites")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Validate Sold Quantity")
    @Description("enter to categories and go to sushi page and check first valid sushi and make it favorite")
    public void myTest2(){
        homePageSteps.clickToCategoriesButton()
                .hoverFoodsButton()
                .clickToSushiButton();
        sushiPageSteps.checkPercentage()
                .addToFavorites()
                .checkLoginPageAppear();
    }

    @Test(description = "order sushis descending and validate they are ordered", groups = {"Regression 2"})
    @Severity(SeverityLevel.NORMAL)
    @Feature("Sort Sushi")
    @Story("go to categories hover food go to sushi page sort descending and validate that it is sorted")
    @Description("sort sushis descending and validate it")
    public void myTest3(){
        homePageSteps.clickToCategoriesButton()
                .hoverFoodsButton()
                .clickToSushiButton();

        sushiPageSteps.makeSortDescending()
                .waitToLoad()
                .validateSorting();
    }

    @Test(description = "enter to first sushi and click share button", groups = {"Regression 2"})
    @Feature("Share Sushi")
    @Severity(SeverityLevel.NORMAL)
    @Story("go to categories hover food enter sushi page select first sushi, click to share button, validate share page opened")
    @Description("click first sushi, click share button and validate facebook page")
    public void myTest4(){
        homePageSteps.clickToCategoriesButton()
                .hoverFoodsButton()
                .clickToSushiButton();
        sushiPageSteps.clickToFirstSushi();
        sushiDetailsPageSteps.clickShareButton()
                .validateLoginPageAppeared();
    }


    @Test(description = "insert data to registration form from database", groups = {"Regression 2"})
    @Story("insert user data to database, then get data from database, using steps enter this data to registration form and validate error message")
    @Feature("Insert Data")
    @Severity(SeverityLevel.NORMAL)
    @Description("enter registration data from database to swoop")
    public void myTest5(){
        DbUsers.insertData();
        DbUsers.getResultsSet();
        homePageSteps.clickToLogin();
        registrationPageSteps.transferToRegistrationTab().setFirstName().setLastName().setPhone()
                        .setEmail().setDateOfBirth().setPassword().setConfirmPassword()
                        .clickRegisterButton().validateErrorMessage();
        DbUsers.truncateTable();
    }
}
