package mesw.ads.highesttree.HighestTree.controller.listControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mesw.ads.highesttree.HighestTree.Main;
import mesw.ads.highesttree.HighestTree.controller.ListController;
import mesw.ads.highesttree.HighestTree.model.Location;
import mesw.ads.highesttree.HighestTree.model.database.export.ExportVisitor;
import mesw.ads.highesttree.HighestTree.service.LocationService;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

/**
 * 20/12/2021 LNeto
 * To implement the 'template' pattern, this class now
 * extends 'ListController.java'. This class is a ConcreteClass
 * in the 'template' pattern paradigm.
 */
public class LocationsController extends ListController {
    private static final String VIEW = "fxml/LocationsView.fxml";

    @FXML
    private TableView<Location> tableView;
    @FXML
    private TableColumn<Location, String> tableColDescription;
    @FXML
    private Button btnLocationNew, btnLocationEdit, btnLocationDelete;


    // METHODS

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableColDescription.setCellValueFactory(new PropertyValueFactory<Location, String>("Description"));
        tableView.getItems().setAll(parseLocationList());
        showDetails(null);

        // Detects selection changes and shows the person's details when there is a change.
        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetails(newValue));

        btnLocationNew.setVisible(!Main.isReadOnly);
        btnLocationEdit.setVisible(!Main.isReadOnly);
        btnLocationDelete.setVisible(!Main.isReadOnly);
    }

    private Collection<Location> parseLocationList() {
        return LocationService.getAllLocations();
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

    private void showDetails(Location location) {
        if (location != null) {
            gridLine1Label.setText(location.getCountry());
            gridLine2Label.setText(location.getCity());
            gridLine3Label.setText(location.getDistrict());
            gridLine4Label.setText(location.getParish());
            gridLine5Label.setText(location.getStreet());
            gridLine6Label.setText(location.getDescription());
        } else {
            gridLine1Label.setText("");
            gridLine2Label.setText("");
            gridLine3Label.setText("");
            gridLine4Label.setText("");
            gridLine5Label.setText("");
            gridLine6Label.setText("");
        }
    }

    public void btnExportToXML(ActionEvent actionEvent) {
        new ExportVisitor(2);
    }

    public void btnExportToCSV(ActionEvent actionEvent) {
        new ExportVisitor(5);
    }
}
