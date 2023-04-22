import java.util.Arrays;
import java.util.Random;

public class Abiturient {
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private String phone;
    private int[] marks;

    private static long counter = 0;

    public Abiturient(String name, String surname, String patronymic,
                      String address, String phone, int[] marks){
        this.id = nextId();
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.marks = new int[marks.length];
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = marks[i];
        }
    }
    public Abiturient(String name, String surname, int marksCount){
        this.id = nextId();
        this.name = name;
        this.surname = surname;
        this.marks = new int[marksCount];
        Random rand = new Random();
        for (int i = 0; i < marksCount; i++) {
            this.marks[i] = rand.nextInt(4) + 1;
        }
    }

    private long nextId(){
        return ++counter;
    }

    @Override
    public String toString() {
        return "Abiturient{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getFullName(){
        return name + " " + surname + " " + patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public boolean hasPoorGrade(){
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 4 && marks[i] > 0)
                return true;
        }
        return false;
    }

    public float getGPA(){
        float gpa = 0.0F;
        for (int i = 0; i < marks.length; i++) {
            gpa += marks[i];
        }
        gpa /= marks.length;
        return (float)(Math.round(gpa * 100)) / 100;
    }

    public boolean isGPAAbove(float gpa) throws GPAIncorrectException{
        if (gpa < 0){
            throw new GPAIncorrectException("Ошибка: Заданный средний балл ниже либо равно нулю.");
        }
        return this.getGPA() >= gpa;
    }


}
