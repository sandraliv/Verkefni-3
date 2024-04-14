package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Karfa extends Matsedill {
    IntegerProperty heildarverd = new SimpleIntegerProperty();
    protected ObservableList<Veitingar> karfa = FXCollections.observableArrayList();


    public void setHeildarverd(int tala) {
        this.heildarverd.set(heildarverd.getValue() + tala);
    }

    public void minusHeildarverd(int tala) {
        this.heildarverd.set(heildarverd.getValue() - tala);
    }

    public IntegerProperty getHeildarverd() {
        return heildarverd;
    }

}
