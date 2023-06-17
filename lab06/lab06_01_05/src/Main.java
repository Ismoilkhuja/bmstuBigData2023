import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> multiplyPolynomials(List<Integer> poly1, List<Integer> poly2) {
        int degree = poly1.size() + poly2.size() - 2;
        List<Integer> result = new ArrayList<>(degree + 1);

        // Заполняем результирующий список нулями
        for (int i = 0; i <= degree; i++) {
            result.add(0);
        }

        // Умножение многочленов
        for (int i = 0; i < poly1.size(); i++) {
            for (int j = 0; j < poly2.size(); j++) {
                int coef1 = poly1.get(i);
                int coef2 = poly2.get(j);
                int product = coef1 * coef2;

                int power = i + j;
                int currentCoef = result.get(power);
                result.set(power, currentCoef + product);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> poly1 = new ArrayList<>();
        poly1.add(2);
        poly1.add(3);
        poly1.add(1);

        List<Integer> poly2 = new ArrayList<>();
        poly2.add(1);
        poly2.add(4);
        poly2.add(2);

        List<Integer> product = multiplyPolynomials(poly1, poly2);
        System.out.println("Результат умножения: " + product);
    }
}
