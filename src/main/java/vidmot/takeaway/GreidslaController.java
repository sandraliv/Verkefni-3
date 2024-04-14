package vidmot.takeaway;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GreidslaController extends PontunController implements Initializable {
    @FXML
    private Label greidsluTexti;

    @FXML
    private Button fxStadfesta;

    @FXML
    private Button fxHaettaVid;

    Stage b = new Stage();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        greidsluTexti.setText("Takk fyrir viðskiptin, pöntun þín verður send á heimilisfangið eftir 25-40 mínútur");
    }

    /**
     * Þegar ýtt er á Staðfesta hnappan þá opnast nýr pöntun-view gluggi
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void fxStadfestaHandler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pontun-view.fxml"));
        b.setScene(new Scene(loader.load()));
        b.setResizable(false);
        b.show();
        fxStadfesta.getScene().getWindow().hide();
    }

    /**
     * Þegar ýtt er á Hætta Við hnappinn þá opnast nýr pöntun-view gluggi
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void fxHaettaVid(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pontun-view.fxml"));
        b.setScene(new Scene(loader.load()));
        b.setResizable(false);
        b.show();
        fxHaettaVid.getScene().getWindow().hide();
    }

}
