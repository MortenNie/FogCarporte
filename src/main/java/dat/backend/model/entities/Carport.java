package dat.backend.model.entities;

public class Carport {
    private int carportId;
    private int width;
    private int length;
    private int height;
    private boolean shed;
    private Spaer spaer;
    private  Rem rem;
    private Stolpe stolpe;
    private Tag tag;

    public Carport(int carportId, int width, int length, int height, boolean shed,
                   Spaer spaer, Rem rem, Stolpe stolpe, Tag tag) {
        this.carportId = carportId;
        this.width = width;
        this.length = length;
        this.height = height;
        this.shed = shed;
        this.spaer = spaer;
        this.rem = rem;
        this.stolpe = stolpe;
        this.tag = tag;
    }

    public int getCarportId() {
        return carportId;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public boolean isShed() {
        return shed;
    }

    public Spaer getSpaer() {
        return spaer;
    }

    public Rem getRem() {
        return rem;
    }

    public Stolpe getStolpe() {
        return stolpe;
    }

    public Tag getTag() {
        return tag;
    }
}
