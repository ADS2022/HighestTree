package mesw.ads.highesttree.HighestTree.controller.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import mesw.ads.highesttree.HighestTree.service.LocationService;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReaderController implements Initializable {

    @FXML
    private TextArea placesTextArea;

    private void changeScene(String SceneName, ActionEvent event) throws IOException {
        Parent MainSceneParent = FXMLLoader.load(getClass().getResource(SceneName));
        Scene MainScene = new Scene(MainSceneParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(MainScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> data = LocationService.getAllLocationsFromFileDatabase();
        for (String element : data) {
            placesTextArea.appendText(element);
            placesTextArea.appendText("\n");
        }
    }

    public void actionBack(ActionEvent actionEvent) throws IOException {
        this.changeScene("/fxml/registerAPlace.fxml", actionEvent);
    }

    public void actionRegisterPlace(ActionEvent actionEvent) throws IOException {
        this.changeScene("/fxml/registerAPlace.fxml", actionEvent);
    }
}
