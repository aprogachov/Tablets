package com.tablet.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuMain {

    @Autowired
    private MenuPatient menuPatient;
    @Autowired
    private MenuProduct menuProduct;
    @Autowired
    private MenuState menuState;
    @Autowired
    private MenuTransaction menuTransaction;
    @Autowired
    private MenuAuditOperation menuAuditOperation ;

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n" + "Hey, our MenuMain: " +
                    "\n" + "1. MenuPatient " +
                    "\n" + "2. MenuProduct" +
                    "\n" + "3. MenuState" +
                    "\n" + "4. MenuTransaction" +
                    "\n" + "5. MenuAuditOperation" +
                    "\n" + "0. Exit");

            System.out.println("\n" + "Your choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    menuPatient.menu();
                    break;
                case 2:
                    menuProduct.menu();
                    break;
                case 3:
                    menuState.menu();
                    break;
                case 4:
                    menuTransaction.menu();
                    break;
                case 5:
                    menuAuditOperation.menu();
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    System.out.println("Done");
    }

}
