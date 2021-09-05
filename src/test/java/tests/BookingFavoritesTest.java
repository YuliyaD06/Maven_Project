package tests;

import org.junit.Test;
import pages.CalendarView;
import pages.CommonBookingPage;
import pages.DestinationView;
import pages.LoginPage;

public class BookingFavoritesTest extends Preconditions {

    private CommonBookingPage commonBookingPage = new CommonBookingPage();
    private LoginPage loginPage = new LoginPage();
    private CalendarView calendar = new CalendarView();
    private DestinationView destination = new DestinationView();

    @Test
    public void checkFavoritesHotelsTest(){
        commonBookingPage.openBookingPage();
        loginPage.loginWithEmail("yuliyatest66@gmail.com", "123654ghjJ");
        calendar.choosePeriodOfTrip(1);
        destination.chooseDestination("Madrid");
        commonBookingPage.searchHotels();
    }
}
