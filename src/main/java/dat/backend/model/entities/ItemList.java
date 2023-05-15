package dat.backend.model.entities;

public class ItemList {

    Stolpe stolpe;
    Spaer spaer;
    Rem rem;
    Tag tag;

    public ItemList(Stolpe stolpe, Spaer spaer, Rem rem, Tag tag) {
        this.stolpe = stolpe;
        this.spaer = spaer;
        this.rem = rem;
        this.tag = tag;


    }

    public Stolpe getStolpe() {
        return stolpe;
    }

    public Spaer getSpaer() {
        return spaer;
    }

    public Rem getRem() {
        return rem;
    }

    public Tag getTag() {
        return tag;
    }
}

