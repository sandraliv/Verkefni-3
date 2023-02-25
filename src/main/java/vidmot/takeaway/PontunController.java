package vidmot.takeaway;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import vinnsla.Veitingar;

public class PontunController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        Veitingar b = new Veitingar("hamborgari", 1990);
        System.out.println(b);
    }


}
