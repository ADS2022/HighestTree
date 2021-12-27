package mesw.ads.highesttree.HighestTree.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/** ListControler
 *
 * Template Pattern Abstract Class, used for the controllers
 * in MVC.
 *
 */
public abstract class ListController implements Initializable {

    private static final String ERROR_SCREEN = "/fxml/errorScreen1.fxml";

    @FXML
    private Button btnSceneHome, btnNew, btnEdit, btnDelete;

    @FXML
    public GridPane detailsGrid;
    @FXML
    public Label gridLine1Desc, gridLine1Label;
    @FXML
    public Label gridLine2Desc, gridLine2Label;
    @FXML
    public Label gridLine3Desc, gridLine3Label;
    @FXML
    public Label gridLine4Desc, gridLine4Label;
    @FXML
    public Label gridLine5Desc, gridLine5Label;
    @FXML
    public Label gridLine6Desc, gridLine6Label;
    @FXML
    public Label gridLine7Desc, gridLine7Label;
    @FXML
    public Label gridLine8Desc, gridLine8Label;
    @FXML
    public Label gridLine9Desc, gridLine9Label;


    //Constructor
    public ListController() {
    }

    //Method to change scene (views in JavaFX)
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


}
