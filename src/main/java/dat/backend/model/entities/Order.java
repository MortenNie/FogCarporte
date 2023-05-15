package dat.backend.model.entities;

import java.sql.Timestamp;

public class Order {

    private int orderId;
    private String name;
    private String adress;
    private Timestamp date;
    private String status;
    private double price;

    public Order(int orderId, String name, String adress, Timestamp date, String status, double price) {
        this.orderId = orderId;
        this.name = name;
        this.adress = adress;
        this.date = date;
        this.status = status;
        this.price = price;
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

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }
}
