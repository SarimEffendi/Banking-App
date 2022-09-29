package Model;

import main.FileClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class BankingModel {

    private static Account targetAccount;

    public static void transferMoney(String targetAccountUsername, String amountToTransfer) {
        String line;
        System.out.println(LoginModel.account.getBalance());
        try {
            File file = new File("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                line = sc.nextLine();
                if (line.startsWith(targetAccountUsername)) {
                    String[] lineBreakup = line.split(", ");
                    targetAccount = new Account(lineBreakup[0], lineBreakup[1], lineBreakup[2], lineBreakup[3]);
                }
            }

            if (targetAccount == null) {
                System.out.println("No Account with the Username " + targetAccountUsername + " exists");
            } else if (Double.parseDouble(LoginModel.account.getBalance()) == 0 ||
                    Double.parseDouble(LoginModel.account.getBalance()) < Double.parseDouble(amountToTransfer)) {
                FileClass.error("Sufficient funds", "deposit money or transfer money from another account ");
            } else {
                Double balanceAfterTransfer = Double.parseDouble(LoginModel.account.getBalance()) - Double.parseDouble(amountToTransfer);
                String setBalance = valueOf(balanceAfterTransfer);
                LoginModel.account.setBalance(setBalance);
                Double balanceAfterTransferForTarget = Double.parseDouble(targetAccount.getBalance()) + Double.parseDouble(amountToTransfer);
                String setBalanceForTarget = valueOf(balanceAfterTransferForTarget);
                targetAccount.setBalance(setBalanceForTarget);
                updateData(targetAccountUsername, setBalanceForTarget, setBalance);

            }
        } catch (FileNotFoundException e) {
            System.out.println("error");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }


    }

    public static void depositMoney(String addedFunds) {
        try {
            String line;
            File file = new File("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt");
            Scanner sc = new Scanner(file);
            ArrayList<String> fileBreakup = new ArrayList<String>();
            while (sc.hasNext()) {
                line = sc.nextLine();
                fileBreakup.add(line);

            }
            Double newBalance = Double.parseDouble(LoginModel.account.getBalance()) + Double.parseDouble(addedFunds);
            System.out.println(newBalance);
            for (int i = 0; i < fileBreakup.size(); i++) {
                if (fileBreakup.get(i).startsWith(LoginModel.account.getName() + ", ")) {
                    String[] lineBreakup = fileBreakup.get(i).split(", ");
                    lineBreakup[2] = valueOf(newBalance);
                    String changeLine = "\n" + lineBreakup[0] + ", " + lineBreakup[1] + ", " + lineBreakup[2] + ", " + lineBreakup[3] + "\n";
                    fileBreakup.set(i, changeLine);

                }
            }
            FileWriter fileWriter = new FileWriter("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt");
            for (String i : fileBreakup) {
                fileWriter.write("\n"+i);
            }
            fileWriter.close();
            FileClass.confirmation("Deposit successful", "Cash deposited  successfully");
            LoginModel.account.setBalance(String.valueOf(newBalance));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void withdrawMoney(String addedFunds) {
        try {
            String line;
            File file = new File("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt");
            Scanner sc = new Scanner(file);
            ArrayList<String> fileBreakup = new ArrayList<String>();
            while (sc.hasNext()) {
                line = sc.nextLine();
                fileBreakup.add(line);

            }
            Double newBalance = Double.parseDouble(LoginModel.account.getBalance()) - Double.parseDouble(addedFunds);
            System.out.println(newBalance);
            for (int i = 0; i < fileBreakup.size(); i++) {
                if (fileBreakup.get(i).startsWith(LoginModel.account.getName() + ", ")) {
                    String[] lineBreakup = fileBreakup.get(i).split(", ");
                    lineBreakup[2] = valueOf(newBalance);
                    String changeLine = "\n" + lineBreakup[0] + ", " + lineBreakup[1] + ", " + lineBreakup[2] + ", " + lineBreakup[3] + "\n";
                    fileBreakup.set(i, changeLine);

                }
            }
            FileWriter fileWriter = new FileWriter("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt");
            for (String i : fileBreakup) {
                fileWriter.write("\n"+i);
            }
            fileWriter.close();
            FileClass.confirmation("Withdrawal  successful", "Cash withdrawn successfully");
            LoginModel.account.setBalance(String.valueOf(newBalance));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void updateData(String targetAccountUsername, String newBalanceForTarget, String newBalanceForSender) {
        try {
            String line;
            File file = new File("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt");
            Scanner sc = new Scanner(file);
            ArrayList<String> fileBreakup = new ArrayList<String>();
            while (sc.hasNext()) {
                line = sc.nextLine();
                fileBreakup.add(line);

            }
            for (int i = 0; i < fileBreakup.size(); i++) {
                if (fileBreakup.get(i).startsWith(targetAccountUsername + ", ")) {
                    String[] lineBreakup = fileBreakup.get(i).split(", ");
                    lineBreakup[2] = newBalanceForTarget;
                    String changeLine = "\n" + lineBreakup[0] + ", " + lineBreakup[1] + ", " + lineBreakup[2] + ", " + lineBreakup[3] + "\n";
                    fileBreakup.set(i, changeLine);
                } else if (fileBreakup.get(i).startsWith(LoginModel.account.getName() + ", ")) {
                    String[] lineBreakup = fileBreakup.get(i).split(", ");
                    lineBreakup[2] = newBalanceForSender;
                    String changeLine = "\n" + lineBreakup[0] + ", " + lineBreakup[1] + ", " + lineBreakup[2] + ", " + lineBreakup[3] + "\n";
                    fileBreakup.set(i, changeLine);

                }
            }
            FileWriter fileWriter = new FileWriter("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt");
            for (String i : fileBreakup) {
                fileWriter.write("\n"+i);
            }
            fileWriter.close();
            FileClass.confirmation("Transfer successful", "Cash Transferred successfully");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loanMoney(String loanRequested) {
        if (Integer.parseInt(loanRequested) > 100000) {
            //cant loan more than 100000 in one go
            FileClass.error("Can't loan more than 100,000 at a time", "Enter loan amount 100,000 or less than 100,000");
        } else {
            try {
                String line;
                File file = new File("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt");
                Scanner sc = new Scanner(file);
                ArrayList<String> fileBreakup = new ArrayList<String>();
                while (sc.hasNext()) {
                    line = sc.nextLine();
                    fileBreakup.add(line);

                }
                for (int i = 0; i < fileBreakup.size(); i++) {
                    if (fileBreakup.get(i).startsWith(LoginModel.account.getName() + ", ")) {
                        String[] lineBreakup = fileBreakup.get(i).split(", ");
                        if ((Double.parseDouble(loanRequested) + Double.parseDouble(lineBreakup[3])) > 500000) {
                            //total money loaned can not exceed 500000
                            FileClass.error("money loaned can't exceed 500,000", "Enter an amount less than 500,000");
                        } else {
                            int newTotalLoan =0;

                            lineBreakup[3] = String.valueOf(Double.parseDouble(lineBreakup[3]) + Double.parseDouble(loanRequested));
                            lineBreakup[2] = String.valueOf(Double.parseDouble(lineBreakup[2]) + Double.parseDouble(loanRequested));
                            String changeLine = "\n" + lineBreakup[0] + ", " + lineBreakup[1] + ", " + lineBreakup[2] + ", " + lineBreakup[3] + "\n";
                            FileClass.confirmation("Loan successful", "Loan has been granted");
                            fileBreakup.set(i, changeLine);
                            FileWriter fileWriter = new FileWriter("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt");
                            for (String s : fileBreakup) {
                                fileWriter.write("\n" + s);
                            }
                            fileWriter.close();
                            LoginModel.account.setBalance(String.valueOf(Double.parseDouble(lineBreakup[2]) + Double.parseDouble(loanRequested)));
                            LoginModel.account.setLoan(String.valueOf(Double.parseDouble(lineBreakup[3]) + Double.parseDouble(loanRequested)));

                        }
                    }
                }

            }catch (NumberFormatException e){
                e.printStackTrace();
                System.out.println("error");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void returnLoanMoney(String returnLoan) {
        if (!(returnLoan.contains("1") || returnLoan.contains("2") || returnLoan.contains("3") || returnLoan.contains("4") ||
                returnLoan.contains("0") || returnLoan.contains("5") || returnLoan.contains("6") || returnLoan.contains("7") ||
                returnLoan.contains("8") || returnLoan.contains("9"))) {
            FileClass.error("Invalid characters", "Please enter numbers");
        } else if (Integer.parseInt(returnLoan) > 500000) {
            //cant loan more than 100000 in one go
            FileClass.error("Can't return more than 100,000", "Return the appropriate loan or a portion of it");
        } else {
            try {
                String line;
                File file = new File("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt");
                Scanner sc = new Scanner(file);
                ArrayList<String> fileBreakup = new ArrayList<String>();
                while (sc.hasNext()) {
                    line = sc.nextLine();
                    fileBreakup.add(line);

                }
                for (int i = 0; i < fileBreakup.size(); i++) {
                    if (fileBreakup.get(i).startsWith(LoginModel.account.getName() + ", ")) {
                        String[] lineBreakup = fileBreakup.get(i).split(", ");
                        if (Double.parseDouble(lineBreakup[2]) >= Double.parseDouble(returnLoan)) {
                            if ((Double.parseDouble(lineBreakup[3]) - Double.parseDouble(returnLoan)) < 0) {
                                //total money loaned can not exceed 500000
                                FileClass.error("Can't pay loan", "Selected ammount more than required");
                            } else if (Double.parseDouble(lineBreakup[3]) == 0) {
                                FileClass.error("Can't pay loan", "No loans to be returned");
                            } else {
                                lineBreakup[3] = String.valueOf(Double.parseDouble(lineBreakup[3]) - Double.parseDouble(returnLoan));
                                lineBreakup[2] = String.valueOf(Double.parseDouble(lineBreakup[2]) - Double.parseDouble(returnLoan));
                                System.out.println(lineBreakup[2]);
                                System.out.println(lineBreakup[3]);
                                String changeLine = "\n" + lineBreakup[0] + ", " + lineBreakup[1] + ", " + lineBreakup[2] + ", " + lineBreakup[3] + "\n";
                                FileClass.confirmation("Loan return successful", "Successfully returned");
                                fileBreakup.set(i, changeLine);
                                FileWriter fileWriter = new FileWriter("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt");
                                for (String s : fileBreakup) {
                                    fileWriter.write("\n" + s);
                                }
                                LoginModel.account.setBalance(String.valueOf(Double.parseDouble(lineBreakup[2]) - Double.parseDouble(returnLoan)));
                                LoginModel.account.setLoan(String.valueOf(Double.parseDouble(lineBreakup[3]) - Double.parseDouble(returnLoan)));
                                fileWriter.close();
                            }
                        } else {
                            FileClass.error("Insufficient funds", "Deposit money");
                        }
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String display(int number){
        String display = "";
        try {
            String line;
            File file = new File("C:\\Users\\sarim\\Documents\\final project oop theory\\Banking App\\Account.txt");
            Scanner sc = new Scanner(file);
            ArrayList<String> fileBreakup = new ArrayList<String>();
            while (sc.hasNext()) {
                line = sc.nextLine();
                fileBreakup.add(line);

            }
            for (int i = 0; i < fileBreakup.size(); i++) {
                if (fileBreakup.get(i).startsWith(LoginModel.account.getName() + ", ")) {
                    String[] lineBreakup = fileBreakup.get(i).split(", ");
                    display = lineBreakup[number];
                }
            }
        }catch(Exception e){

        }
        return display;
    }
}