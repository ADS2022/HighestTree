package mesw.ads.highesttreemaven;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mesw.ads.highesttreemaven.HighestTree.model.*;

import java.io.IOException;
import java.util.LinkedList;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        //WORKING
        //Javafx window title
        stage.setTitle("HighestTree");

        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("HomeView.fxml"));
        Scene scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {

        launch();
    }

    // MOCK UP DATA FOR UI TEST
    Person parent11 = new Person();
    Person parent21 = new Person();
    Person parent12 = new Person();
    Person parent22 = new Person();
    Person parent1 = new Person();
    Person parent2 = new Person();
   Person targetPerson = new Person();
   Person testParent1Person1 = new Person();
   Person testParent2Person1 = new Person();
   Date testSuperDate = new Date("1999", "09", "30");
   Source testSource = new Source();
   Place testPlace = new Place("Portugal", "Porto", "Porto", "Lapa", "Largo da Lapa, nº1 4050-069 Porto", this.testSource, "Birth place of Francisco Bastos", this.testSuperDate, true);
    Events testStandardEvent1 = Events.BIRTH;
    Event testEvent1 = new Event("Birth of Francisco Bastos", "Birth of Francisco Bastos", testStandardEvent1, this.testSuperDate, this.testPlace, this.testSource, true);
    LinkedList<Person> parentTestPerson1 = new LinkedList();
        //parentTestPerson1.add(this.testParent1Person1);
        //parentTestPerson1.add(this.testParent2Person1);
    LinkedList<Person> partnerTestPerson1 = new LinkedList();
        //partnerTestPerson1.add(this.testPerson2);
        Person testPerson2 = new Person();
        Person testPerson1 = new Person("Francisco José", "Fortuna Bastos", "PRT", this.testEvent1, this.testSource, "A software developer", parentTestPerson1, partnerTestPerson1, true);


}