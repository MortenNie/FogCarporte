package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Spaer;
import dat.backend.model.persistence.ConnectionPool;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathFunctionsTest {

    double width = 6.0;
    double length = 7.8;
    double height = 2.1;
    List<Double> listOfDoubles = new ArrayList<>();

    @Test
    void nearest() {
        listOfDoubles.add(5.0);
        listOfDoubles.add(1.0);
        listOfDoubles.add(3.0);
        double y = MathFunctions.nearest(4.5, listOfDoubles);
        assertEquals(5.0, y);

    }

    @Test
    void amountOfMaterialSpaer() {
        int x = MathFunctions.amountOfMaterialSpaer(length);
        assertEquals(13,x);
    }



    @Test
    void amountOfMaterialTag() {
        int x = MathFunctions.amountOfMaterialTag(length);
        assertEquals(8,x);
    }




    @Test
    void priceWithDaekningsGrad() {
        double y = MathFunctions.priceWithDaekningsGrad(10000,0.40);
        assertEquals(14000, y);
    }
}