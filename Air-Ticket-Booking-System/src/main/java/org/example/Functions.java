package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;


public class Functions implements IFunctions{
    Flights flights = new Flights();
    Scanner scan = new Scanner(System.in);
    private String password,email,name,surname;
    User user = new User(email,password,name,surname);
    ArrayList<String> emailList = new ArrayList<>();
    ArrayList<String> passwordList = new ArrayList<>();
    int choice;

    String destination,departure;
    int ticketPrice;

    @Override
    public void signUp() {
        System.out.println("Enter your email");
        email = scan.next();
        System.out.println("Enter your password");
        password = scan.next();
        System.out.println("Enter your name");
        name = scan.next();
        System.out.println("Enter your surname");
        surname = scan.next();

        emailList.add(email);
        passwordList.add(password);

        user = new User(email,password,name,surname);
        System.out.println("Signed up successfully");
    }

    @Override
    public void logIn() {
        System.out.println(user.getEmail() + " " + user.getPassword());
        System.out.println("Confirm your email and password");
        System.out.println("Enter your email");
        String emailNew,passwordNew;
        emailNew = scan.next();
        while(!(emailList.contains(emailNew))){
            System.out.println("Email is incorrect");
            emailNew = scan.next();
        }
        System.out.println("Email is ok");

        System.out.println("Enter your password");
        passwordNew = scan.next();
        while(!(passwordList.contains(passwordNew))){
            System.out.println("Password is incorrect");
            passwordNew = scan.next();
        }
        System.out.println("Password is ok");
        System.out.println("Logged in successfully");
    }

    public void updateUser(){
        System.out.println("What do you want to do?");
        System.out.println("1 - enter iin\n2 - enter phone number\n3 - enter cash balance\n4 - change data");
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter your iin");
                String iin = scan.next();
                user.setIin(iin);
                break;
            case 2:
                System.out.println("Enter your phone number");
                String phoneNumber = scan.next();
                user.setPhoneNumber(phoneNumber);
                break;
            case 3:
                System.out.println("Enter your cash balance");
                int cash = scan.nextInt();
                user.setCash(cash);
                break;
            case 4:
                System.out.println("What do you want to change?");
                System.out.println("1 - Change email\n2 - Change password\n3 - Change name and surname");
                int choice1 = scan.nextInt();
                if(choice1 == 1){
                    System.out.println("Enter new email");
                    String newEmail = scan.next();
                    user.setEmail(newEmail);
                }
                else if(choice == 2){
                    System.out.println("Enter new password");
                    String newPassword = scan.next();
                    user.setPassword(newPassword);
                }
                else if(choice == 3){
                    System.out.println("Enter your new name");
                    String newName = scan.next();
                    System.out.println("Enter your new surname");
                    String newSurname = scan.next();
                    user.setName(newName);
                    user.setSurname(newSurname);
                }
                break;
            default:
                return;
        }
    }
    /*
    class main:
	system:
		- sign up ()
		- login(username, paswd)
	What is your destination?
	What is the departure city?
	Here we give the timetable of the tickets
	Then he chooses the ticket and pays
	We check the available balance (sufficent or not), iin, phone number
	We deduct the balance from his account.
     */
    public void mainSystem() throws InterruptedException {
        System.out.println("What is your destination");
        destination = scan.next();
        System.out.println("What is your departure");
        departure = scan.next();
        if(destination.equals(flights.flight1.destination) || destination.equals(flights.flight2.destination)){
            if (departure.equals(flights.flight1.departure) || departure.equals(flights.flight2.departure)) {
                System.out.println("Here we give timetable of the tickets:");
                ticketsTimetable();
                System.out.println("Choose one of them");
                buyTicket();
            }
        }

    }
    public void ticketsTimetable(){
        if(destination=="Almaty"){
            choice = 0;
        }
        else if(destination.equals("Astana")){
            choice = 1;
        }
        flights.addFlights();
        System.out.println("Destination:");
        System.out.println(flights.flightss.get(choice).destination);
        System.out.println("Departure:");
        System.out.println(flights.flightss.get(choice).departure);
        System.out.println("Tickets:");
        for(Map.Entry<String,Integer> entry : flights.flightss.get(choice).times.entrySet()){
            System.out.print("[" + entry.getKey() + " " + entry.getValue() + "tg] \n");
        }
        System.out.println(" ");
    }
    public void buyTicket() throws InterruptedException {
        System.out.println("Which one do you want to choose?\nEnter the time:");
        String time = scan.next();
        if(flights.flightss.get(choice).times.containsKey(time)) {
            System.out.println("Your choice is: " + time + " - " + flights.flightss.get(choice).times.get(time));
        }
        System.out.println("Checking your cash...");
        Thread.sleep(1000);
        if(user.getCash()>flights.flightss.get(choice).times.get(time)){
            System.out.println("Your cash is ok");
            int newCash = user.getCash()-flights.flightss.get(choice).times.get(time);
            user.setCash(newCash);
        }
        else{
            System.out.println("You have not enought money");
            int min = Collections.min(flights.flightss.get(choice).times.values());
            if(user.getCash()>min){
                System.out.println("You have enough money to another one, choose another flight");
                buyTicket();
            }
            else{
                System.out.println("You can't buy tickets");
                return;
            }
        }
        System.out.println("Checking your iin");
        Thread.sleep(1000);
        if(!(user.getIin().isEmpty()) || user.getIin().length()==12){
            System.out.println("Your iin is correct");
        }
        else{
            System.out.println("Your iin is incorrect, you can't buy tickets");
        }
        System.out.println("Checking your phone number");
        Thread.sleep(1000);
        if(!(user.getPhoneNumber().isEmpty())){
            System.out.println("Your phone number is available, we'll call");
        }
        else{
            System.out.println("Your phone number is empty");
            return;
        }
        System.out.println("You bought your ticket");
        Thread.sleep(1000);
    }
    public void showInfo(){
        System.out.println("Name: "  + user.getName());
        System.out.println("Surname: "  + user.getSurname());
        System.out.println("Email: "  + user.getEmail());
        System.out.println("Password: "  + user.getPassword());
        System.out.println("IIN: "  + user.getIin());
        System.out.println("Cash: "  + user.getCash());
        System.out.println("Phone number: "  + user.getPhoneNumber());
    }
}
