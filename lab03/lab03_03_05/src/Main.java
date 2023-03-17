import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Window w1 = new Window(60, 100, false);
        Window w2 = new Window(40, 90, true);
        Door d1 = new Door(50, 240, false);

        List<Window> windows = Arrays.asList(w1, w2);
        List<Door> doors = Arrays.asList(d1);

        House house = new House(windows, doors);
        house.lockDoors();
    }
}