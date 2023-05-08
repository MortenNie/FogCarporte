package dat.backend.model.entities;

public class Spaer {
    private int spaerId;
    private String spaerName;
    private int length;
    private int price;
    private int quantity;

    public Spaer(int spaerId, String spaerName, int length, int price, int quantity) {
        this.spaerId = spaerId;
        this.spaerName = spaerName;
        this.length = length;
        this.price = price;
        this.quantity = quantity;
    }

    public int getSpaerId() {
        return spaerId;
    }

    public String getSpaerName() {
        return spaerName;
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
