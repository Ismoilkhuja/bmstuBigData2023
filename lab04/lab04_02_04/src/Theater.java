public class Theater extends PublicBuilding{
    private int numberOfSeats;
    public Theater(String name, int numberOfSeats) {
        super(name);
        this.numberOfSeats = numberOfSeats;
    }
    public void showPerformance() {
        System.out.println("Показ спектакля в " + name);
    }
}
