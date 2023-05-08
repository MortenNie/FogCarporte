package dat.backend.model.entities;
import java.util.ArrayList;


public class ShoppingCart {

    private ArrayList<Carport> carports =new ArrayList<>();

    public ShoppingCart() {
    }

    public void addCarport(Carport carport){

        carports.add(carport);
    }

    public ArrayList<Carport> getProducts() {
        return carports;
    }

    public int getSize(){
        return carports.size();
    }

    public int getTotalPrice(){
        int sum = 0;
        for (Carport p : carports) {
            sum = sum +  p.getRem().getPrice() * p.getRem().getQuantity() + p.getSpaer().getPrice() * p.getSpaer().getQuantity() + p.getTag().getPrice() * p.getTag().getQuantity() + p.getStolpe().getPrice() * p.getStolpe().getQuantity();

        }
        return  sum;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "products=" + carports +
                '}';
    }





}
