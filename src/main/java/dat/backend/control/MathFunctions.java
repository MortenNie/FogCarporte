package dat.backend.control;

import dat.backend.model.entities.Spaer;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.SpaerFacade;

import java.util.ArrayList;
import java.util.List;

public class MathFunctions {



    public static double nearest(double of, List<Double> in)
    {
        double min = Integer.MAX_VALUE;
        double closest = of;

        for (double v : in)
        {
            final double diff = Math.abs(v - of);

            if (diff < min)
            {
                min = diff;
                closest = v;
            }
        }
        return closest;
    }

    public static int amountOfMaterialSpaer(double carportLength) {
        double spaerDistance = 0.6; // afstanden mellem spærerne skal være 0.60 m.
        return (int) Math.rint((carportLength)/(spaerDistance)); //dette kan optimeres, men det er bare så simpelt som muligt.
    }

    public static Spaer SpaerSelection(double width, double length, ConnectionPool connectionPool) {
        List<Spaer> listOfSpaers = SpaerFacade.getAllSpaer(connectionPool); // find all spaer.
        List<Double> listOfSpaerLengths = new ArrayList<>();
        Spaer finalSpaer = new Spaer();
        for (Spaer s: listOfSpaers) {
            listOfSpaerLengths.add(s.getLength());

        }
        double spaerLength = MathFunctions.nearest(width, listOfSpaerLengths); //find nærmeste længde spær passende til bredden.

        for (Spaer t: listOfSpaers) {
            if (spaerLength == t.getLength()) {
                finalSpaer = t;

            }
        }

        int quantity = MathFunctions.amountOfMaterialSpaer(length); // find mængde spaer.
        finalSpaer.setQuantity(quantity);
        return finalSpaer;
    }



}


