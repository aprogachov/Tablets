package server.reader;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.model.AuditOperation;
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

}
