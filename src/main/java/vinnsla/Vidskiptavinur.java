package vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Vidskiptavinur {
    private final StringProperty nafn = new SimpleStringProperty();
    private final StringProperty heimilisfang = new SimpleStringProperty();


    public Vidskiptavinur(String nafnid, String heimili) {
        this.nafn.set(nafnid);
        this.heimilisfang.set(heimili);
    }

    public static void main(String[] args) {

    }

    public String getHeimilisfang() {
        return heimilisfang.get();
    }


    public String getNafn() {
        return nafn.get();
    }

}
