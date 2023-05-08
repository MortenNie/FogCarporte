package dat.backend.model.entities;

public class Rem {
    private int remId;
    private String remName;
    private int length;
    private int price;
    private int quantity;

    public Rem(int remId, String remName, int length, int price, int quantity) {
        this.remId = remId;
        this.remName = remName;
        this.length = length;
        this.price = price;
        this.quantity = quantity;
    }

    public int getRemId() {
        return remId;
    }

    public String getRemName() {
        return remName;
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
