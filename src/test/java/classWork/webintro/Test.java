package classWork.webintro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        String dayOfWeek =
                DateTimeFormatter.ofPattern("EEEE")
                        .withLocale(new Locale("be", "BY"))
                        .format(LocalDate.now().plus(1, ChronoUnit.DAYS).getDayOfWeek());
        System.out.println(dayOfWeek);
    }
}
