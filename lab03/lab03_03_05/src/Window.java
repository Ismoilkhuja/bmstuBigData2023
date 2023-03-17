import java.util.Objects;

public class Window {
    private int width;

    private int height;

    private boolean isOpen;
    public Window(int width, int height, boolean isOpen) {
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
        Window window = (Window) o;
        return width == window.width && height == window.height && isOpen == window.isOpen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, isOpen);
    }


    @Override
    public String toString() {
        return "Window{" +
                "width=" + width +
                ", height=" + height +
                ", isOpen=" + isOpen +
                '}';
    }
}
