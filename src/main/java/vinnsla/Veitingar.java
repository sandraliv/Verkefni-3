package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Veitingar {
    private StringProperty matur = new SimpleStringProperty();
    private IntegerProperty verd = new SimpleIntegerProperty();

    public Veitingar(String hvad, int hvernig) {
        this.matur.set(hvad);
        this.verd.set(hvernig);
    }

    public String toString() {
        return matur.toString() + verd.toString();
    }

    public static void main(String[] args) {

    }
}
