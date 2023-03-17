import java.util.Objects;

public class Door {
    private int width;

    private int height;

    private boolean isOpen;
    public Door(int width, int height, boolean isOpen) {
        this.width = width;
        this.height = height;
        this.isOpen = isOpen;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Door door = (Door) o;
        return width == door.width && height == door.height && isOpen == door.isOpen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, isOpen);
    }

    @Override
    public String toString() {
        return "Door{" +
                "width=" + width +
                ", height=" + height +
                ", isOpen=" + isOpen +
                '}';
    }
}
