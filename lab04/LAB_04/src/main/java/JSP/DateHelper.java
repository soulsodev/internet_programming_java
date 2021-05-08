package JSP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class DateHelper {
    private Calendar mCalendar;
    LocalDate date;

    public DateHelper() {
        mCalendar = new GregorianCalendar();
        mCalendar.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));

        System.out.println("day" + mCalendar.get(5));
        System.out.println("month" + mCalendar.get(2));
        System.out.println("year" + mCalendar.get(1));

        date = LocalDate.now(ZoneId.of("Europe/Moscow"));
        System.out.println("date" + date);

    }

    public int getHours() {
        return this.mCalendar.get(11);
    }


    public int getDay() {
        return this.date.getDayOfMonth();
        //return this.mCalendar.get(5);

    }

    public int getMonth() {
        return this.date.getMonthValue();
        //return this.mCalendar.get(2);
    }

    public int getYear() {
        return this.date.getYear();
        //return this.mCalendar.get(1);
    }

    public String getDayByDate(int day, int month, int year) throws ParseException {
        String dateString = String.format("%d-%d-%d", year, month, day);
        Date date = new SimpleDateFormat("yyyy-M-d").parse(dateString);

        // Then get the day of week from the Date based on specific locale.
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);

        return dayOfWeek; // Friday

//        String template = String.format("%d-%d-%d", day, month, year);
//        Date date = null;
//
//        try {
//            date = (new SimpleDateFormat("d-M-yyyy")).parse(template);
//        } catch (ParseException var7) {
//            var7.printStackTrace();
//        }
//
//        String formatedDate = (new SimpleDateFormat("EEEE", Locale.ENGLISH)).format(date);
//        return formatedDate;
    }
}
