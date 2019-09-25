package interfaces;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IWeeklyCalendar weeklyCalendar = new WeeklyCalendar();
        weeklyCalendar.addEntry("Monday", "nishto");
        weeklyCalendar.addEntry("Tuesday", "dab");
        weeklyCalendar.addEntry("Friday", "xd");
        Iterable<WeeklyEntry> schedule = weeklyCalendar.getWeeklySchedule();
        for (WeeklyEntry weeklyEntry : schedule) {
            System.out.println(weeklyEntry);
        }
    }
}