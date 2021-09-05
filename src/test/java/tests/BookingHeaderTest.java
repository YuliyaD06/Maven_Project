package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.CommonBookingPage;
import pages.LoginPage;
import pages.NavigationBarView;

public class BookingHeaderTest extends Preconditions {

    private NavigationBarView navigationBar = new NavigationBarView();
    private CommonBookingPage commonBookingPagepage = new CommonBookingPage();
    private LoginPage loginPage = new LoginPage();

    @Test
    public void checkHeadersTest() {
        commonBookingPagepage.openBookingPage();
        loginPage.loginWithEmail("yuliyatest66@gmail.com", "123654ghjJ");
        Assert.assertTrue(navigationBar.allHeadersPresent());
    }
}
