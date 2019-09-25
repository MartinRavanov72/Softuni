package interfaces;

public interface IWeeklyCalendar {
    void addEntry(String weekday, String notes);

    Iterable<WeeklyEntry> getWeeklySchedule();
}
