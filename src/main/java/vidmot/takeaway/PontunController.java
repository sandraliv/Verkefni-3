package vidmot.takeaway;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vinnsla.Karfa;
import vinnsla.Matsedill;
import vinnsla.Veitingar;
import vinnsla.Vidskiptavinur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PontunController implements Initializable {

    private int virkurIndex = 0;
    private int virkur = 0;

    Matsedill matsedill = new Matsedill();
    Karfa pantad = new Karfa();
    int b = 0;
    @FXML
    private ListView<Veitingar> matur;

    @FXML
    private ListView<Veitingar> pontun;

    @FXML
    private TextField upphaed;

    @FXML
    private Button innskraning;

    @FXML
    private Button fxGreida;


    VidskiptavinurDialog d = new VidskiptavinurDialog();
    Vidskiptavinur hallo;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        pantad.saekjaLista().clear();


        pontun.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Indexinn í körfu.
            virkur = pontun.getSelectionModel().getSelectedIndex();
        });

        matur.setItems(matsedill.saekjaLista());
        matur.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Indexinn í matsedli.
            virkurIndex = matur.getSelectionModel().getSelectedIndex();
        });


        upphaed.textProperty().bind(pantad.getHeildarverd().asString());
        fxGreida.disableProperty().bind(Bindings.createBooleanBinding(
                () -> innskraning.getText().equals("Innskráning"),
                innskraning.textProperty()
        ));


    }

    /**
     * Setur valda vöru í körfuna
     */
    @FXML
    private void baetaHandler() {
        if (virkurIndex != -1) {
            pantad.setjaGogn(matsedill.getVeitingar(virkurIndex));
            pontun.setItems(pantad.saekjaLista());
            pantad.setHeildarverd(matsedill.getVeitingar(virkurIndex).getVerd());
        }
    }

    /**
     * Varnarbúnaður svo valið index á matseðli sé örugglega rétt.
     */
    @FXML
    private void indexHandler() {
        virkur = pontun.getSelectionModel().getSelectedIndex();
    }

    /**
     * Opnar Greidslu-view gluggann
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void fxGreidaHandler(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PontunApplication.class.getResource("greidsla-view.fxml"));
        fxmlLoader.setController(this);
        Parent root = FXMLLoader.load(fxmlLoader.getLocation());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Setur nafnið á takkanum sem nafnið á viðskiptavininum
     * Eftir það skipti á að opnast gluggi sem tekur inn lykilorð
     */
    @FXML
    public void fxInnskra() {
        if (b >= 1) {
            VidskiptavinurDialog e = new VidskiptavinurDialog();
            e.lesaLykilord();
        }
        hallo = d.getVidskiptavinur();
        if (hallo != null) {
            b++;
            innskraning.setText("Hæ, " + hallo.getNafn());
        }


    }

    /**
     * Eyðir vöru úr matseðli
     */
    @FXML
    private void eydaHandler() {
        if (virkur != -1) {
            pantad.minusHeildarverd(pantad.getVeitingar(virkur).getVerd());
            pantad.eydaVeitingar(virkur);
        }


    }

}
