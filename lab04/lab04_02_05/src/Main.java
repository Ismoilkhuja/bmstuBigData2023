public class Main {
    public static void main(String[] args) {

        // Создание объекта экземпляра класса Model
        Mobile myMobile = new Model("Siemens", "CX75", 2, "Helio G95", 4, 128, "Silver");

        // Вызов методов интерфейса Mobile
        myMobile.call();
        myMobile.sendMessage();

        // Вызов метода класса SiemensMobile
        ((SiemensMobile)myMobile).connectToInternet();

        // Вызов методов класса Model
        System.out.println("CPU: " + ((Model)myMobile).getCPU());
        System.out.println("RAM: " + ((Model)myMobile).getRAM());
        System.out.println("ROM: " + ((Model)myMobile).getROM());
        System.out.println("Color: " + ((Model)myMobile).getColor());

    }
}