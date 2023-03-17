import java.util.List;
import java.util.Objects;

public class House {
    private List<Window> windows;

    private List<Door> doors;

    public House(List<Window> windows, List<Door> doors) {
        this.windows = windows;
        this.doors = doors;
    }

    public void lockDoors(){
        for (Door door :
                doors) {
            door.setOpen(false);
        }
    }

    public int getNumOfWindows(){
        return windows.size();
    }

    public int getNumOfDoors(){
        return doors.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(windows, house.windows) && Objects.equals(doors, house.doors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(windows, doors);
    }

    @Override
    public String toString() {
        return "House{" +
                "windows=" + windows +
                ", doors=" + doors +
                '}';
    }
}
