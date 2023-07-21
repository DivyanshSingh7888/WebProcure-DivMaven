package UtilMethods;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class CurrentDateTimeAndRandomNumber {
    @NotNull
    public static String getCurrentTime(){
        //Est-Time Zone
        ZoneId newYokZoneId = ZoneId.of("America/New_York");
        LocalDateTime localDateTime = LocalDateTime.now(newYokZoneId);

        // Set the time zone to EST
        ZoneId estZone = ZoneId.of("America/New_York");
        ZonedDateTime estDateTime = ZonedDateTime.of(localDateTime, estZone);
        //Added 5 Min to EST-Zone
        ZonedDateTime newDateTime = estDateTime.plusMinutes(3);

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy, H:mm a");
        String formattedDateTime = newDateTime.format(formatter);

       // System.out.println("Current date and time (US): " + formattedDateTime);
        System.out.println(formattedDateTime);
        return formattedDateTime;
    }

    @NotNull
    public static String getCurruentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    @NotNull
    public static String addedMonths() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime addedMonths = now.plusMonths(1);
        String formattedDate = addedMonths.format(dtf);
        return formattedDate;
    }

    @NotNull
    public static String getRandomNumber(){
        String s = "Document Number" + ThreadLocalRandom.current().nextInt(1000);
        return s;
    }
}
