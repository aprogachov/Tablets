package com.tablet.reader;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.tablet.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tablet.service.ITransactionService;

@Component
public class MenuTransaction {

    @Autowired
    private ITransactionService itransactionService;

    @Autowired
    private MenuMain menuMain;

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n" + "MenuTransaction: " +
                    "\n" + "1. SALE (Add Transaction) " +
                    "\n" + "2. Choice Transaction" +
                    "\n" + "3. Look All Transactions" +
//                    "\n" + "4. Update Transaction" +
                    "\n" + "5. Delete Transaction" +
                    "\n" + "0. return MenuMain");
 
            System.out.println("\n" + "Your choice: ");
                    
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    newTransaction();
                    Transaction transactionMy = new Transaction(patientId1, productId1, dateTransaction1);
                    try {
                        itransactionService.addTransaction(transactionMy);
                        System.out.println("\nTransaction save: " + transactionMy);
                    } catch (Exception e) {
                        e.printStackTrace();
//                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("Enter id Transaction:");
                    int id2 = sc.nextInt();
                    Transaction another = itransactionService.findById(id2);
                    System.out.println("\nTransaction found is: " + another.toString());
                    break;
                case 3:
                    List<Transaction> transactions = itransactionService.findAllTransactions();
                    for (Transaction transaction : transactions) {
                        System.out.println(transaction.toString());
                    }
                    break;

                case 5:
                    System.out.println("Enter id Transaction delete:");
                    int id4 = sc.nextInt();
                    Transaction delTransaction = itransactionService.findById(id4);
                    System.out.println("\nTransaction found is: " + delTransaction.toString());
                    itransactionService.deleteTransaction(delTransaction);
                    break;
                case 0:
                    menuMain.menu();
                    break;
            }
        } while (choice!=0);      
        
    System.out.println("Done");
    }

    int patientId1, productId1;
    Date dateTransaction1;

    void newTransaction() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter New TRANSACTION:");
        System.out.println("-------------------------");

        System.out.println("Your Transaction PatientId: ");
        patientId1 = input.nextInt();

        System.out.println("Your Transaction ProductId: ");
        productId1 = input.nextInt();

        System.out.println("Your Transaction Date: ");
//        dateTransaction1 = Calendar.getInstance().getTime();
        dateTransaction1 = new Date(System.currentTimeMillis());
        System.out.println(dateTransaction1);

        System.out.println("You enter: PatientId" + patientId1 +
                "; ProductId=" + productId1 + "; Date=" + dateTransaction1 + "\n");
    }

}
