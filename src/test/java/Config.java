import Steps.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Config {
    HomePageSteps homePageSteps;
    SushiPageSteps sushiPageSteps;
    RecreationPageSteps recreationPageSteps;
    SearchedHotelsPageSteps searchedHotelsPageSteps;
    SushiDetailsPageSteps sushiDetailsPageSteps;
    RegistrationPageSteps registrationPageSteps;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        Configuration.browser = "edge";
        Configuration.pageLoadTimeout = 100000000L;
        Selenide.open("https://www.swoop.ge");
        homePageSteps = new HomePageSteps();
        sushiPageSteps = new SushiPageSteps();
        recreationPageSteps = new RecreationPageSteps();
        searchedHotelsPageSteps = new SearchedHotelsPageSteps();
        sushiDetailsPageSteps = new SushiDetailsPageSteps();
        registrationPageSteps = new RegistrationPageSteps();
    }

    @AfterMethod(alwaysRun = true)
    public void close(){
        Selenide.closeWebDriver();
    }
}
