package mesw.ads.highesttree.HighestTree.controller.location;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mesw.ads.highesttree.HighestTree.service.LocationService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LocationController implements Initializable {

    private static final String ERROR_SCREEN = "/fxml/errorScreen1.fxml";

    @FXML
    private TextField placeName_txt;
    @FXML
    private TextField country_txt;
    @FXML
    private TextField district_txt;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TextField city_txt;
    @FXML
    private TextField street_txt;
    @FXML
    private ChoiceBox<String> sensitiveInformation_optn;

    private void changeScene(String SceneName, ActionEvent event) throws IOException {
        Parent MainSceneParent = FXMLLoader.load(getClass().getResource(SceneName));
        Scene MainScene = new Scene(MainSceneParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(MainScene);
        window.show();
    }

    private void fillComboBox() {
        ArrayList<String> list = new ArrayList<>();
        list.add("YES");
        list.add("NOBODY CARES BRO");
        ObservableList<String> sensitiveLevels = FXCollections.observableArrayList(list);
        this.sensitiveInformation_optn.setItems(sensitiveLevels);
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fillComboBox();
    }

    private boolean setSensitivity(String sensitivity) {
        return "YES".equals(sensitivity);
    }

    public void actionRegisterPlaceBtn(ActionEvent actionEvent) throws IOException {
        try {
            String name = placeName_txt.getText();
            String country = country_txt.getText();
            String district = district_txt.getText();
            String city = city_txt.getText();
            String street = street_txt.getText();
            String description = descriptionTextArea.getText();
            String isSensitive = sensitiveInformation_optn.getSelectionModel().getSelectedItem();
            boolean sensitivity = this.setSensitivity(isSensitive);

            // Service saves location
            LocationService.save(name, country, district, city, street, description, sensitivity);

            this.changeScene("/fxml/displayPlaces.fxml", actionEvent);

        } catch (Exception e) {
            e.printStackTrace();
            this.changeScene(ERROR_SCREEN, actionEvent);
        }

    }

    public void actionGoBackBtn(ActionEvent actionEvent) throws IOException {
        try {
            this.changeScene("/fxml/registerAPlace.fxml", actionEvent);
        } catch (IOException ex) {
            this.changeScene(ERROR_SCREEN, actionEvent);
        }
    }

    public void actionViewPlaces(ActionEvent actionEvent) throws IOException {
        try {
            this.changeScene("/fxml/displayPlaces.fxml", actionEvent);
        } catch (IOException ex) {
            this.changeScene(ERROR_SCREEN, actionEvent);
        }
    }
}
