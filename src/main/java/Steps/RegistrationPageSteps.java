package Steps;

import Pages.RegistrationPage;
import Utils.DatabaseUtils.DbUsers;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;

public class RegistrationPageSteps {
    RegistrationPage registrationPage = new RegistrationPage();

    @Step("Enter firstname")
    public RegistrationPageSteps setFirstName(){
        registrationPage.firstNameInput.setValue(DbUsers.getFirstName());
        return this;
    }

    @Step("Enter lastname")
    public RegistrationPageSteps setLastName(){
        registrationPage.lastNameInput.setValue(DbUsers.getLastName());
        return this;
    }

    @Step("Enter phone")
    public RegistrationPageSteps setPhone(){
        registrationPage.phoneInput.setValue(DbUsers.getPhone());
        return this;
    }

    @Step("Enter email")
    public RegistrationPageSteps setEmail(){
        registrationPage.emailInput.setValue(DbUsers.getEmail());
        return this;
    }

    @Step("Enter DOB")
    public RegistrationPageSteps setDateOfBirth(){
        Selenide.executeJavaScript("arguments[0].valueAsDate= new Date(arguments[1]);", registrationPage.dateInput, DbUsers.getDateOfBirth());
        return this;
    }

    @Step("Enter Password")
    public RegistrationPageSteps setPassword(){
        registrationPage.passwordInput.setValue(DbUsers.getPassword());
        return this;
    }

    @Step("Enter Confirm Password")
    public RegistrationPageSteps setConfirmPassword(){
        registrationPage.confirmPasswordInput.setValue(DbUsers.getPassword());
        return this;
    }

    @Step("Enter Register Button")
    public RegistrationPageSteps clickRegisterButton(){
        registrationPage.registerButton.click();
        return this;
    }

    @Step("Enter registrationButton")
    public RegistrationPageSteps transferToRegistrationTab(){
        registrationPage.registrationButton.click();
        return this;
    }

    @Step("Validate error message")
    public RegistrationPageSteps validateErrorMessage(){
        Assert.assertEquals(registrationPage.errorMessage.getText(), "გთხოვთ აირჩიოთ სქესი!");
        return this;
    }
}
