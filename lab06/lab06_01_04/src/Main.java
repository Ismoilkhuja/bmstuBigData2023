import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Создание и заполнение первого многочлена
        Map<Integer, Integer> polynomial1 = new HashMap<>();
        polynomial1.put(0, 2);
        polynomial1.put(1, 4);
        polynomial1.put(2, 1);

        // Создание и заполнение второго многочлена
        Map<Integer, Integer> polynomial2 = new HashMap<>();
        polynomial2.put(0, 1);
        polynomial2.put(1, 3);
        polynomial2.put(2, 5);

        // Вычисление суммы многочленов
        Map<Integer, Integer> sum = addPolynomials(polynomial1, polynomial2);

        // Вывод результата
        System.out.println("Сумма многочленов: " + sum);
    }

    public static Map<Integer, Integer> addPolynomials(Map<Integer, Integer> poly1, Map<Integer, Integer> poly2) {
        // Создание нового многочлена для хранения суммы
        Map<Integer, Integer> sum = new HashMap<>();

        // Обработка коэффициентов первого многочлена
        for (Map.Entry<Integer, Integer> term : poly1.entrySet()) {
            int exponent = term.getKey();
            int coefficient = term.getValue();
            sum.put(exponent, coefficient);
        }

        // Обработка коэффициентов второго многочлена
        for (Map.Entry<Integer, Integer> term : poly2.entrySet()) {
            int exponent = term.getKey();
            int coefficient = term.getValue();
            if (sum.containsKey(exponent)) {
                // Если степень уже присутствует, складываем коэффициенты
                int existingCoefficient = sum.get(exponent);
                sum.put(exponent, existingCoefficient + coefficient);
            } else {
                // Если степени нет, просто добавляем новую пару степень-коэффициент
                sum.put(exponent, coefficient);
            }
        }

        return sum;
    }
}
