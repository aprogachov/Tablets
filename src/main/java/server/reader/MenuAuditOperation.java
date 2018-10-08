package server.reader;

import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.DAO.DAOauditOperationImpl;
import server.DAO.AuditOperationDao;
import server.model.AuditOperation;
import server.service.AuditOperationService;
import server.service.IAuditOperationService;

@Component
public class MenuAuditOperation {

    @Autowired
    private IAuditOperationService iauditOperationService;

    @Autowired
    private MenuMain menuMain;

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n" + "MenuAuditOperation: " +
//                    "\n" + "1. Add AuditOperation " +
                    "\n" + "2. Choice AuditOperation" +
                    "\n" + "3. Look All AuditOperations" +
//                    "\n" + "4. Update AuditOperation" +
                    "\n" + "5. Delete AuditOperation" +
                    "\n" + "0. return MenuMain");
 
            System.out.println("\n" + "Your choice: ");
                    
            choice = sc.nextInt();
            switch (choice) {
//                case 1:
//                    newAuditOperation();
//                    AuditOperation auditOperationMy = new AuditOperation(dateAuditOperation1, status1, action1);
//                    auditOperationService.addAuditOperation(auditOperationMy);
//                    System.out.println("\nAuditOperation save: " + auditOperationMy);
//                    break;
                case 2:
                    System.out.println("Enter id AuditOperation:");
                    int id2 = sc.nextInt();
                    AuditOperation another = iauditOperationService.findById(id2);
                    System.out.println("\nAuditOperation found is: " + another.toString());
                    break;
                case 3:
                    List<AuditOperation> auditOperations = iauditOperationService.findAllAuditOperations();
                    for (AuditOperation auditOperation : auditOperations) {
                        System.out.println(auditOperation.toString());
                    }
                    break;
//                case 4:
//                    System.out.println("Enter id AuditOperation change:");
//                    int id3 = sc.nextInt();
//                    AuditOperation pauditOperation = auditOperationService.findById(id3);
//                    System.out.println("\nAuditOperation found is: " + pauditOperation.toString());
//
//                    sc.nextLine();
//                    System.out.println("Your new auditOperation Status: ");
//                    String status2 = sc.nextLine();
//                    System.out.println("Your new auditOperation Action: ");
//                    String action2 = sc.nextLine();
//
//                    System.out.println("Your AuditOperation Date: ");
// //                    Date dateAuditOperation2 = Calendar.getInstance().getTime();
//                    dateAuditOperation1 = new Date(System.currentTimeMillis());
//
//                    System.out.println("You enter: Date=" + dateAuditOperation2 + "; Status=" + status2 +
//                            "; Action=" + action2 + "\n");
//
//                    pauditOperation.setDateAuditOperation(dateAuditOperation2);
//                    pauditOperation.setStatus(status2);
//                    pauditOperation.setAction(action2);
//                    auditOperationService.updateAuditOperation(pauditOperation);
//                    break;
                case 5:
                    System.out.println("Enter id AuditOperation delete:");
                    int id4 = sc.nextInt();
                    AuditOperation delAuditOperation = iauditOperationService.findById(id4);
                    System.out.println("\nAuditOperation found is: " + delAuditOperation.toString());
                    iauditOperationService.deleteAuditOperation(delAuditOperation);
                    break;
                case 0:
                    menuMain.menu();
                    break;
            }
        } while (choice!=0);      
        
    System.out.println("Done");
    }

//    Date dateAuditOperation1;
//    String status1, action1;
//
//    void newAuditOperation() {
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Enter New AUDITOPERATION:");
//        System.out.println("-------------------------");
//
//        System.out.println("Your AuditOperation Date: ");
// //        dateAuditOperation1 = Calendar.getInstance().getTime();
//        dateAuditOperation1 = new Date(System.currentTimeMillis());
//        System.out.println(dateAuditOperation1);
//
//        System.out.println("Your AuditOperation Status: ");
//        status1 = input.nextLine();
//
//        System.out.println("Your AuditOperation Action: ");
//        action1 = input.nextLine();
//
//        System.out.println("You enter: Date=" + dateAuditOperation1 + "; Status=" + status1 +
//                "; Action=" + action1 + "\n");
//    }

}
