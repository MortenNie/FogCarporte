package dat.backend.model.entities;

public class Tag {
    private int tagId;
    private String tagName;
    private int length;
    private int price;
    private int quantity;

    public Tag(int tagId, String tagName, int length, int price, int quantity) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.length = length;
        this.price = price;
        this.quantity = quantity;
    }

    public int getTagId() {
        return tagId;
    }

    public String getTagName() {
        return tagName;
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
