public class Abiturient {
    private String name;
    private String faculty;

    private int[] grades;

    public Abiturient(String name, String faculty, int[] grades) {
        this.name = name;
        this.faculty = faculty;
        this.grades = grades;
    }

    public float getGPA() {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return (float) sum / grades.length;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }
}
