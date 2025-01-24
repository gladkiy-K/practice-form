package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;
import java.util.Random;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import static tests.GeneratedData.hobbies;
import static tests.GeneratedData.subjects;

public class PracticeFormTest extends TestBrowserConfiguration{

    @Test
    void FillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        new RegistrationPage().setFirstName("Kirill");
        $("#firstName").setValue("Kir");
        $("#lastName").setValue("Gladkiy");
        $("#userEmail").setValue("myOwnEmail@mail.com");
        $x("//div[@id='genterWrapper']/div[2]/div[1]").click();
        $("#userNumber").setValue("9691231213");

        //registrationPage.open();
        //registrationPage.setFirstName("Kirill");
        //registrationPage.setBirthday("20","02","2000")


        $("#dateOfBirthInput").clear();
        $x("//select[@class='react-datepicker__month-select']/option[@value='1']").click();
        $x("//select[@class='react-datepicker__year-select']/option[@value='1997']").click();
        $x("//div[contains(@class, 'react-datepicker__day') and contains(text(), '25')]").click();

        $("#subjectsInput").setValue(subjects()).pressEnter();

        $("#stateCity-label").scrollTo();
        $("[for=hobbies-checkbox-" + hobbies() + "]").click();
        $("#uploadPicture").uploadFile(new File("/home/k/Изображения/viktor-mindt-rUrbBpSoNtc-unsplash.jpg"));
        $("#currentAddress").setValue("Russia, R-n-D");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();

        String result = String.valueOf($("button#closeLargeModal").getText());

        if (result.equals("Close")) {
            System.out.println("Test has been done succesfully");
        } else {
            System.out.println("You test has not been passed");
        }

        //alternative version
        $(".modal-dialog").should(appear);
//        SelenideElement res = $("div.modal-content").$("div.modal-header").shouldHave(text("Thanks for submitting the form"));
//        String res = String.valueOf($("div.modal-content").$("div.modal-header").getText());
        String res = String.valueOf($("div.modal-content > div.modal-header").getText());
        if (res.equals("Thanks for submitting the form")) {
            System.out.println("test passed");
        }
        $("div.table-responsive").shouldHave(text("Kir"),
                text("Gladkiy"), text("39691231213"));
    }
}

//Page object -