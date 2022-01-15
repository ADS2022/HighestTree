package mesw.ads.highesttree.HighestTree.controller.listControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import mesw.ads.highesttree.HighestTree.controller.ListController;
import mesw.ads.highesttree.HighestTree.model.Person;
import mesw.ads.highesttree.HighestTree.model.database.export.ExportVisitor;
import mesw.ads.highesttree.HighestTree.query.*;
import mesw.ads.highesttree.HighestTree.service.PersonService;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * 20/12/2021 LNeto
 * To implement the 'template' pattern, this class now
 * extends 'ListController.java'. This class is a ConcreteClass
 * in the 'template' pattern paradigm.
 *
 * 15/01/2022 Sarah
 * This class queries persons.
 * Right now it uses mock up persons to make it easier to test.
 * In the user interface only AND queries can be defined but the functionality and tests for OR queries exist.
 */
public class QueriesController extends ListController {
    private static final String VIEW = "fxml/QueriesView.fxml";
    @FXML
    public TableColumn<Person, String> tableColNationality;

    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> tableColFirstName, tableColLastName;
    @FXML
    private Button btnPersonEdit, btnPersonDelete, btnPersonNew;
    @FXML
    private TextField queryText;

    // METHODS

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        queryText.setText("firstName=James & hasPartner");
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


    public void btnQueryPress(ActionEvent actionEvent) {
        System.out.println("Query Persons");
        String query = queryText.textProperty().get();
        System.out.println(query);

        List<Person> persons = getPersons();

        String[] criteriaStings = query.split("&");
        Criteria crit1 = null;
        Criteria crit2 = null;
        for(String andString : criteriaStings){
            andString = andString.trim();
            System.out.println(andString);
                if(andString.contains("firstName=")){
                    String firstName = andString.split("firstName=")[1];
                    firstName = firstName.trim();
                    crit2 = new CriteriaFirstName(firstName);
                } else if(andString.contains("lastName=")){
                    String lastName = andString.split("lastName=")[1];
                    lastName = lastName.trim();
                    crit2 = new CriteriaLastName(lastName);
                } else if(andString.contains("nationality=")){
                    String nat = andString.split("nationality=")[1];
                    nat = nat.trim();
                    crit2 = new CriteriaNationality(nat);
                } else if(andString.contains("hasPartner")){
                    crit2 = new CriteriaHasPartner();
                } else if(andString.contains("getPartners")){
                    crit2 = new CriteriaSpouses();
                }
                if(crit1 != null && crit2 != null){
                    crit1 = new AndCriteria(crit1, crit2);
                    crit2 = null;
                } else if (crit2 != null){
                    crit1 = crit2;
                }
            }
        List<Person> result = crit1.meetCriteria(persons);
        printPersons(result);
        tableColFirstName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        tableColLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        tableColNationality.setCellValueFactory(new PropertyValueFactory<Person, String>("nationality"));
        tableView.getItems().setAll(result);
    }

    private List<Person> getPersons() {
        Person person_1 = new Person();
        Person person_2 = new Person();
        Person person_3 = new Person();
        Person person_4 = new Person();
        Person person_5 = new Person();

        List<Person> persons = new ArrayList<>();

        person_1.setFirstName("James");
        person_1.setLastName("Arthur");
        person_1.setNationality("germany");

        person_2.setFirstName("Anna");
        person_2.setLastName("Burbon");
        person_2.setNationality("Portugal");

        person_3.setFirstName("James");
        person_3.setLastName("Konner");
        person_3.setNationality("germany");

        person_4.setFirstName("James");
        person_4.setLastName("Maier");
        person_4.setNationality("germany");

        person_5.setFirstName("Mia");
        person_5.setLastName("Maier");
        person_5.setNationality("germany");

        person_1.setRelationships(person_2);
        person_1.setChildren(person_3);
        person_2.setChildren(person_3);
        person_4.setRelationships(person_5);

        persons.add(person_1);
        persons.add(person_2);
        persons.add(person_3);
        persons.add(person_4);
        persons.add(person_5);
        return persons;
    }

    public static void printPersons(List<Person> persons){

        for (Person person : persons) {
            System.out.println("Person : [ FirstName : " + person.getFirstName() + ", LastName : " + person.getLastName() + ", Nationality : " + person.getNationality() +" ]");
        }
    }
}
