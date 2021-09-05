package steps;

import pages.CommonBookingPage;
import pages.RegistrationPage;

public class BookingSteps {

    CommonBookingPage bookingStep = new CommonBookingPage();
    RegistrationPage registrationPage = new RegistrationPage();


    public void fillRegistrationForm(String mail, String password) {
        registrationPage.openRegistrationForm();
        registrationPage.enterMailDuringRegistration(mail);
        registrationPage.enterPasswordDuringRegistration(password);
    }

    public void passCaptcha() {
        bookingStep.passCaptcha();
    }


}
