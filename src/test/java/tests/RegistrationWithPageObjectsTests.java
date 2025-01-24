package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.GeneratedData.subjects;

public class RegistrationWithPageObjectsTests extends TestBrowserConfiguration {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void succesfulRegistrationTest() {
        registrationPage.openPage();

        registrationPage
                .setFirstName("Kirill")
                .setLastName("Gladkiy")
                .setEmail("myOwnEmail@mail.com")
                .setGender("Other")
                .setUserNumber("9691231213")
                .setDateOfBirth("25", "July", "2009")
                .setSubjects(subjects())
                .setHobbie()
                .setPicture("/home/k/Изображения/viktor-mindt-rUrbBpSoNtc-unsplash.jpg")
                .setCurrentAdress("Russia, R-n-D")
                .setState("NCR")
                .setCity("Noida")
                .submit()
                .checkResult("Student Name", "Kirill Gladkiy")
                .checkResult("Student Email", "myOwnEmail@mail.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9691231213")
                .checkResult("Date of Birth", "25 July,2009")
                .checkResult("Picture", "viktor-mindt-rUrbBpSoNtc-unsplash.jpg")
                .checkResult("Address", "Russia, R-n-D")
                .checkResult("State and City", "NCR Noida");
    }

    //should not be passed
    @Test
    public void negativeRegistrationTest() {
        registrationPage.openPage();

        registrationPage
                .setFirstName("")
                .setLastName("Gladkiy")
                .setEmail("myOwnEmail@mail.com")
                .setGender("Other")
                .setUserNumber("9691231213")
                .setDateOfBirth("25", "July", "2009")
                .setSubjects(subjects())
                .setHobbie()
                .setPicture("/home/k/Изображения/viktor-mindt-rUrbBpSoNtc-unsplash.jpg")
                .setCurrentAdress("Russia, R-n-D")
                .setState("NCR")
                .setCity("Noida")
                .submit()
                .checkResult("Student Name", "Kirill Gladkiy")
                .checkResult("Student Email", "myOwnEmail@mail.com")
                .checkResult("Mobile", "9691231213");
    }
}
