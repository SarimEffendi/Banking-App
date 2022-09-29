package Controller;

import Model.RegisterModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class RegisterController extends Controller implements Initializable {
    private Stage stage;

    @FXML
    private ComboBox<String> cb;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private TextField answer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("City of birth?", "Favourite Dog", "Favorite food", "Favorite color");
        cb.setItems(list);
    }

    public void register() {
        try {
            if (RegisterModel.registerUser(username.getText(), password.getText(), email.getText(), cb.getSelectionModel().getSelectedItem(), answer.getText())) {

            } else {

            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }
    public void loginPage(ActionEvent e){

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/LoginView.fxml")));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

