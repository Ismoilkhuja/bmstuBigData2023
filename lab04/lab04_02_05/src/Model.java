public class Model extends SiemensMobile{
    private String CPU;
    private int RAM;
    private int ROM;
    private String color;

    public Model(String brand, String model, int batteryLife, String cpu, int ram, int rom,String color) {
        super(brand, model, batteryLife);
        this.color = color;
        this.CPU = cpu;
        this.RAM = ram;
        this.ROM = rom;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCPU() {
        return CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public int getROM() {
        return ROM;
    }

    @Override
    public void connectToInternet() {
        System.out.println("Connecting to the internet using " + getBrand() + " " + getModel());
    }
}
