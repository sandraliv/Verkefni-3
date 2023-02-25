package vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Vidskiptavinur {
    private StringProperty nafn = new SimpleStringProperty();


    public Vidskiptavinur(StringProperty nafnid) {
        this.nafn = nafnid;
    }

    public static void main(String[] args) {

    }
}
