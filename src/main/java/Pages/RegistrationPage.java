package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class RegistrationPage {
    public SelenideElement registrationButton = $(byText("რეგისტრაცია")),
                firstNameInput = $("#pFirstName"),
                lastNameInput = $("#pLastName"),
                emailInput = $("#pEmail"),
                phoneInput = $("#pPhone"),
                dateInput = $("#pDateBirth"),
                passwordInput = $("#pPassword"),
                confirmPasswordInput = $("#pConfirmPassword"),
                registerButton = $(byValue("რეგისტრაცია")),
                errorMessage = $("#physicalInfoMassage");

}
