package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       Functions func = new Functions();
       func.signUp();
        func.logIn();
       subMain subMain = new subMain();
       subMain.mainFunctions();
    }
}