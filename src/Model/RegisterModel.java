package Model;

import main.FileClass;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class RegisterModel {


    public static boolean registerUser(String username, String password, String email, String question, String answer) {
        boolean register = false;
        try {
            if (username.isEmpty() || password.isEmpty() || email.isEmpty() || username.isEmpty() || answer.isEmpty() || question.isEmpty()) {
                FileClass.error("Missing details", "Please Enter all the details");
            } else {
                String line;
                boolean usernameTaken = false;
                boolean emailTaken = false;
                File file = new File("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\sarim.txt");
                Scanner sc = new Scanner(file);
                while (sc.hasNext()) {
                    line = sc.nextLine();
                    System.out.println(line);
                    System.out.println("Email = " + email);
                    if (line.startsWith("Username = " + username)) {
                        FileClass.error("The username already exist", "Please Enter a new username");
                        usernameTaken = true;

                    } else if (!usernameTaken) {
                        if (line.startsWith("Email = " + email)){
                            FileClass.error("The email already exist", "Please enter a new email");
                        emailTaken = true;
                        }
                    }
                }

                if (usernameTaken == false && emailTaken == false) {
                    System.out.println(1);
                    FileWriter fileWriter = new FileWriter("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\sarim.txt", true);
                    fileWriter.write("\n" + "Username = " + username + ", password = " + password + "\n" + "Email = " + email +
                            ", Security question = " + question + ", Answer = " + answer + ",\n" + "Next user" + "\n");
                    fileWriter.close();
                    FileClass.confirmation("Registered  successfully ", "Welcome");
                    register = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return register;
    }
}

