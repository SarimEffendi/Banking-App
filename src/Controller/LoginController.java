package Controller;

import Model.LoginModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;


public class LoginController extends Controller {
    private Stage stage;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void loginUser(ActionEvent e){
        try{
            if (LoginModel.loginUser(username.getText(),password.getText())){
                System.out.println("login successful");
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/UserDashboardView.fxml")));
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }   else {

            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void createAccountPage(ActionEvent e){

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/RegisterView.fxml")));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
