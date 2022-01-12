package mesw.ads.highesttree.HighestTree.controller.listControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mesw.ads.highesttree.HighestTree.Main;
import mesw.ads.highesttree.HighestTree.controller.ListController;
import mesw.ads.highesttree.HighestTree.model.Person;
import mesw.ads.highesttree.HighestTree.model.database.export.ExportVisitor;
import mesw.ads.highesttree.HighestTree.service.PersonService;

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
public class QueriesController extends ListController {
    private static final String VIEW = "fxml/QueriesView.fxml";

    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> tableColFirstName, tableColLastName;
    @FXML
    private Button btnPersonEdit, btnPersonDelete, btnPersonNew;

    // METHODS

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private Collection<Person> parsePersonList() {
        return PersonService.getAllPersons();
    }



    public void btnPersonEditPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Editing person record");
        changeScene("/fxml/PersonView.fxml", actionEvent);
    }

    public void btnPersonDeletePress(ActionEvent actionEvent) throws IOException {
        System.out.println("Deleting person record");
        //changeScene("/mesw/ads/highesttreemaven/HomeView.fxml", actionEvent);
    }



    public void btnExportToXML(ActionEvent actionEvent) {
        new ExportVisitor(1);
    }

    public void btnExportToCSV(ActionEvent actionEvent) {
        new ExportVisitor(4);
    }
}
