package org.example;

import java.util.Scanner;

public class subMain {
    Scanner scan = new Scanner(System.in);
    Functions functions = new Functions();
    public void mainFunctions() throws InterruptedException {
        System.out.println("Please, fill your user data(iin,phone number,cash)");
        int choicee=0;
        while(choicee!=4){
            System.out.println("What do you want to do?\n1 - Update user\n2 - Buy tickets\n3 - Show info\n4 - Exit");
            choicee = scan.nextInt();
            switch (choicee){
                case 1:
                    functions.updateUser();
                    break;
                case 2:
                    functions.mainSystem();
                    break;
                case 3:
                    functions.showInfo();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Your input is incorrect");
                    break;
            }
        }
    }
}
