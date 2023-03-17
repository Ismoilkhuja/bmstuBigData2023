import java.util.List;

public class Main {
    public static void main(String[] args) {
        Abiturient abiturient1 = new Abiturient("Иванов", "Факультет1", new int[] { 7, 8, 9 });
        Abiturient abiturient2 = new Abiturient("Петров", "Факультет2", new int[] { 6, 7, 8 });
        Abiturient abiturient3 = new Abiturient("Сидоров", "Факультет3", new int[] { 7, 6, 5 });

        Teacher teacher = new Teacher();
        teacher.setGrade(abiturient1, new int[] { 3, 10, 9 });
        teacher.setGrade(abiturient2, new int[] { 7, 8, 4 });
        teacher.setGrade(abiturient3, new int[] { 7, 4, 6 });

        University university = new University();
        university.registerAbiturient(abiturient1);
        university.registerAbiturient(abiturient2);
        university.registerAbiturient(abiturient3);

        List<Abiturient> admitted = university.getAdmitted();
        for (Abiturient abiturient : admitted) {
            System.out.println("Абитуриент " + abiturient.getName() + " зачислен на факультет " + abiturient.getFaculty());
        }
        
    }
}