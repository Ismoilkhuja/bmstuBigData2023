import java.util.List;
import java.util.ArrayList;


public class University {
    private List<Abiturient> abiturients = new ArrayList<>();

    public void registerAbiturient(Abiturient abiturient) {
        abiturients.add(abiturient);
    }

    public List<Abiturient> getAdmitted() {
        List<Abiturient> admitted = new ArrayList<>();
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getGPA() >= 7) {
                admitted.add(abiturient);
            }
        }
        return admitted;
    }
}
