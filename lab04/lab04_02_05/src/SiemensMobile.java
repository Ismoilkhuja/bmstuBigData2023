public abstract class SiemensMobile implements Mobile{
    private String brand;
    private String model;
    private int batteryLife;

    public SiemensMobile(String brand, String model, int batteryLife) {
        this.brand = brand;
        this.model = model;
        this.batteryLife = batteryLife;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public abstract void connectToInternet();

    public void call() {
        System.out.println("Calling from " + brand + " " + model);
    }

    public void sendMessage() {
        System.out.println("Sending message from " + brand + " " + model);
    }
}
