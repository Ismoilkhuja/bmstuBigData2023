import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Создаем объект календаря для 2022 года
        Calendar calendar2022 = new Calendar(2022);

        // Добавляем празднки
        calendar2022.addHoliday("Новый Год", 1, 1);
        calendar2022.addHoliday("День защитника Отечества", 23, 2);
        calendar2022.addHoliday("Международный женский день", 8, 3);
        calendar2022.addHoliday("Праздник Весны и Труда", 1, 5);

        // Получаем список праздников
        List<Calendar.Holiday> holidays2022 = calendar2022.getHolidays();

        // Выводим список праздников на экран
        System.out.println("Праздники 2022 года:");
        for (Calendar.Holiday holiday : holidays2022) {
            System.out.println(holiday.getDay() + "." + holiday.getMonth() + " - " + holiday.getName());
        }

        // Проверяем, является ли 1 января праздничным днем
        if (calendar2022.isHoliday(1, 1)) {
            System.out.println("1 января - праздничный день");
        } else {
            System.out.println("1 января - обычный рабочий день");
        }

    }
}