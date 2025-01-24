package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.GeneratedData.hobbies;

public class RegistrationPage {
    //first method
//    public static SelenideElement firstNameLocator = $("#firstName");
//    public static SelenideElement lastNameLocator = $("#lastName");

    // second method

    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultPage checkResultPage = new CheckResultPage();

    private final SelenideElement
            firstNameLocator = $("#firstName"),
            lastNameLocator = $("#lastName"),
            emailLocator = $("#userEmail"),
            genderLocator = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInputLocator = $("#subjectsInput"),
            hobbiesInputLocator = $("[for=hobbies-checkbox-" + hobbies() + "]"),
            uploadPictureLocator = $("#uploadPicture"),
            currentAdressLocator = $("#currentAddress"),
            selectStateLocator = $("#react-select-3-input"),
            selectCityLocator = $("#react-select-4-input"),
            submitLocator = $("#submit");


    public void openPage() {
        open("/automation-practice-form");
        $("h5").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    //option one
    //    public void setFirstName(String el) {
    //        firstNameLocator.setValue(el);
    //    }

    //@Step("Set {{el}} to the first name input")
    public RegistrationPage setFirstName(String el) {
        firstNameLocator.setValue(el);
        return this;

        //return new RegistrationPage();  == return this
    }

    public RegistrationPage setLastName(String el) {
        lastNameLocator.setValue(el);
        return this; // this вернет обновленную страницу
    }

    public RegistrationPage setEmail(String el) {
        emailLocator.setValue(el);
        return this;
    }

    public RegistrationPage setGender(String el) {
        genderLocator.$(byText(el)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String el) {
        userNumber.setValue(el);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String el) {
        subjectsInputLocator.setValue(el).pressEnter();
        return this;
    }

    public RegistrationPage setHobbie() {
        hobbiesInputLocator.click();
        return this;
    }

    public RegistrationPage setPicture(String el) {
        uploadPictureLocator.uploadFile(new File(el));
        return this;
    }

    public RegistrationPage setCurrentAdress(String el) {
        currentAdressLocator.setValue(el);
        return this;
    }

    public RegistrationPage setState(String el) {
        selectStateLocator.setValue(el).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String el) {
        selectCityLocator.setValue(el).pressEnter();
        return this;
    }

    public RegistrationPage submit() {
        submitLocator.click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        checkResultPage.checkTable(key, value);
        return this;
    }

    ;
}
