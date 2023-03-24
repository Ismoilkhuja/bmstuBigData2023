public abstract class PublicBuilding {
    protected String name;

    public PublicBuilding(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println("Открытие " + name);
    }

    public void close() {
        System.out.println("Закрытие " + name);
    }
}
