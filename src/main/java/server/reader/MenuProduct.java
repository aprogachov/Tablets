package server.reader;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import server.DAO.DAOproductImpl;
import server.DAO.ProductDao;
import server.model.Product;
import server.service.IProductService;
import server.service.ProductService;

@Component
public class MenuProduct {

    @Autowired
    private IProductService iproductService;

    @Autowired
    private MenuMain menuMain;

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n" + "MenuProduct: " +
                    "\n" + "1. Add Product " +
                    "\n" + "2. Choice Product" +
                    "\n" + "3. Look All Products" +
                    "\n" + "4. Update Product" +
                    "\n" + "5. Delete Product" +
                    "\n" + "0. return MenuMain");
 
            System.out.println("\n" + "Your choice: ");
                    
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    newProduct();
                    Product productMy = new Product(name1, StateId1);
                    iproductService.addProduct(productMy);
                    System.out.println("\nProduct save: " + productMy);
                    break;
                case 2:
                    System.out.println("Enter id Product:");
                    int id2 = sc.nextInt();
                    Product another = iproductService.findById(id2);
                    System.out.println("\nProduct found is: " + another.toString());
                    break;
                case 3:
                    List<Product> products = iproductService.findAllProducts();
                    System.out.println("\n" + products);
                    break;
                case 4:
                    System.out.println("Enter id Product change:");
                    int id3 = sc.nextInt();
                    Product pproduct = iproductService.findById(id3);
                    System.out.println("\nProduct found is: " + pproduct.toString());

                    sc.nextLine();
                    System.out.println("Your new product Name: ");
                    String name2 = sc.nextLine();
                    System.out.println("Your new product StateId: ");
                    int stateId2 = sc.nextInt();
                    System.out.println("You enter: Name=" + name2 +
                            "; StateId=" + stateId2 + "\n");

                    pproduct.setName(name2);
                    pproduct.setStateId(stateId2);
                    iproductService.updateProduct(pproduct);
                    break;
                case 5:
                    System.out.println("Enter id Product delete:");
                    int id4 = sc.nextInt();
                    Product delProduct = iproductService.findById(id4);
                    System.out.println("\nProduct found is: " + delProduct.toString());
                    iproductService.deleteProduct(delProduct);
                    break;
                case 0:
                    menuMain.menu();
                    break;
            }
        } while (choice!=0);      
        
    System.out.println("Done");
    }

    String name1;
    int StateId1;

    void newProduct() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter New PRODUCT:");
        System.out.println("-------------------------");

        System.out.println("Your product Name: ");
        name1 = input.nextLine();

        System.out.println("Your product StateId: ");
        StateId1 = input.nextInt();

        System.out.println("You enter: Name=" + name1 +
                "; StateId=" + StateId1 + "\n");
    }

}
