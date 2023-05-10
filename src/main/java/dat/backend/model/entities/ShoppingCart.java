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

    public double getTotalPrice(){
        double sum = 0;
        for (Carport p : carports) {
            sum = sum +  (p.getRem().getPrice() * p.getRem().getLength()/100) * p.getRem().getQuantity()+
                    (p.getSpaer().getPrice() * p.getSpaer().getLength()/100)* p.getSpaer().getQuantity() +
                    (p.getStolpe().getPrice() * p.getStolpe().getLength()/100) * p.getStolpe().getQuantity()+
                    (p.getTag().getPrice() * p.getTag().getLength()/100) * p.getTag().getQuantity() ;

        }
        return sum;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "products=" + carports +
                '}';
    }





}
