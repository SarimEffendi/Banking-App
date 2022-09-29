package main;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class FileClass {
    @FXML
    public static void error(String reason, String solution){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(reason);
        alert.setContentText(solution);
        alert.showAndWait();

    }
    @FXML
    public static void confirmation(String reason, String solution){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(reason);
        alert.setContentText(solution);
        alert.showAndWait();

    }


    public static void createAccountsFile() {

        try {
            File myfile = new File("C:\\Users\\sarim\\Downloads\\github projects\\final project oop theory\\final project oop theory\\Account.txt");
            if(myfile.createNewFile()){
                System.out.println("Account file created successfully");
            }
            else{
                System.out.println("Account file exists");
            }

        } catch (IOException e) {
            System.out.println("sorry cant create file");
            e.printStackTrace();
        }
    }



    public static void createFile() {

        try {
            File myfile = new File("C:\\Users\\sarim\\Downloads\\github projects\\final project oop theory\\final project oop theory\\sarim.txt");
            if(myfile.createNewFile()){
                System.out.println("file created successfully");
            }
            else{
                System.out.println("file exist already");
            }

        } catch (IOException e) {
            System.out.println("sorry cant create file");
            e.printStackTrace();
        }
    }





}
