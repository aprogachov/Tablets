package server.reader;

import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import server.DAO.DAOtransactionImpl;
import server.DAO.TransactionDao;
import server.model.Transaction;
import server.service.TransactionService;

@Component
public class MenuTransaction {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private MenuMain menuMain;

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n" + "MenuTransaction: " +
                    "\n" + "1. Add Transaction " +
                    "\n" + "2. Choice Transaction" +
                    "\n" + "3. Look All Transactions" +
                    "\n" + "4. Update Transaction" +
                    "\n" + "5. Delete Transaction" +
                    "\n" + "0. return MenuMain");
 
            System.out.println("\n" + "Your choice: ");
                    
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    newTransaction();
                    Transaction transactionMy = new Transaction(patientId1, productId1, dateTransaction1);
                    transactionService.addTransaction(transactionMy);
                    System.out.println("\nTransaction save: " + transactionMy);
                    break;
                case 2:
                    System.out.println("Enter id Transaction:");
                    int id2 = sc.nextInt();
                    Transaction another = transactionService.findById(id2);
                    System.out.println("\nTransaction found is: " + another.toString());
                    break;
                case 3:
                    List<Transaction> transactions = transactionService.findAllTransactions();
                    for (Transaction transaction : transactions) {
                        System.out.println(transaction.toString());
                    }
                    break;
                case 4:
                    System.out.println("Enter id Transaction change:");
                    int id3 = sc.nextInt();
                    Transaction ptransaction = transactionService.findById(id3);
                    System.out.println("\nTransaction found is: " + ptransaction.toString());

                    sc.nextLine();
                    System.out.println("Your new transaction PatientId: ");
                    int patientId2 = sc.nextInt();
                    System.out.println("Your new transaction ProductId: ");
                    int productId2 = sc.nextInt();

                    System.out.println("Your Transaction Date: ");
                    Date dateTransaction2 = Calendar.getInstance().getTime();

                    System.out.println("You enter: PatientId=" + patientId2 +
                            "; ProductId=" + productId2 + " Date: " + dateTransaction2 + "\n");

                    ptransaction.setPatientId(patientId2);
                    ptransaction.setProductId(productId2);
                    ptransaction.setDateTransaction(dateTransaction2);
                    transactionService.updateTransaction(ptransaction);
                    break;
                case 5:
                    System.out.println("Enter id Transaction delete:");
                    int id4 = sc.nextInt();
                    Transaction delTransaction = transactionService.findById(id4);
                    System.out.println("\nTransaction found is: " + delTransaction.toString());
                    transactionService.deleteTransaction(delTransaction);
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
        dateTransaction1 = Calendar.getInstance().getTime();
        System.out.println(dateTransaction1);

        System.out.println("You enter: PatientId" + patientId1 +
                "; ProductId=" + productId1 + "Date" + dateTransaction1 + "\n");
    }

}
