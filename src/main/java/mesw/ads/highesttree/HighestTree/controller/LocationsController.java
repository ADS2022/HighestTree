package mesw.ads.highesttree.HighestTree.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mesw.ads.highesttree.HighestTree.model.Location;
import mesw.ads.highesttree.HighestTree.model.Person;
import mesw.ads.highesttree.HighestTree.service.LocationService;
import mesw.ads.highesttree.HighestTree.service.PersonService;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class LocationsController {

    @FXML
    private TableView<Location> tableView;

    @FXML
    private TableColumn<Location, String> descriptionColumn;

    @FXML
    private Label countryCol, countryLabel, cityCol,
    cityLabel, districtCol, districtLabel, parishCol,
            parishLabel, streetLabel, descriptionLabel,
            streetCol, descriptionCol;

    @FXML
    private Button btnSceneHome, btnLocationNew, btnLocationEdit, btnLocationDelete;

    private Collection<Location> parseLocationList() {
        return LocationService.getAllLocations();
    }

    public void changeScene(String SceneName, ActionEvent event) throws IOException {
        Parent MainSceneParent = FXMLLoader.load(getClass().getResource(SceneName));
        Scene MainScene = new Scene(MainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(MainScene);
        window.show();
    }

    public void btnSceneHomePress(ActionEvent actionEvent) throws IOException {
        System.out.println("Changing to Home scene");
        changeScene("/mesw/ads/highesttree/HighestTree/HomeView.fxml", actionEvent);
    }

    public void btnLocationNewPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Adding new Location record");
        changeScene("/fxml/LocationView.fxml", actionEvent);
    }

    public void btnLocationEditPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Editing location record");
        changeScene("/fxml/LocationView.fxml", actionEvent);
    }

    public void btnLocationDeletePress(ActionEvent actionEvent) throws IOException {
        System.out.println("Deleting location record");
        //changeScene("/mesw/ads/highesttreemaven/HomeView.fxml", actionEvent);

    }


    //TODO: Locations controller is asking for a interface
    //@Override
    public void initialize(URL location, ResourceBundle resources) {
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Location, String>("Name"));
        tableView.getItems().setAll(parseLocationList());
        showPersonDetails(null);

        // Detects selection changes and shows the person's details when there is a change.
        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    private void showPersonDetails(Location location) {
        if (location != null) {
            countryLabel.setText(location.getCountry());
            cityLabel.setText(location.getCity());
            districtLabel.setText(location.getDistrict());
            parishLabel.setText(location.getParish());
            streetLabel.setText(location.getStreet());
            descriptionLabel.setText(location.getDescription());
        } else {
            countryLabel.setText("");
            cityLabel.setText("");
            districtLabel.setText("");
            parishLabel.setText("");
            streetLabel.setText("");
            descriptionLabel.setText("");
        }
    }
}
