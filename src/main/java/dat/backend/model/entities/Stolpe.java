package dat.backend.model.entities;

public class Stolpe {
    private int stolpeId;
    private String stolpeName;
    private int length;
    private int price;
    private int quantity;

    public Stolpe(int stolpeId, String stolpeName, int length, int price, int quantity) {
        this.stolpeId = stolpeId;
        this.stolpeName = stolpeName;
        this.length = length;
        this.price = price;
        this.quantity = quantity;
    }

    public int getStolpeId() {
        return stolpeId;
    }

    public String getStolpeName() {
        return stolpeName;
    }

    public int getLength() {
        return length;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
