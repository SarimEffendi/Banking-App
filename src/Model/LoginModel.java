package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import main.FileClass;

public class LoginModel {
    public static Account account;


    public static Account connectAccount(String username) {
        String line;
        boolean accountExists = false;
        try {
            File file = new File("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                line = sc.nextLine();
                if (line.startsWith(username + ", ")) {
                    String[] lineBreakup = line.split(", ");
                    account = new Account(lineBreakup[0], lineBreakup[1], lineBreakup[2], lineBreakup[3]);
                    System.out.println(account.getBalance());
                    accountExists = true;
                }
            }
            if (accountExists == false) {
                Random random = new Random();
                int accountID = random.nextInt(6);
                FileWriter fileWriter = new FileWriter("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt", true);
                fileWriter.write(  username + ", " + accountID + ", 0, 0 \n");
                account = new Account(username, String.valueOf(accountID), "0", "0");
                fileWriter.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return account;
    }

    public static boolean loginUser(String username, String password) {
        boolean login = false;
        boolean showAlert = true;

        try {
            File file = new File("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\sarim.txt");
            Scanner sc = new Scanner(file);
            if (username.isEmpty() || password.isEmpty()) {
                FileClass.error("password or username is empty", "Please enter password and username");

            } else {
                while (sc.hasNext()) {
                    String line = sc.nextLine();
                    if (line.equals("Username = " + username + ", password = " + password)) {
                        connectAccount(username);
                        login = true;
                        showAlert = false;
                    }
                }
                sc.close();
                if (showAlert) {
                    FileClass.error("Incorrect password or username", "Please enter correct username or password");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
        return login;
    }
}
