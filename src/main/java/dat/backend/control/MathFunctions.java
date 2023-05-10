package dat.backend.control;

import dat.backend.model.entities.Rem;
import dat.backend.model.entities.Spaer;
import dat.backend.model.entities.Stolpe;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.RemFacade;
import dat.backend.model.persistence.SpaerFacade;
import dat.backend.model.persistence.StolpeFacade;

import java.util.ArrayList;
import java.util.List;

public class MathFunctions {


    public static double nearest(double n, List<Double> list) {
        double min = Integer.MAX_VALUE;
        double closest = n;

        for (double v : list) {
            final double diff = Math.abs(v - n);

            if (diff < min) {
                min = diff;
                closest = v;
            }
        }
        return closest;
    }

    public static int amountOfMaterialSpaer(double carportLength) {
        double spaerDistance = 0.6; // afstanden mellem spærerne skal være 0.60 m.
        return (int) Math.rint((carportLength) / (spaerDistance)); //dette kan optimeres, men det er bare så simpelt som muligt.
    }

    public static Spaer SpaerSelection(double width, double length, ConnectionPool connectionPool) {
        List<Spaer> listOfSpaers = SpaerFacade.getAllSpaer(connectionPool); // find all spaer.
        List<Double> listOfSpaerLengths = new ArrayList<>();
        Spaer finalSpaer = new Spaer();
        for (Spaer s : listOfSpaers) {
            listOfSpaerLengths.add(s.getLength());

        }
        double spaerLength = MathFunctions.nearest(width, listOfSpaerLengths); //find nærmeste længde spær passende til bredden.

        for (Spaer t : listOfSpaers) {
            if (spaerLength == t.getLength()) {
                finalSpaer = t;

            }
        }

        int quantity = MathFunctions.amountOfMaterialSpaer(length); // find mængde spaer.
        finalSpaer.setQuantity(quantity);
        return finalSpaer;
    }

    public static Rem RemSelection(double carportLength, ConnectionPool connectionpool) {
        List<Rem> listOfRem = RemFacade.getAllRem(connectionpool);
        List<Double> listOfRemLengths = new ArrayList<>();
        Rem finalRem = new Rem();
        for (Rem s : listOfRem) {
            listOfRemLengths.add(s.getLength());

        }
        double remLength = MathFunctions.nearest(carportLength, listOfRemLengths);

        for (Rem t : listOfRem) {
            if (remLength == t.getLength()) {
                finalRem = t;

            }
        }

        if ((finalRem.getLength()) < carportLength) {
            finalRem.setQuantity(4);
        } else {

            finalRem.setQuantity(2);
        }


        return finalRem;
    }

    public static Stolpe stolpeSelection(double carportLength, double carportHeight, boolean shed, ConnectionPool connectionPool) {
        List<Stolpe> listOfStolpe = StolpeFacade.getAllStolpe(connectionPool);
        List<Double> listOfStolpeLengths = new ArrayList<>();
        Stolpe finalStolpe = new Stolpe();

        for (Stolpe s : listOfStolpe) {
            listOfStolpeLengths.add(s.getLength());

        }
        double stolpeLength = MathFunctions.nearest(carportHeight, listOfStolpeLengths);

        for (Stolpe t : listOfStolpe) {
            if (stolpeLength == t.getLength()) {
                finalStolpe = t;

            }
        }

        if (shed == true && carportLength > 4) {
            finalStolpe.setQuantity(11);

        } else if (shed == false && carportLength > 4) {
            finalStolpe.setQuantity(6);

        } else if (shed == true && carportLength < 4) {
            finalStolpe.setQuantity(9);

        } else {
            finalStolpe.setQuantity(4);

        }
        return finalStolpe;
    }
}


