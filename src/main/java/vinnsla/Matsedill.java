package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Matsedill {
    protected final ObservableList<Veitingar> veitingar = FXCollections.observableArrayList();

    public Matsedill() {
        veitingar.add(new Veitingar("Hamborgari", 1990));
        veitingar.add(new Veitingar("Pylsa með öllu", 490));
        veitingar.add(new Veitingar("Kjötbollur", 1350));
        veitingar.add(new Veitingar("Pizza Margarita", 3150));
        veitingar.add(new Veitingar("Lítill franskar", 470));
        veitingar.add(new Veitingar("Brauðstangir", 999));
        veitingar.add(new Veitingar("Gos", 499));
        veitingar.add(new Veitingar("Ostagott", 990));
        veitingar.add(new Veitingar("Kokteilsósa", 299));
        veitingar.add(new Veitingar("BBQ-sósa", 299));
        veitingar.add(new Veitingar("Chili-Mayo", 299));
    }

    public void setjaGogn(Veitingar b) {
        veitingar.add(b);
    }

    public Veitingar getVeitingar(int index) {
        return veitingar.get(index);
    }

    public void eydaVeitingar(int index) {
        veitingar.remove(index);
    }

    public ObservableList<Veitingar> saekjaLista() {
        return veitingar;
    }

}
