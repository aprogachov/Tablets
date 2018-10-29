package com.tablet.reader;

import java.util.List;
import java.util.Scanner;

import com.modelsale.model.Patient;
import com.tablet.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuPatient {

    @Autowired
    private IPatientService ipatientService;

    @Autowired
    private MenuMain menuMain;

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n" + "MenuPatient: " +
                    "\n" + "1. Add Patient " +
                    "\n" + "2. Choice Patient" +
                    "\n" + "3. Look All Patients" +
                    "\n" + "4. Update Patient" +
                    "\n" + "5. Delete Patient" +
                    "\n" + "0. return MenuMain");
 
            System.out.println("\n" + "Your choice: ");
                    
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    newPatient();
                    Patient patientMy = new Patient(phone1, StateId1);
                    ipatientService.addPatient(patientMy);
                    System.out.println("\nPatient save: " + patientMy);
                    break;
                case 2:
                    System.out.println("Enter id Patient:");
                    int id2 = sc.nextInt();
                    Patient another = ipatientService.findById(id2);
                    System.out.println("\nPatient found is: " + another.toString());
                    break;
                case 3:
                    List<Patient> patients = ipatientService.findAllPatients();
                    System.out.println("\n" + patients);
                    break;
                case 4:
                    System.out.println("Enter id Patient change:");
                    int id3 = sc.nextInt();
                    Patient ppatient = ipatientService.findById(id3);
                    System.out.println("\nPatient found is: " + ppatient.toString());

                    sc.nextLine();
                    System.out.println("Your new patient Phone: ");
                    String phone2 = sc.nextLine();
                    System.out.println("Your new patient StateId: ");
                    int stateId2 = sc.nextInt();
                    System.out.println("You enter: Phone=" + phone2 +
                            "; StateId=" + stateId2 + "\n");

                    ppatient.setPhone(phone2);
                    ppatient.setStateId(stateId2);
                    ipatientService.updatePatient(ppatient);
                    break;
                case 5:
                    System.out.println("Enter id Patient delete:");
                    int id4 = sc.nextInt();
                    Patient delPatient = ipatientService.findById(id4);
                    System.out.println("\nPatient found is: " + delPatient.toString());
                    ipatientService.deletePatient(delPatient);
                    break;
                case 0:
                    menuMain.menu();
                    break;
            }
        } while (choice!=0);      
        
    System.out.println("Done");
    }

    String phone1;
    int StateId1;

    void newPatient() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter New PATIENT:");
        System.out.println("-------------------------");

        System.out.println("Your patient Phone: ");
        phone1 = input.nextLine();

        System.out.println("Your patient StateId: ");
        StateId1 = input.nextInt();

        System.out.println("You enter: Phone=" + phone1 +
                "; StateId=" + StateId1 + "\n");
    }

}
