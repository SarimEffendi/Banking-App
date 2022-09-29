package Controller;

import Model.BankingModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.security.spec.ECField;
import java.util.Objects;

public class BankingController extends Controller {

    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private TextField amount;
    @FXML
    private TextField toUser;
    @FXML
    private TextField funds;
    @FXML
    private TextField getMoney;
    @FXML
    private TextField loanMoney;
    @FXML
    private TextField returnLoan;



    public void transferMoney() {

        try {

            BankingModel.transferMoney(toUser.getText(), amount.getText());

        } catch (Exception e) {

            System.out.println("Error");
            e.printStackTrace();
        }


    }

    public void depositMoney() {
        try {
            BankingModel.depositMoney(funds.getText());
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }

    }

    public void withdrawMoney() {
        try {
            BankingModel.withdrawMoney(getMoney.getText());
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();


        }
    }

    public void loanMoney() {
        try {
            BankingModel.loanMoney(loanMoney.getText());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void returnMoney() {

        try {
            BankingModel.returnLoanMoney(returnLoan.getText());


        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public void back(ActionEvent e) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/UserDashboardView.fxml")));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            System.out.println("error");
            ex.printStackTrace();
        }
    }


}
