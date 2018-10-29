package com.tablet.reader;

import java.util.List;
import java.util.Scanner;

import com.modelsale.model.State;
import com.tablet.service.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuState {

    @Autowired
    private IStateService istateService;

    @Autowired
    private MenuMain menuMain;

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n" + "MenuState: " +
                    "\n" + "1. Add State " +
                    "\n" + "2. Choice State" +
                    "\n" + "3. Look All States" +
                    "\n" + "4. Update State" +
                    "\n" + "5. Delete State" +
                    "\n" + "0. return MenuMain");
 
            System.out.println("\n" + "Your choice: ");
                    
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    newState();
                    State stateMy = new State(name1, code1);
                    istateService.addState(stateMy);
                    System.out.println("\nState save: " + stateMy);
                    break;
                case 2:
                    System.out.println("Enter id State:");
                    int id2 = sc.nextInt();
                    State another = istateService.findById(id2);
                    System.out.println("\nState found is: " + another.toString());
                    break;
                case 3:
                    List<State> states = istateService.findAllStates();
                    System.out.println("\n" + states);
                    break;
                case 4:
                    System.out.println("Enter id State change:");
                    int id3 = sc.nextInt();
                    State pstate = istateService.findById(id3);
                    System.out.println("\nState found is: " + pstate.toString());

                    sc.nextLine();
                    System.out.println("Your new state Code: ");
                    String code2 = sc.nextLine();
                    System.out.println("Your new state Name: ");
                    String name2 = sc.nextLine();
                    System.out.println("You enter: Code=" + code2 +
                            "; Name=" + name2 + "\n");

                    pstate.setCode(code2);
                    pstate.setName(name2);
                    istateService.updateState(pstate);
                    break;
                case 5:
                    System.out.println("Enter id State delete:");
                    int id4 = sc.nextInt();
                    State delState = istateService.findById(id4);
                    System.out.println("\nState found is: " + delState.toString());
                    istateService.deleteState(delState);
                    break;
                case 0:
                    menuMain.menu();
                    break;
            }
        } while (choice!=0);      
        
    System.out.println("Done");
    }

    String code1, name1;

    void newState() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter New STATE:");
        System.out.println("-------------------------");

        System.out.println("Your state Code: ");
        code1 = input.nextLine();

        System.out.println("Your state Name: ");
        name1 = input.nextLine();

        System.out.println("You enter: Code=" + code1 +
                "; Name=" + name1 + "\n");
    }

}
