package com.company;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;

public class UICoordinator {

    public static void displayAddUser() {
        try{
            BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

            System.out.println("Įveskite vardą");
            String firstName = reader.readLine();
            System.out.println("Įveskite pavardę");
            String lastName = reader.readLine();
            System.out.println("Įveskite telefono numerį");
            String number = reader.readLine();
            while (ValidatorsCoordinator.isPhoneNumberValid(number)==false)
            {
                System.out.println("Ivestas telefono numeris nera validus");
                System.out.println("Įveskite validu telefono numerį");
                number = reader.readLine();
            }
            System.out.println("Įveskite elektroninio pasto adresa");
            String email = reader.readLine();
            while (ValidatorsCoordinator.isEmailValid(email)==false)
            {
                System.out.println("Ivestas elektronino pasto adresas nera validus");
                System.out.println("Įveskite validu elektroninio pasto adresa");
                email = reader.readLine();
            };
            System.out.println("Įveskite adresą");
            String address = reader.readLine();
            System.out.println("Įveskite slaptažodį");
            String password = reader.readLine();
            while (ValidatorsCoordinator.isPasswordValid(password)==false)
            {
                System.out.println("Ivestas slaptazodis nera validus");
                System.out.println("Įveskite validu slaptažodį");
                password = reader.readLine();
            };

            User user = new User(firstName, lastName, number, email, address, password);
            ConnectionToDBCoordinator.insertUser(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int getUserID(){
        Scanner in = new Scanner(System.in);
        System.out.println("Iveskite vartotojo ID");
        int userID = in.nextInt();
        return userID;
    }

    public static void displayDeleteUser(){
        int userID = getUserID();

        ConnectionToDBCoordinator.deleteUser(userID);
    }

    public static void displayEditPhoneNumber() {
        int userID = getUserID();
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        System.out.println("Iveskite kita telefono numeri:");
        try {
            String newPhoneNumber = reader.readLine();
            if (ValidatorsCoordinator.isPhoneNumberValid(newPhoneNumber)==true)
                ConnectionToDBCoordinator.editPhoneNumber(userID,newPhoneNumber);
            else System.out.println("Ivestas telefono numeris nera validus");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayUserData(){
        int userID = getUserID();

        ConnectionToDBCoordinator.selectUser(userID);
    }

    public static void displayChoicePanel() {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        while (choice!=5)
        {
            System.out.println("Pasirinkite:");
            System.out.println("(1) - prideti vartotoja");
            System.out.println("(2) - istrinti vartotoja pagal ID");
            System.out.println("(3) - paredaguoti vartotojo telefono numeri");
            System.out.println("(4) - parodyti vartotojo duomenis");
            System.out.println("(5) - baigti darba");

            choice = in.nextInt();

            switch(choice) {
                case 1:
                    displayAddUser();
                    break;
                case 2:
                    displayDeleteUser();
                    break;
                case 3:
                    displayEditPhoneNumber();
                    break;
                case 4:
                    displayUserData();
                    break;
            }
        }
    }
}
