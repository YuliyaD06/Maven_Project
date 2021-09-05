package tests;

import org.junit.Test;
import pages.CommonBookingPage;
import pages.GmailPage;
import pages.RegistrationPage;
import steps.BookingSteps;

public class BookingRegistrationTest extends Preconditions {

    private BookingSteps step = new BookingSteps();
    private CommonBookingPage commonBookingPage = new CommonBookingPage();
    private RegistrationPage registrationPage = new RegistrationPage();
    private GmailPage gmailPage = new GmailPage();

    @Test
    public void registrationTest(){
        commonBookingPage.openBookingPage();
        registrationPage.openRegistrationForm();
        registrationPage.enterMailDuringRegistration("brakus.amber@trashmail.fr");
        registrationPage.enterPasswordDuringRegistration("SBb6tPijl7");
        //step.passCaptcha();
        commonBookingPage.closeWelcomeCard();
        gmailPage.confirmRegistration("SBb6tPijl7", "yuliyatest66@gmail.com");
    }

}
