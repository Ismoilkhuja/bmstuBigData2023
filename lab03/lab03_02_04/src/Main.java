import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Abiturient[] abiturients = {
                new Abiturient("Ali", "Jandan", 50),
                new Abiturient("Vali", "Rozi", 40),
                new Abiturient("Salmon", "Forsi", 10)
        };

        /*
         * список абитуриентов, имеющих неудовлетворительные оценки
         */

        System.out.println("Список абитуриентов, имеющих неудовлетворительные оценки:");
        for (int i = 0; i < abiturients.length; i++) {
            if (abiturients[i].hasPoorGrade())
                System.out.println(abiturients[i].toString());
        }

        /*
         * список абитуриентов, средний балл у которых выше заданного;
         */

        System.out.println("Список абитуриентов, средний балл у которых выше заданного:");

        float gpa = 3.45F;

        for (int i = 0; i < abiturients.length; i++) {
            if (abiturients[i].getGPA() > gpa)
                System.out.println(abiturients[i].toString());
        }


        /*
         * выбрать заданное число n абитуриентов, имеющих самый высокий
         * средний балл (вывести также полный список абитуриентов,
         * имеющих полупроходной балл).
         */

        System.out.println("Выбрать заданное число n абитуриентов, имеющих самый высокий средний балл");

        int n = 2;
        GPAPos[] GPAInfo = new GPAPos[abiturients.length];

        for (int i = 0; i < abiturients.length; i++) {
            GPAInfo[i] = new GPAPos(abiturients[i].getGPA(), i);
        }

        Arrays.sort(GPAInfo, Comparator.comparing(GPAPos -> GPAPos.gpa));

        int ii = GPAInfo.length - 1;
        if (n <= GPAInfo.length){
            while ((n--) > 0){
                System.out.println(abiturients[ii--].toString());
            }
        }

    }
}