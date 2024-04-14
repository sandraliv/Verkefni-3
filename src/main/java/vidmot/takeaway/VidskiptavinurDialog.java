package vidmot.takeaway;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import vinnsla.Vidskiptavinur;

import java.io.IOException;
import java.util.Optional;

public class VidskiptavinurDialog extends Dialog<Vidskiptavinur> {
    @FXML
    private TextField nafn;

    @FXML
    private TextField heimilisfang;

    @FXML
    private ButtonType fxILagi;

    @FXML
    private Label fxSetjaNafn;

    public VidskiptavinurDialog() {
        setDialogPane(setjaDialog());
        iLagiRegla();
        setResultConverter(b -> {                                 // b er af taginu ButtonType
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return new Vidskiptavinur(nafn.getText(), heimilisfang.getText());
            } else if (b.getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE) {
                return null;
            }
            return null;

        });

        // endir á d.setResultConverter

    }


    /**
     * @return skilar DialogPane
     */
    public DialogPane setjaDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vidskiptavinur-view.fxml"));
        try {
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void lesaLykilord() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("lykilord-view.fxml"));
        try {
            fxmlLoader.setController(this);
            setDialogPane(fxmlLoader.load());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        showAndWait();
    }

    private void iLagiRegla() {
        // fletta upp í lagi hnappnum út frá hnappategund
        Node iLagi = getDialogPane().lookupButton(fxILagi);
        iLagi.disableProperty()
                .bind(nafn.textProperty().isEmpty()
                        .or(heimilisfang.textProperty().isEmpty()));
    }

    public Vidskiptavinur getVidskiptavinur() {
        // Dialog birtur og svarið fengið
        Optional<Vidskiptavinur> utkoma = showAndWait();
        return utkoma.orElse(null);
    }
}
