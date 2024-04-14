package vidmot.takeaway;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

import java.io.IOException;

public class MatsedilView extends ListView {

    public MatsedilView() {
        FXMLLoader fxmlLoaders = new FXMLLoader(getClass().getResource("matsedill-view.fxml"));
        fxmlLoaders.setRoot(this);
        fxmlLoaders.setController(this);
        try {
            fxmlLoaders.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
