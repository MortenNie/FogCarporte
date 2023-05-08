package dat.backend.model.entities;

import java.sql.Timestamp;

public class Order {

    private int orderId;
    private String name;
    private String adress;
    private Timestamp date;

    public Order(int orderId, String name, String adress, Timestamp date) {
        this.orderId = orderId;
        this.name = name;
        this.adress = adress;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public Timestamp getDate() {
        return date;
    }
}
