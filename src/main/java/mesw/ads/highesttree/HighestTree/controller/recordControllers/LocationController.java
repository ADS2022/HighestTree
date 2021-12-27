package mesw.ads.highesttree.HighestTree.controller.recordControllers;

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
    private TextArea flsDescription;

    @FXML
    private TextField fldPlaceName, fldCountry, fldDistrict, fldCity, fldStreet;

    @FXML
    public ChoiceBox isSensitive;


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

    public void changeScene(String SceneName, ActionEvent event) throws IOException {
        Parent MainSceneParent = FXMLLoader.load(getClass().getResource(SceneName));
        Scene MainScene = new Scene(MainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(MainScene);
        window.show();
    }

    //'Is sensitive info' Choisebox
    private void fillComboBox() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Block info to users"); //TRUE
        list.add("Show info to users");  //FALSE
        ObservableList<String> sensitiveLevels = FXCollections.observableArrayList(list);
        this.isSensitive.setItems(sensitiveLevels);
    }


    private boolean setSensitivity(String sensitivity) {
        return "YES".equals(sensitivity);
    }


    // REFACTOR - DELETE
    public void actionGoBackBtn(ActionEvent actionEvent) throws IOException {
        try {
            this.changeScene("/fxml/registerAPlace.fxml", actionEvent);
        } catch (IOException ex) {
            this.changeScene(ERROR_SCREEN, actionEvent);
        }
    }

    // REFACTOR
    public void actionViewPlaces(ActionEvent actionEvent) throws IOException {
        try {
            this.changeScene("/fxml/displayPlaces.fxml", actionEvent);
        } catch (IOException ex) {
            this.changeScene(ERROR_SCREEN, actionEvent);
        }
    }

    public void btnSceneHomePress(ActionEvent actionEvent) throws IOException {
        System.out.println("Changing to Home scene");
        changeScene("/mesw/ads/highesttree/HighestTree/HomeView.fxml", actionEvent);
    }

    public void btnAddLocationPress(ActionEvent actionEvent) throws IOException  {
        try {
            // Add a new location to records
            System.out.println("Adding new Location to records");

            String name = fldPlaceName.getText();
            String country = fldCountry.getText();
            String district = fldDistrict.getText();
            String city = fldCity.getText();
            String street = fldStreet.getText();
            String description = flsDescription.getText();
            Boolean sensitive = isSensitive.equals("Block info to users");

            // Service saves location
            LocationService.save(name, country, district, city, street, description, sensitive);
            // Change to another scene
            changeScene("/fxml/LocationsView.fxml", actionEvent);

        } catch (Exception e) {
            e.printStackTrace();
            this.changeScene(ERROR_SCREEN, actionEvent);
        }
    }

    public void btnCancelPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Changing to Locations scene");
        changeScene("/fxml/LocationsView.fxml", actionEvent);
    }
}