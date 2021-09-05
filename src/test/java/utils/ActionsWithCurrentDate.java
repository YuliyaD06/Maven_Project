package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ActionsWithCurrentDate {

    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public String currentDate(){
        String currentDate = formatter.format(today);
        return currentDate;
    }
    public String addMonthToCurrentDate(int month){
        today = today.plusMonths(month);
        String newIncreasedMonth = formatter.format(today);
        return newIncreasedMonth;
    }

}
