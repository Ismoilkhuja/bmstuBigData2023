import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private int year;
    private List<Holiday> holidays;

    public Calendar(int year) {
        this.year = year;
        this.holidays = new ArrayList<>();
    }

    public void addHoliday(String name, int day, int month) {
        Holiday holiday = new Holiday(name, day, month);
        holidays.add(holiday);
    }

    public void removeHoliday(Holiday holiday) {
        holidays.remove(holiday);
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public boolean isHoliday(int day, int month) {
        for (Holiday holiday : holidays) {
            if (holiday.getDay() == day && holiday.getMonth() == month) {
                return true;
            }
        }
        return false;
    }

    public class Holiday {

        private String name;
        private int day;
        private int month;

        public Holiday(String name, int day, int month) {
            this.name = name;
            this.day = day;
            this.month = month;
        }

        public String getName() {
            return name;
        }

        public int getDay() {
            return day;
        }

        public int getMonth() {
            return month;
        }
    }
}
